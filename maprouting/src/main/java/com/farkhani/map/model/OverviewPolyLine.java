package com.farkhani.map.model;

import com.google.gson.annotations.SerializedName;

public class OverviewPolyLine {

  @SerializedName("points") public String points;

  public String getPoints() {
    return points;
  }
}