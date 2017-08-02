package com.golrang.farkhani.mapdiraction.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by farkhani on 01/08/2017.
 */
public class DirectionResults {
  @SerializedName("routes") private List<Route> routes;

  public List<Route> getRoutes() {
    return routes;
  }
}

