package amc.betfair.login;

import java.io.IOException;
import java.net.InetSocketAddress;

import com.sun.net.httpserver.HttpServer;

public class LoginServerListener {
  
  private HttpServer server = null;
  private int port;

  private static final int MAX_TIME_TO_WAIT_SECS = 20;
  private static final int DEFAULT_PORT = 8486;
  
  public LoginServerListener() {
    this.setPort(DEFAULT_PORT);
  }
  
  public void start() {
    try {
      server = HttpServer.create(new InetSocketAddress(this.getPort()), 0);
    } catch (IOException e) {
      e.printStackTrace();
    }
    server.createContext("/", new LoginHandler(this));
    server.setExecutor(null);
    server.start();
  }
  
  public void stop() {
    server.stop(MAX_TIME_TO_WAIT_SECS);
  }

  public int getPort() {
    return port;
  }

  public void setPort(int port) {
    this.port = port;
  }

}
