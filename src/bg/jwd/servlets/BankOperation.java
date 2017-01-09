package bg.jwd.servlets;

import java.io.IOException;

import javax.ejb.EJB;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import bg.jwb.ejb.WebBank;

@WebServlet("/BankOperation")
public class BankOperation extends HttpServlet {

	private static final long serialVersionUID = -8421728520916446161L;

	@EJB
	private WebBank webBank;

	@Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String client = request.getParameter("client");
		String operation = request.getParameter("operation");
		Double amount = Double.parseDouble(request.getParameter("amount"));
		Double currentAmount;

		// D - deposit
		// W - withdraw
		if ("D".equals(operation)) {

			currentAmount = webBank.deposit(client, amount);

		} else {
			currentAmount = webBank.withdraw(client, amount);

		}

		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/BankOperation.jsp");
		request.setAttribute("client", client);
		request.setAttribute("currentAmount", currentAmount);
		dispatcher.forward(request, response);

	}
}
