package amc.betfair.login;

public class LoginResult {
  
  private int statusCode;
  private String token;
  private String applicationKey;
  private boolean success;
  private String error;
  
  
  public int getStatusCode() {
    return statusCode;
  }
  public void setStatusCode(int statusCode) {
    this.statusCode = statusCode;
  }
  public String getToken() {
    return token;
  }
  public void setToken(String token) {
    this.token = token;
  }
  public String getApplicationKey() {
    return applicationKey;
  }
  public void setApplicationKey(String applicationKey) {
    this.applicationKey = applicationKey;
  }
  public boolean isSuccess() {
    return success;
  }
  public void setSuccess(boolean success) {
    this.success = success;
  }
  public String getError() {
    return error;
  }
  public void setError(String error) {
    this.error = error;
  }

}
