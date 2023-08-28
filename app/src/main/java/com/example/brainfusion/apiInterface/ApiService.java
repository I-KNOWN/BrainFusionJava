package com.example.brainfusion.apiInterface;

import com.example.brainfusion.model.UidModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {
    @Headers({
            "Accept: */*",
            "Accept-Language: en-US,en;q=0.9,en-GB;q=0.8",
            "Cache-Control: no-cache",
            "Connection: keep-alive",
            "Content-Type: multipart/form-data; boundary=---------------------------292652377033076412113837393474",
            "Origin: https://editor.fusionbrain.ai",
            "Pragma: no-cache",
            "Referer: https://editor.fusionbrain.ai/",
            "User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36",
            "sec-ch-ua: \"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\""
    })
    @POST("text2image/run?model_id=1")
    Call<UidModel> runQuery(@Body RequestBody requestBody);
}
