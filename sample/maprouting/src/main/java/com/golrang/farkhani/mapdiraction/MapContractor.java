package com.golrang.farkhani.mapdiraction;

import com.golrang.farkhani.mapdiraction.model.DirectionResults;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;

/**
 * Created by farkhani on 02/08/2017.
 */

public class MapContractor {
  interface View{
    GoogleMap getGoogleMap();

    LatLng getOriginPoint();

    LatLng getDestinationPoint();
  }
  interface  Presenter{
    void init();
  }
  interface  ModelPeresenter{
    void WebApiDirectionSuccessFulResult(LatLng origin, LatLng dist, DirectionResults rute);
    void WebApiDirectionErrorHappened(String error);
  }
  interface Model{
    void getDirection(LatLng origin, LatLng dist);

    void setLastPolyLine(Polyline polyline);

    Polyline getPolyLine();
  }
}
