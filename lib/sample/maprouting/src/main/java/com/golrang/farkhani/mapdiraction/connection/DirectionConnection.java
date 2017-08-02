package com.golrang.farkhani.mapdiraction.connection;

import com.golrang.farkhani.mapdiraction.abstracts.MasterRetrofitConnection;
import com.golrang.farkhani.mapdiraction.interfaces.WebApiDirectionInterface;
import com.golrang.farkhani.mapdiraction.model.DirectionResults;
import com.google.android.gms.maps.model.LatLng;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Retrofit;
import retrofit2.http.GET;
import retrofit2.http.Query;

public class DirectionConnection<T extends WebApiDirectionInterface>
    extends MasterRetrofitConnection<T> implements Callback<DirectionResults> {
  public void getDirection(LatLng userLocation, LatLng branch) {
    String origin = userLocation.latitude + "," + userLocation.longitude;
    String dest = branch.latitude + "," + branch.longitude;
    String url = "http://maps.googleapis.com/";
    Retrofit ret = initRetrofit(url, null);
    ret.create(Api.class).getJson(origin, dest).enqueue(this);
  }

  @Override public void onResponse(Call<DirectionResults> call,
      retrofit2.Response<DirectionResults> response) {
    if (response.isSuccessful()) {
      if (mWebApiListener != null) {
        mWebApiListener.dataReceived(response.body());
      }
    }
  }

  interface Api {
    @GET("maps/api/directions/json") Call<DirectionResults> getJson(@Query("origin") String origin,
        @Query("destination") String destination);
  }
}
