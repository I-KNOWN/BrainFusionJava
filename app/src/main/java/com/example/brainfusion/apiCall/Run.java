package com.example.brainfusion.apiCall;

import android.util.Log;

import com.example.brainfusion.apiInterface.ApiService;
import com.example.brainfusion.model.UidModel;
import com.example.brainfusion.utils.Constants;
import com.example.brainfusion.utils.WebKitGenerator;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Run {


    private ApiService apiService;

    public Run() {

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(logging)
                .build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Constants.BASEAPI)
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        apiService = retrofit.create(ApiService.class);
    }


    public void run(String query, String style, String[] res) {

//        WebKitGenerator webKitGenerator = new WebKitGenerator();
//        String boundary = webKitGenerator.generateBoundaryString();

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
                String uuid = response.body().getUuid().toString();
                Log.d("UUIDAPICALL", uuid);
            }
            @Override
            public void onFailure(Call<UidModel> call, Throwable t) {
                Log.d("UUIDAPICALL", t.getCause().toString());
            }
        });

    }
}
