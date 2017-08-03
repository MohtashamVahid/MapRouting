package com.farkhani.map;

import com.farkhani.map.abstracts.MapAbstract;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;

/**
 * Created by farkhani on 02/08/2017.
 */

public class MapRouting extends MapAbstract implements MapContractor.View {
  private LatLng originPoint;
  private LatLng destinationPoint;
  private GoogleMap googleMap;
  private MapContractor.Presenter presenter;

  private MapRouting(Builder builder) {
    this.originPoint = builder.originPoint;
    this.destinationPoint = builder.destinationPoint;
    this.googleMap = builder.googleMap;
    presenter = new MapPresenter(this);
    presenter.init();
  }

  @Override public GoogleMap getGoogleMap() {
    return googleMap;
  }

  @Override public LatLng getOriginPoint() {
    return originPoint;
  }

  @Override public LatLng getDestinationPoint() {
    return destinationPoint;
  }

  public static final class Builder {
    private LatLng originPoint;
    private LatLng destinationPoint;
    private GoogleMap googleMap;

    public Builder() {

    }

    public MapRouting build() {
      return new MapRouting(this);
    }

    public Builder setOriginPoint(LatLng originPoint) {
      this.originPoint = originPoint;
      return this;
    }

    public Builder setDestinationPoint(LatLng destinationPoint) {
      this.destinationPoint = destinationPoint;
      return this;
    }

    public Builder setGoogleMap(GoogleMap googleMap) {
      this.googleMap = googleMap;
      return this;
    }
  }
}
