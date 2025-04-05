package myservlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import beans.RegisterBean;

@WebServlet("/edit")
public class EditServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.print("<html><head>");
        out.print("<style>");
        out.print("body { font-family: Arial, sans-serif; text-align: center; background-color: #e3f2fd; }");
        out.print(".container { background: white; padding: 20px; border-radius: 10px; box-shadow: 0 0 15px rgba(0, 0, 0, 0.2); display: inline-block; margin-top: 50px; }");
        out.print("h1 { color: #0277bd; }");
        out.print("form { display: flex; flex-direction: column; align-items: center; }");
        out.print("label { font-size: 16px; font-weight: bold; margin-top: 10px; color: #01579b; }");
        out.print("input[type='text'], input[type='radio'] { padding: 10px; margin: 5px; border: 1px solid #0288d1; border-radius: 5px; width: 80%; }");
        out.print(".button { padding: 12px 20px; font-size: 16px; color: white; background-color: #0288d1; border: none; border-radius: 5px; cursor: pointer; text-decoration: none; margin-top: 10px; transition: 0.3s; }");
        out.print(".button:hover { background-color: #01579b; }");
        out.print("</style>");
        out.print("</head><body>");
        out.print("<div class='container'>");

        HttpSession session = request.getSession(false);
        RegisterBean rb = (RegisterBean) session.getAttribute("rbean");
        
        out.print("<h1>Update Profile</h1>");
        out.print("<form action='update' method='post'>");
        out.print("<label>User ID</label>");
        out.print("<input type='text' name='id' value='" + rb.getId() + "' readonly='readonly'><br>");
        out.print("<label>Name</label>");
        out.print("<input type='text' name='name' value='" + rb.getName() + "'><br>");
        out.print("<label>Email</label>");
        out.print("<input type='text' name='email' value='" + rb.getEmail() + "'><br>");
        out.print("<label>Address</label>");
        out.print("<input type='text' name='address' value='" + rb.getAddress() + "'><br>");
        out.print("<label>Designation</label>");
        out.print("<input type='text' name='designation' value='" + rb.getDesignation() + "'><br>");
        out.print("<label>Date of Joining</label>");
        out.print("<input type='text' name='doj' value='" + rb.getDoj() + "'><br>");
        out.print("<label>Mobile No.</label>");
        out.print("<input type='text' name='mobno' value='" + rb.getMobno() + "'><br>");
        out.print("<label>Salary</label>");
        out.print("<input type='text' name='salary' value='" + rb.getSalary() + "'><br>");
        out.print("<label>Gender</label>");
        out.print("<input type='radio' name='gender' value='male' checked='checked'> Male");
        out.print("<input type='radio' name='gender' value='female'> Female<br>");
        out.print("<input type='submit' value='Update' class='button'><br>");
        out.print("</form>");

        out.print("</div>");
        out.print("</body></html>");
    }
}
