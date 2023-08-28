package com.example.brainfusion.apiCall;

import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.example.brainfusion.activity.MainActivity2;
import com.example.brainfusion.apiInterface.ApiService;
import com.example.brainfusion.apiInterface.CallBackService;
import com.example.brainfusion.model.ImageResponseModel;
import com.example.brainfusion.model.UidModel;
import com.example.brainfusion.utils.Constants;

import java.util.ArrayList;
import java.util.Base64;
import java.util.Objects;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Run {

    public static String uuid = "";

    public ArrayList<String> images;

    private Context context;

    private ApiService apiService;

    public Run(Context context) {

        images = new ArrayList<>();


        this.context = context;

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .addNetworkInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASEAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        apiService = retrofit.create(ApiService.class);
    }


    public void run(String query, String style, String[] res, CallBackService callBackService ) {

//        WebKitGenerator webKitGenerator = new WebKitGenerator();
//        String boundary = webKitGenerator.generateBoundaryString();



        // Raw Body Text
        // Boundary Text '-----------------------------292652377033076412113837393474' Can Be Changed But Should be save everywhere except at the Body End

        String rawTextBody = "-----------------------------292652377033076412113837393474" + "\r\n" +
                "Content-Disposition: form-data; name=\"params\"; filename=\"blob\"\r\n" +
                "Content-Type: application/json\r\n\r\n" +
                "{\"type\":\"GENERATE\",\"style\":\"" + style + "\",\"width\":" + res[0] + ",\"height\":" + res[1] + ",\"generateParams\":{\"query\":\"" + query + "\"}}\r\n" +
                "-----------------------------292652377033076412113837393474" + "--";


        RequestBody requestBody = RequestBody.Companion.create(rawTextBody, okhttp3.MediaType.parse("multipart/form-data"));
        Call<UidModel> call = apiService.runQuery("multipart/form-data; boundary=" + "---------------------------292652377033076412113837393474", requestBody);
        call.enqueue(new Callback<UidModel>() {
            @Override
            public void onResponse(Call<UidModel> call, Response<UidModel> response) {
                assert response.body() != null;
                uuid = response.body().getUuid().toString();

                runImage(uuid, callBackService);

            }

            @Override
            public void onFailure(Call<UidModel> call, Throwable t) {
                Log.d("UUIDAPICALL", Objects.requireNonNull(t.getCause()).toString());
            }
        });

    }


    //Recursive Method, Calls Interface Method after Image is found
    public String runImage(String uuid, CallBackService callBackService) {
        Call<ImageResponseModel> call = apiService.getImageBase(uuid);
        call.enqueue(new Callback<ImageResponseModel>() {
            @Override
            public void onResponse(Call<ImageResponseModel> call, Response<ImageResponseModel> response) {
                if (response.isSuccessful() && response.body() != null) {
                    images = response.body().getImages();
                    if (response.body().getImages() == null) {
                        runImage(uuid, callBackService);
                    } else
                        callBackService.onImageFound(response.body().getImages().get(0).toString());
                }
            }

            @Override
            public void onFailure(Call<ImageResponseModel> call, Throwable t) {
                Log.d("RunTag", "Failed to get Image");
                callBackService.onImageFound(null);
            }
        });


        return "";
    }




}
