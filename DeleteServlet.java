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

import beans.DeleteBean;
import beans.RegisterBean;
import beans.SetIdBean;

 
@WebServlet("/delete")
public class DeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.print("<html><body>");
		 
		DeleteBean delBean = new DeleteBean();
		delBean.setUserid(Integer.parseInt((String)request.getParameter("userid").trim()));
		 
		if(delBean.delete()) {
			 
			out.print("<h1>Delete user Profile Success </h1>");
			RequestDispatcher rd = request.getRequestDispatcher("/index.html");
			rd.include(request, response);
		}
		else {
			out.print("<h1>Invalid user-Id</h1>");
			RequestDispatcher rd = request.getRequestDispatcher("delete.html");
			rd.include(request, response);
		}
		
		out.print("</body></html>");
	}

}