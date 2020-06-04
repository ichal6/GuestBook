package Controller;

import DAO.DAOInterface;
import DAO.DAOdatabase;
import DAO.ReadError;
import Model.Sign;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalTime;
import java.util.Calendar;


@WebServlet("/Servlet")
public class ServletGuestBook extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException, ServletException{
        java.sql.Date actualDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        java.sql.Time actualTime = java.sql.Time.valueOf(LocalTime.now());
        String message = request.getParameter("provide-message");
        String name = request.getParameter("provide-name");

        try {
            DAOInterface dao = new DAOdatabase("src/main/resources/database.properties");
            Sign newSign= new Sign(name ,actualDate, actualTime, message);
            dao.addSign(newSign);
        }catch(ReadError ex){
            request.setAttribute("errorMessage", "Problem with add new sign. Your sign have not added!");
        }catch(IOException ex){
            request.setAttribute("errorMessage", "Problem with connect with database");
        }
        Cookie cookies[]=request.getCookies();
        for(Cookie singleCookie: cookies){
            if(singleCookie.getName().equals("switch-display-mode")){
                if(singleCookie.getValue().equals("dark")){
                    request.setAttribute("mode", "class=\"dark-mode\"");
                }else{
                    request.setAttribute("mode", "class=\"light-mode\"");
                }
            }
        }


        response.setHeader("Send", "Success");
        RequestDispatcher dispatcher
                = request.getRequestDispatcher("index.jsp");
        dispatcher.forward(request, response);
    }
}
