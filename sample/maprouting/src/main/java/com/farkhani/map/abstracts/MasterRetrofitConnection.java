package com.farkhani.map.abstracts;

import android.support.annotation.Nullable;
import com.farkhani.map.interfaces.WebApiErrorInterface;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.RequestBody;
import org.json.JSONObject;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public abstract class MasterRetrofitConnection<K extends WebApiErrorInterface> {

  protected K mWebApiListener;

  public void setWebApiListener(K listener) {
    this.mWebApiListener = listener;
  }

  protected static class Url {

  }
  public void onFailure(Call call, Throwable t) {
    sendError("مشکل در ارتباط با سرور");
  }

  protected Retrofit initRetrofit(String mainUrl, @Nullable OkHttpClient client) {
    Gson gson = new GsonBuilder().setLenient().create();
    Retrofit retrofit;
    if (client == null) {
      client = new OkHttpClient.Builder().connectTimeout(7, TimeUnit.SECONDS)
          .readTimeout(7, TimeUnit.SECONDS)
          .build();
    }
    retrofit = new Retrofit.Builder().baseUrl(mainUrl)
        .addConverterFactory(GsonConverterFactory.create(gson))
        .client(client)
        .build();
    return retrofit;
  }

  protected void sendError(String message) {
    if (mWebApiListener != null) mWebApiListener.errorInWebservice(message);
  }

  protected RequestBody makeRequestBody(JSONObject object) {
     RequestBody body =
        RequestBody.create(okhttp3.MediaType.parse("application/json; charset=utf-8"),
            object.toString());
    return body;
  }


 }
