package webCustomerTracker.testdb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;
import java.sql.*;

@WebServlet("/TestDbServlet")
public class TestDbServlet extends HttpServlet {

    private static final long serialVersionUID = 1L;

    protected void doGet(
        HttpServletRequest request,
        HttpServletResponse response
    ) throws ServletException {
        String user = "springstudent";
        String password = "springstudent";

        String jdbcUrl = "jdbc:postgresql://pgsql:5432/web_customer_tracker";

        try {
            PrintWriter out = response.getWriter();
            out.println(String.format("Connecting to database: %s", jdbcUrl));

            // Class.forName(driver);
            Connection myConn = DriverManager.getConnection(
                jdbcUrl,
                user,
                password
            );
            out.println("SUCCESS!!!");

            myConn.close();
        } catch (Exception e) {
            e.printStackTrace();

            throw new ServletException(e);
        }
    }
}
