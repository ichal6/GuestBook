package Controller;

import DAO.DAOInterface;
import DAO.DAOdatabase;
import Model.Sign;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Calendar;
import java.util.List;


@WebServlet("/Servlet")
public class ServletGuestBook extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws IOException {
        java.sql.Date actualDate = new java.sql.Date(Calendar.getInstance().getTime().getTime());
        java.sql.Time actualTime = java.sql.Time.valueOf(LocalTime.now());
        String message = request.getParameter("provide-message");
        String name = request.getParameter("provide-name");

        DAOInterface dao = new DAOdatabase("/home/michael/Dropbox/Codecool/Weekendowy/3.WEB/2nd_Sprint/1.Pre-Work/GuestBook/src/main/resources/database.properties");
        Sign newSign= new Sign(name ,actualDate, actualTime, message);
        dao.addSign(newSign);

        try {
            response.setHeader("Send", "Success");

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    }
}
