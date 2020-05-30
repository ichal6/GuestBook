package Controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;


@WebServlet("/Servlet")
public class ServletGuestBook extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        LocalDate localDate = LocalDate.now();
        Date actualDate = Date.valueOf(localDate);
        String message = request.getParameter("provide-message");
        String name = request.getParameter("provide-name");

        try {
            request.setAttribute("message", String.valueOf(message));
            request.setAttribute("name", String.valueOf(name));
            request.setAttribute("date", String.valueOf(actualDate));
            response.setHeader("Test", "Success");

            RequestDispatcher dispatcher
                    = request.getRequestDispatcher("index.jsp");
            dispatcher.forward(request, response);
        } catch (Exception e) {
            response.sendRedirect("index.jsp");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
