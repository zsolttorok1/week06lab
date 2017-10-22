/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servlets;

import business.UserService;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import business.User;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpSession;
import murach.util.CookieUtil;

/**
 *
 * @author 725899
 */
public class LoginServlet extends HttpServlet {


    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
            String action = (String) request.getParameter("action");
            String message = null;
            HttpSession session = request.getSession();

            //cookie check: if found prefill form values
            String username = CookieUtil.getCookieValue(request.getCookies(), "username");
            if (username != null && !username.equals("")) {
                request.setAttribute("checked", "checked");
                request.setAttribute("username", username);
                request.setAttribute("message", message);
            }
            
            //session checks out, but not a logout attempt: if true then user is already logged in, redirect to homepage
            if (session.getAttribute("username") != null && action == null) {
                response.sendRedirect("home");
                return;
            }
            
            //logout trigger check: if found kills current session
            if (action != null && action.equals("logout")) {
                message = "You have successfully logged out.";

                session.removeAttribute("username");
                session.invalidate();
                request.setAttribute("message", message);
            }
            
            //on any other cases: forward to loginpage please
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response); 
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
      
            boolean rememberMe = false;
            String message = null;
            String username = (String) request.getParameter("username");
            String password = (String) request.getParameter("password");
            String rememberMeString = (String) request.getParameter("remember");
            if (rememberMeString != null) {
                rememberMe = Boolean.parseBoolean(rememberMeString);
            }

            if (username != null && password != null
                && !username.equals("") && !password.equals("")) {

                    UserService userService = new UserService();
                    User user = new User();
                    user.setUsername(username);
                    user.setPassword(password);

                    //if login values are valid: do a session/cookie setup and redirect the user to home page
                    if (userService.login(user) != null) {
                        //set username session 
                        HttpSession session = request.getSession();
                        session.setAttribute("username", user.getUsername());
                        session.setMaxInactiveInterval(60*1);  // two minutes

                        //set username cookie
                        Cookie usernameCookie = new Cookie("username", user.getUsername());
                        
                        //"remember me" checkbox on: feed the browser with username cookie
                        if (rememberMe) {
                            usernameCookie.setMaxAge(60*60*24*365); // persistent for a year
                            usernameCookie.setPath("/");            // allowing access by entire app
                            response.addCookie(usernameCookie);
                        }
                        //"remember me" checkbox off: request to browser to forget username cookie
                        else {
                            if (usernameCookie != null) {
                                usernameCookie.setMaxAge(0); //effectively deleting the cookie, once it arrives
                                usernameCookie.setPath("/");
                                response.addCookie(usernameCookie);
                            }
                        }

                        request.setAttribute("user", user);
                        response.sendRedirect("home");
                        return;
                   }
                   else {
                       message = "Invalid username or password.";
                   }
            }
            else {
                message = "Both username and password fields must be filled.";
            }

            request.setAttribute("username", username);
            request.setAttribute("password", password);
            request.setAttribute("message", message);
            request.getRequestDispatcher("/WEB-INF/login.jsp").forward(request, response);
    }
    
    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
