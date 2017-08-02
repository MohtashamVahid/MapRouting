package com.golrang.farkhani.mapdiraction.interfaces;

import com.golrang.farkhani.mapdiraction.model.DirectionResults;

public interface WebApiDirectionInterface extends WebApiErrorInterface {
  void dataReceived(DirectionResults body);
}
