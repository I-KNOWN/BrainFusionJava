package com.example.brainfusion.apiInterface;

import static com.example.brainfusion.utils.Constants.ORIGIN;
import static com.example.brainfusion.utils.Constants.REFERER;
import static com.example.brainfusion.utils.Constants.UUIDENDPOINT;

import com.example.brainfusion.model.UidModel;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface ApiService {
    @Headers({
            "Accept: */*",
            "Accept-Language: en-US,en;q=0.9,en-GB;q=0.8",
            "Cache-Control: no-cache",
            "Connection: keep-alive",
            "Origin: "+ORIGIN,
            "Pragma: no-cache",
            "Referer: "+REFERER,
            "User-Agent: Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/114.0.0.0 Safari/537.36",
            "sec-ch-ua: \"Not.A/Brand\";v=\"8\", \"Chromium\";v=\"114\", \"Google Chrome\";v=\"114\""
    })
    @POST(UUIDENDPOINT)
    Call<UidModel> runQuery(@Header("Content-Type") String data, @Body RequestBody requestBody);



}
