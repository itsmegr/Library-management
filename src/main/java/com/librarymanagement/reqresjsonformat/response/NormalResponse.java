package com.librarymanagement.reqresjsonformat.response;

public class NormalResponse {
  private String message;

  public NormalResponse(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }
}
