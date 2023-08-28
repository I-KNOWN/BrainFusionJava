package com.example.brainfusion.apiInterface;

import static com.example.brainfusion.utils.Constants.BASEAPIIMAGE;
import static com.example.brainfusion.utils.Constants.IMAGEENDPOINT;
import static com.example.brainfusion.utils.Constants.ORIGIN;
import static com.example.brainfusion.utils.Constants.REFERER;
import static com.example.brainfusion.utils.Constants.SEC_CH_UA;
import static com.example.brainfusion.utils.Constants.USERAGENT;
import static com.example.brainfusion.utils.Constants.UUIDENDPOINT;

import android.media.Image;

import com.example.brainfusion.model.ImageResponseModel;
import com.example.brainfusion.model.UidModel;
import com.google.gson.JsonObject;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface ApiService {


    @Headers({
            "Accept: */*",
            "Accept-Language: en-US,en;q=0.9,en-GB;q=0.8",
            "Cache-Control: no-cache",
            "Connection: keep-alive",
            "Origin: "+ORIGIN,
            "Pragma: no-cache",
            "Referer: "+REFERER,
            "User-Agent: "+USERAGENT,
            "sec-ch-ua: "+SEC_CH_UA
    })
    @POST(UUIDENDPOINT)
    Call<UidModel> runQuery(@Header("Content-Type") String data, @Body RequestBody requestBody); // Returns UUID


    @Headers({
            "Accept: */*",
            "Accept-Language: en-US,en;q=0.9,en-GB;q=0.8",
            "Cache-Control: no-cache",
            "Connection: keep-alive",
            "Pragma: no-cache",
            "Referer: "+REFERER,
            "Sec-Fetch-Site: same-origin",
            "User-Agent: "+USERAGENT,
            "sec-ch-ua: "+SEC_CH_UA,
    })
    @GET(IMAGEENDPOINT+"{uuid}")
    Call<ImageResponseModel> getImageBase(@Path("uuid") String uuid); // Returns base64(Image)



}
