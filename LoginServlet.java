package myservlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beans.LoginBean;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		String username =(String) request.getParameter("username");
		String password =(String) request.getParameter("password");
		LoginBean  lb = new LoginBean();
		lb.setUsername(username);
		lb.setPassword(password);

		if(lb.loginVerify()) {
			HttpSession session = request.getSession();
			session.setAttribute("username",lb.getUsername());
			RequestDispatcher rd = request.getRequestDispatcher("profile.html");
			rd.forward(request, response);
			
			
		}
		else {
			out.print("<h1>Invlaid username & password</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("Login.html");
			rd.include(request, response);
		}
		
		out.print("</body></html>");
	}

}