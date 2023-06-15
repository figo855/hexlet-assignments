package exercise.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import static exercise.Data.getCompanies;

public class CompaniesServlet extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response)
                throws IOException, ServletException {

        // BEGIN
        PrintWriter out = response.getWriter();
        List<String> companies = getCompanies();
        String searchString = request.getParameter("search");
        if (searchString == null)
            searchString = "";
        List<String> filteredCompanies = new ArrayList<>();
        for (String company: companies) {
            if (company.contains(searchString))
                filteredCompanies.add(company);
        }
        if (filteredCompanies.isEmpty()) {
            out.println("Companies not found");
            return;
        }
        for (String company: filteredCompanies)
            out.println(company);
        // END
    }
}
