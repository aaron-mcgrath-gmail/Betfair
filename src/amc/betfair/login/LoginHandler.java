package amc.betfair.login;

import java.io.IOException;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

public class LoginHandler  implements HttpHandler {
  
  private LoginServerListener loginServerListener;
  
  public LoginHandler(LoginServerListener loginServerListener) {
    this.loginServerListener = loginServerListener;
  }

  public void handle(HttpExchange exchange) throws IOException {
    Headers requestHeaders = exchange.getRequestHeaders();
    
    
    exchange.close();
  }
}