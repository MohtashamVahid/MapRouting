package com.farkhani.map;

import com.farkhani.map.connection.DirectionConnection;
import com.farkhani.map.interfaces.WebApiDirectionInterface;
import com.farkhani.map.model.DirectionResults;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Polyline;

/**
 * Created by farkhani on 02/08/2017.
 */

public class MapModel implements MapContractor.Model {
  private final MapContractor.ModelPeresenter mModelPresenter;
  private Polyline mPolyLine;

  public  MapModel(MapContractor.ModelPeresenter modelPeresenter){
    this.mModelPresenter=modelPeresenter;
  }

  @Override
  public void getDirection(final LatLng origin, final LatLng dist){
    DirectionConnection connection=new DirectionConnection();
    connection.setWebApiListener(new WebApiDirectionInterface() {
      @Override public void dataReceived(DirectionResults rute) {
        mModelPresenter.WebApiDirectionSuccessFulResult(origin,dist,rute);
      }

      @Override public void errorInWebservice(String error) {
        mModelPresenter.WebApiDirectionErrorHappened(error);

      }
    });
    connection.getDirection(origin,dist);
  }
  @Override public void setLastPolyLine(Polyline polyline) {
    mPolyLine=polyline;
  }
  @Override
  public Polyline getPolyLine() {
    return mPolyLine;
  }

}
