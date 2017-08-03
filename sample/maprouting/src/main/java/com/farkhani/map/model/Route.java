package com.farkhani.map.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class Route {
  @SerializedName("overview_polyline")
  private OverviewPolyLine overviewPolyLine;

  private List<Legs> legs;

  public OverviewPolyLine getOverviewPolyLine() {
    return overviewPolyLine;
  }

  public List<Legs> getLegs() {
    return legs;
  }

  public void setLegs(List<Legs> legs) {
    this.legs = legs;
  }
}