package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/SwitchMode")
public class ServletSwitchMode extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {
        Cookie cookies[]=request.getCookies();
        boolean wasFound = false;
        for(Cookie singleCookie: cookies){
            if(singleCookie.getName().equals("switch-display-mode")){
                if(singleCookie.getValue().equals("dark")){
                    singleCookie.setValue("light");
                }else{
                    singleCookie.setValue("dark");
                }
                response.addCookie(singleCookie);
                wasFound = true;
            }
        }
        if(!wasFound){
            Cookie ck = new Cookie("switch-display-mode", "dark");//creating cookie object
            response.addCookie(ck);//adding cookie in the response
        }

        for(Cookie singleCookie: cookies){
            if(singleCookie.getName().equals("switch-display-mode")){
                if(singleCookie.getValue().equals("dark")){
                    request.setAttribute("mode", "class=\"dark-mode\"");
                }else{
                    request.setAttribute("mode", "class=\"light-mode\"");
                }
            }
        }

        try {
            response.setHeader("Switch", "Success");

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    }
}
