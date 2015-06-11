package amc.betfair.login;

public interface ILogin {
  
  LoginResult doLogin(String url, String user, String pass, String applicationKey) throws Exception;
  
  LogoutResult doLogout(String url, String sessionToken, String applicationKey) throws Exception;

}
