package amc.betfair.api;

public class ApiException extends Exception {

  private static final long serialVersionUID = 201506112241L;
  
  public ApiException() {
    super();
  }
  
  public ApiException(String message) {
    super(message);
  }
  
  public ApiException(Throwable throwable) {
    super(throwable);
  }

}
