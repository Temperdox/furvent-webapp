package org.furvent.web_app.utility.ouath.google.google_servlets;

import com.google.api.services.oauth2.model.Userinfo;
import org.furvent.web_app.utility.ouath.google.OAuthUtil;

import java.io.IOException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletRequest;

@WebServlet("/profile")
public class ProfileServlet extends HttpServlet {

  @Override
  public void doGet(HttpServletRequest request, HttpServletResponse response)
      throws IOException {
    response.setContentType("text/html;");
    response.getWriter().println("<h1>OAuth 2.0 Hello World</h1>");

    String sessionId = request.getSession().getId();
    boolean isUserLoggedIn =
        OAuthUtil.isUserLoggedIn(sessionId);
    
    if (isUserLoggedIn) {
      Userinfo userInfo = OAuthUtil.getUserInfo(sessionId);

      response.getWriter().println("<p>ID: " + userInfo.getId() + "</p>");
      response.getWriter().println("<p>Email: " + userInfo.getEmail() + "</p>");
      response.getWriter().println("<p>First name: " + userInfo.getGivenName() + "</p>");
      response.getWriter().println("<p>Last name: " + userInfo.getFamilyName() + "</p>");
      response.getWriter().println("<p>Full name: " + userInfo.getName() + "</p>");
      response.getWriter().println("<img src=\"" + userInfo.getPicture() + "\" />");

      response.getWriter().println("<p><a href=\"/logout\">Logout</a></p>");
    } else {
      response.getWriter().println("<a href=\"/login\">Login with Google</a>");	
    }
  }
}