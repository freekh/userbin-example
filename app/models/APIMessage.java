package models;

public class APIMessage {
  private final String message;
  
  public APIMessage(String message) {
    this.message = message;
  }

  public String getMessage() {
    return message;
  }
}