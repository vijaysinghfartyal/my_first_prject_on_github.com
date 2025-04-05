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


import beans.RegisterBean;
import beans.SetIdBean;

 
@WebServlet("/setid")
public class SetUserId extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		 
		SetIdBean setBean = new SetIdBean();
		setBean.setUserid(Integer.parseInt((String)request.getParameter("userid").trim()));
		RegisterBean rb = setBean.getByIdUser();
		if(rb != null) {
			HttpSession session = request.getSession();
			session.setAttribute("rbean",rb);
			RequestDispatcher rd = request.getRequestDispatcher("/edit");
			rd.forward(request, response);
		}
		else {
			out.print("<h1>Invalid user-Id</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("update.html");
			rd.include(request, response);
		}
		
		out.print("</body></html>");
	}

}