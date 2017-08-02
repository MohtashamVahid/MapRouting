package com.golrang.farkhani.mapdiraction;

import android.graphics.Color;
import com.golrang.farkhani.mapdiraction.model.DirectionResults;
import com.golrang.farkhani.mapdiraction.model.Location;
import com.golrang.farkhani.mapdiraction.model.Route;
import com.golrang.farkhani.mapdiraction.model.RouteDecode;
import com.golrang.farkhani.mapdiraction.model.Steps;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by farkhani on 02/08/2017.
 */

public class MapPresenter implements MapContractor.Presenter, MapContractor.ModelPeresenter {
  private MapContractor.View mView;
  private MapContractor.Model mModel;

  public MapPresenter(MapContractor.View view) {
    mView = view;
    mModel = new MapModel(this);
  }

  @Override public void init() {
    getModel().getDirection(getView().getOriginPoint(), getView().getDestinationPoint());
  }

  public MapContractor.View getView() {
    return mView;
  }

  public MapContractor.Model getModel() {
    return mModel;
  }

  @Override
  public void WebApiDirectionSuccessFulResult(LatLng origin, LatLng dist, DirectionResults rute) {
    if (getModel().getPolyLine() != null) {
      getModel().getPolyLine().remove();
    }
    GoogleMap mGoogleMap = getView().getGoogleMap();

    if (rute.getRoutes().size() > 0) {
      ArrayList<LatLng> routelist = new ArrayList<LatLng>();

      ArrayList<LatLng> decodelist;
      Route routeA = rute.getRoutes().get(0);
      if (routeA.getLegs().size() > 0) {
        List<Steps> steps = routeA.getLegs().get(0).getSteps();
        Steps step;
        Location location;
        String polyline;
        for (int i = 0; i < steps.size(); i++) {
          step = steps.get(i);
          location = step.getStart_location();
          routelist.add(new LatLng(location.getLat(), location.getLng()));
          polyline = step.getPolyline().getPoints();
          decodelist = RouteDecode.decodePoly(polyline);
          routelist.addAll(decodelist);
          location = step.getEnd_location();
          routelist.add(new LatLng(location.getLat(), location.getLng()));
        }
      }

      if (routelist.size() > 0) {
        PolylineOptions rectLine =
            new PolylineOptions().width(3).color(Color.parseColor("#ff3f51b5"));

        for (int i = 0; i < routelist.size(); i++) {
          rectLine.add(routelist.get(i));
        }
        // Adding route on the map
        getModel().setLastPolyLine(mGoogleMap.addPolyline(rectLine));
      }
    }
  }

  @Override public void WebApiDirectionErrorHappened(String error) {

  }
}
