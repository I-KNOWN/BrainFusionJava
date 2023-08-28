package com.example.brainfusion.apiCall;

import com.example.brainfusion.apiInterface.ApiService;
import com.example.brainfusion.model.UidModel;

import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
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
                .baseUrl("https://api.fusionbrain.ai/web/api/v1/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build();

        apiService = retrofit.create(ApiService.class);
    }


    public String run(String query) throws Exception {

//        String requestBody =
//                "{type:GENERATE,style:DEFAULT,width:1024,height:576,generateParams:{query:train}}";

        String rawTextBody = "-----------------------------292652377033076412113837393474\r\n" +
                "Content-Disposition: form-data; name=\"params\"; filename=\"blob\"\r\n" +
                "Content-Type: application/json\r\n\r\n" +
                "{\"type\":\"GENERATE\",\"style\":\"DEFAULT\",\"width\":1024,\"height\":1024,\"generateParams\":{\"query\":\"train\"}}\r\n" +
                "-----------------------------292652377033076412113837393474--";

        RequestBody requestBody = RequestBody.create(okhttp3.MediaType.parse("multipart/form-data"), rawTextBody);

        Call<UidModel> call = apiService.runQuery(requestBody);
        retrofit2.Response<UidModel> response = call.execute();

        if (response.isSuccessful()) {
            assert response.body() != null;
            String uuid = response.body().getUuid().toString();
            return uuid;
        } else {
            throw new Exception("run code: " + response.raw());
        }
    }

}
