package com.orishkevich.marvelapp;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Streaming;

public interface RetrofitInterface {
//http://download.osmand.net/download.php?standard=yes&file=Denmark_europe_2.obf.zip
    @GET("files/Node-Android-Chat.zip")
    @Streaming
    Call<ResponseBody> downloadFile();
}
