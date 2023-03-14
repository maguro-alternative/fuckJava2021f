import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
public class templeServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                    HttpServletResponse response)
                    throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println("<HTML>");
        pw.println("<HEAD>");
        pw.println("<meta charset="+"utf-8"+"/>");
        pw.println("<meta name="+"viewport"+" content="+"width=640"+" />");
        pw.println("<meta name="+"viewport"+" content="+"width=device-width,initial-scale=1.0"+">");
        pw.println("<TITLE>口座開設</TITLE>");
        pw.println("<meta property="+"og:title"+" content="+"Javaの課題DAAAAAAAAAA!!!"+">");
        pw.println("<meta property="+"og:url"+" content="+"https://java.cse.ce.nihon-u.ac.jp/"+">");
        pw.println("<meta property="+"og:image"+" content="+"https://pbs.twimg.com/profile_images/931900473962926080/F_lBY59l_400x400.jpg"+">");
        pw.println("<meta property="+"og:type"+" content="+"article"+" />");
        pw.println("<meta property="+"og:description"+" content="+"Javaの課題DAAAAAAAAAA"+" /> ");
        pw.println("<meta property="+"og:site_name"+" content="+"Javaの課題DAAAAAAAAAA"+" /> ");
        pw.println("</HEAD>");
        pw.println("<BODY>");
        pw.println("");
        pw.println("");
        pw.println("");
        pw.println("");
        pw.println("");
        pw.println("</BODY>");
        pw.println("</HTML>"); 
        
    }
}