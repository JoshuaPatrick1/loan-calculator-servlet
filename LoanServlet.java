import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class LoanServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        // Get parameters from the form
        double amount = Double.parseDouble(request.getParameter("amount"));
        double rate = Double.parseDouble(request.getParameter("rate"));
        int years = Integer.parseInt(request.getParameter("years"));

        // Create Loan object (Loan.java from Listing 10.2)
        Loan loan = new Loan(rate, years, amount);

        // Compute payments
        double monthlyPayment = loan.getMonthlyPayment();
        double totalPayment = loan.getTotalPayment();

        // Display results
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("<html><head><title>Loan Result</title></head><body>");
        out.println("<h2>Loan Computation Result</h2>");
        out.println("<p>Loan Amount: $" + amount + "</p>");
        out.println("<p>Annual Interest Rate: " + rate + "%</p>");
        out.println("<p>Number of Years: " + years + "</p>");
        out.println("<p><b>Monthly Payment: $" + String.format("%.2f", monthlyPayment) + "</b></p>");
        out.println("<p><b>Total Payment: $" + String.format("%.2f", totalPayment) + "</b></p>");
        out.println("</body></html>");
    }
}

