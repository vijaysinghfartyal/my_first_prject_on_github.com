package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import beans.EditBean;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html><head>");
        out.print("<style>");
        out.print("body { font-family: Arial, sans-serif; text-align: center; background-color: #f4f4f4; }");
        out.print(".container { background: white; padding: 20px; border-radius: 10px; box-shadow: 0 0 10px rgba(0, 0, 0, 0.1); display: inline-block; margin-top: 50px; }");
        out.print("h1 { color: #333; }");
        out.print(".message { font-size: 18px; margin-bottom: 20px; }");
        out.print(".button { padding: 10px 15px; font-size: 16px; color: white; background-color: #28a745; border: none; border-radius: 5px; cursor: pointer; text-decoration: none; }");
        out.print(".button:hover { background-color: #218838; }");
        out.print("</style>");
        out.print("</head><body>");
        out.print("<div class='container'>");
        
        EditBean rb = new EditBean();
        rb.setId(Integer.parseInt(request.getParameter("id").trim()));
        rb.setName(request.getParameter("name").trim());
        rb.setEmail(request.getParameter("email").trim());
        rb.setAddress(request.getParameter("address").trim());
        rb.setDesignation(request.getParameter("designation").trim());
        rb.setGender(request.getParameter("gender").trim());
        rb.setDoj(request.getParameter("doj").trim());
        rb.setMobno(Long.parseLong(request.getParameter("mobno").trim()));
        rb.setSalary(Float.parseFloat(request.getParameter("salary").trim()));

        if (rb.update()) {
            out.print("<h1>Successfully Updated</h1>");
            out.print("<p class='message'>Your profile has been updated successfully.</p>");
            out.print("<a href='Login.html' class='button'>Go to Login</a>");
        } else {
            out.print("<h1>Input Data Error</h1>");
            out.print("<p class='message'>There was an error updating your profile. Please try again.</p>");
            out.print("<a href='update.html' class='button'>Retry</a>");
        }
        
        out.print("</div>");
        out.print("</body></html>");
    }
}
