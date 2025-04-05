package myservlet;





import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Dao.PaymentDAO;
import beans.Payment;

import java.io.IOException;

@WebServlet("/processPayment")
public class PaymentServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cardNumber = request.getParameter("cardNumber");
        String cardHolderName = request.getParameter("cardHolderName");
        double amount = Double.parseDouble(request.getParameter("amount"));

        Payment payment = new Payment(0, cardNumber, cardHolderName, amount);
        PaymentDAO paymentDAO = new PaymentDAO();

        if (paymentDAO.processPayment(payment)) {
            response.sendRedirect("success.html");
        } else {
            response.sendRedirect("failure.html");
        }
    }
}
