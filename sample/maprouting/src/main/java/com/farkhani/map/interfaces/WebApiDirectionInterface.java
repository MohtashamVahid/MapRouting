package com.farkhani.map.interfaces;

import com.farkhani.map.model.DirectionResults;

public interface WebApiDirectionInterface extends WebApiErrorInterface {
  void dataReceived(DirectionResults body);
}
