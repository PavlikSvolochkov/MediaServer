package servlets;

import database.DBConnector;
import database.SelectForName;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.sql.ResultSet;
import java.sql.SQLException;

public class FindInfoServlet extends javax.servlet.http.HttpServlet {

  private SelectForName selectForName;
  private ResultSet resultSet;

  protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
    doGet(request, response);
  }

  protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
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

    try {

      selectForName = new SelectForName();
      resultSet = selectForName.process(request.getParameter("artist"));

      out.println("<table border='1'><tr><th>Title</th><th>Artist</th><th>Year</th><th>Image</th></tr>");

      while (resultSet.next()) {
        out.println("<tr>");
        out.println("<td>" + resultSet.getString("artist") + "</td>");
        out.println("<td>" + resultSet.getString("title") + "</td>");
        out.println("<td>" + resultSet.getString("year") + "</td>");

        BufferedImage bi = ImageIO.read(new ByteArrayInputStream(resultSet.getBytes("image")));
        OutputStream outImage = response.getOutputStream();
        ImageIO.write(bi, "jpg", outImage);

        BufferedImage image = ImageIO.read(new ByteArrayInputStream(resultSet.getBytes("image")));

        out.write("<td>" + (image) + "</td>");
        out.println("</tr>");
      }

      out.println("</body></html>");

    } catch (SQLException e) {
      e.printStackTrace();
    } finally {
      try {
        selectForName.close();
        out.close();
        DBConnector.closeConnection();
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }
}
