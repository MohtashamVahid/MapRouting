package com.farkhani.map.model;

public class BaseServerResponse {

  Boolean Success;
  Long SuccessStatus;
  String Message;

  public BaseServerResponse() {
  }

  public Boolean getSuccess() {
    return Success;
  }

  public void setSuccess(Boolean success) {
    Success = success;
  }

  public Long getSuccessStatus() {
    return SuccessStatus;
  }

  public void setSuccessStatus(Long successStatus) {
    SuccessStatus = successStatus;
  }

  public String getMessage() {
    return Message;
  }

  public void setMessage(String message) {
    Message = message;
  }

}
