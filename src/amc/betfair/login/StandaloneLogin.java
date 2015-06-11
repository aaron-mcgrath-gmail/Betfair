package amc.betfair.login;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

public class StandaloneLogin implements ILogin {

  public LoginResult doLogin(String url, String user, String pass, String applicationKey) throws Exception {
    LoginResult result = new LoginResult();
    
    CloseableHttpResponse response = null;
    try {
      CloseableHttpClient httpclient = HttpClients.createDefault();
      HttpPost httpPost = new HttpPost(url);
      
      List<NameValuePair> nvps = new ArrayList<NameValuePair>();
      nvps.add(new BasicNameValuePair("username", user));
      nvps.add(new BasicNameValuePair("password", pass));
      httpPost.setEntity(new UrlEncodedFormEntity(nvps));
      
      httpPost.addHeader("Accept", "application/json");
      httpPost.addHeader("X-Application", applicationKey);
      
      response = httpclient.execute(httpPost);
    
      result.setStatusCode(response.getStatusLine().getStatusCode());
      result.setSuccess(response.getFirstHeader("status").equals("SUCCESS"));
      result.setError(response.getFirstHeader("error").getValue());
      result.setToken(response.getFirstHeader("token").getValue());
      result.setApplicationKey(response.getFirstHeader("product").getValue());
      
      HttpEntity entity2 = response.getEntity();
      EntityUtils.consume(entity2);
    } finally {
      response.close();
    }
    
    return result;
  }

  public LogoutResult doLogout(String url, String sessionToken, String applicationKey) throws Exception {
    LogoutResult result = new LogoutResult();
    
    CloseableHttpResponse response = null;
    try {
      CloseableHttpClient httpclient = HttpClients.createDefault();
      HttpPost httpPost = new HttpPost(url);
      
      httpPost.addHeader("Accept", "application/json");
      httpPost.addHeader("X-Application", applicationKey);
      httpPost.addHeader("X-Authentication", sessionToken);
      
      response = httpclient.execute(httpPost);
    
      result.setStatusCode(response.getStatusLine().getStatusCode());
      result.setSuccess(response.getFirstHeader("status").equals("SUCCESS"));
      result.setError(response.getFirstHeader("error").getValue());
      result.setApplicationKey(response.getFirstHeader("product").getValue());
      
      HttpEntity entity2 = response.getEntity();
      EntityUtils.consume(entity2);
    } finally {
      response.close();
    }
    
    return result;
  }

}
