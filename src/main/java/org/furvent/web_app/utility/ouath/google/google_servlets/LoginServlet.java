package org.furvent.web_app.utility.ouath.google.google_servlets;

import com.google.api.client.auth.oauth2.AuthorizationCodeFlow;
import com.google.api.client.extensions.servlet.auth.oauth2.AbstractAuthorizationCodeServlet;
import com.google.api.client.http.GenericUrl;
import org.furvent.web_app.utility.ouath.google.OAuthUtil;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/login")
public class LoginServlet extends AbstractAuthorizationCodeServlet {

  @Override
  protected String getUserId(HttpServletRequest request) {
    return request.getSession().getId();
  }
  
  @Override
  protected AuthorizationCodeFlow initializeFlow() throws IOException {
    return OAuthUtil.newFlow();
  }

  @Override
  protected String getRedirectUri(HttpServletRequest request) {
    GenericUrl url = new GenericUrl(request.getRequestURL().toString());
    url.setRawPath("/login-callback");
    return url.build();
  }
}