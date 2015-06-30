package servlets;

import database.CreateUser;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "RegisterUserServlet")
public class RegisterUserServlet extends HttpServlet {

  private Pattern emailPattern;
  private Pattern namePattern;
  private Matcher nameMatcher;
  private Matcher emailMatcher;

  protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

  }

  protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    // Set response content type
    response.setContentType("text/html");
    PrintWriter out = response.getWriter();
    String title = "Database Result";
    String docType = "<!doctype html public \"-//w3c//dtd html 4.0 transitional//en\">\n";
    out.println(docType +
            "<html>\n" +
            "<head><title>" + title + "</title>" +
            "<link rel=\"stylesheet\" href=\"/css/styles.css\">" +
            "</head>\n" +
            "<body bgcolor=\"#f0f0f0\">\n" +
            "<h1 align=\"center\">" + title + "</h1>\n");

    out.println(request.getParameter("login"));
    out.println(request.getParameter("email"));
    out.println(request.getParameter("pass1"));
    out.println(request.getParameter("pass2"));

    String name = request.getParameter("login");
    String email = request.getParameter("email");
    String pass1 = request.getParameter("pass1");
    String pass2 = request.getParameter("pass2");

    final String NAME_PATTERN = "^[_A-Za-z0-9-\\+]{4,8}";

    final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
            + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    namePattern = Pattern.compile(NAME_PATTERN);
    emailPattern = Pattern.compile(EMAIL_PATTERN);

    nameMatcher = namePattern.matcher(request.getParameter("name"));
    emailMatcher = emailPattern.matcher(request.getParameter("email"));


    if (pass1.isEmpty() || pass2.isEmpty() || name.isEmpty() || email.isEmpty()) {

      out.println("<H1>Please, fill the form.</H1>");

    }
    if (!nameMatcher.matches()) {

      out.println("<H1>Enter correct email, motherfucker!</H1>");

    } else if (pass1.equals(pass2)) {
      try {
        CreateUser createUser = new CreateUser();
        if (createUser.insertUser(name, email, pass1)) {
          out.println("<H1>User: " + name + " created!</H1>");
        } else {
          out.println("<H1>User: " + name + " exist!</H1>");
        }
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else {
      out.println("<H1>Password not correct!</H1>");
    }

    out.println("</body></html>");

  }
}
