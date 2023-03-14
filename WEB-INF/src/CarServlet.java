import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
public class CarServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
                    throws ServletException, IOException {
        String carname = request.getParameter("cars");
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println("<HTML>");
        pw.println ("<HEAD><TITLE>"+carname+"</TITLE></HEAD>");
        pw.println ("<BODY>"+carname+"<br>お買い上げありがとうございます。</BODY>");
        pw.println ("</HTML>"); 
    }
}