/**
    20206076
    佐々木陽貴
    課題9-DepositServlet.java
**/
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
public class DepositServlet extends HttpServlet {
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
        pw.println("<link rel="+"stylesheet"+" href="+"list.css"+">");
        pw.println("<TITLE>預金</TITLE>");
        pw.println("<meta property="+"og:title"+" content="+"Javaの課題DAAAAAAAAAA!!!"+">");
        pw.println("<meta property="+"og:url"+" content="+"https://java.cse.ce.nihon-u.ac.jp/"+">");
        pw.println("<meta property="+"og:image"+" content="+"https://pbs.twimg.com/profile_images/931900473962926080/F_lBY59l_400x400.jpg"+">");
        pw.println("<meta property="+"og:type"+" content="+"article"+" />");
        pw.println("<meta property="+"og:description"+" content="+"Javaの課題DAAAAAAAAAA"+" /> ");
        pw.println("<meta property="+"og:site_name"+" content="+"Javaの課題DAAAAAAAAAA"+" /> ");
        pw.println("</HEAD>");
        pw.println("<BODY>");
        pw.println("    <div class="+"mainbar"+">");
        pw.println("        <div class="+"mainback"+">");
        pw.println("            <div class="+"redwr"+">※重要：振り込め詐欺について</div><br>");
        pw.println("            近年、振り込め詐欺被害件数が増加傾向にあります。<br>");
        pw.println("            電話、郵便、メール等により現金を預金口座に「振り込め」という請求に対しては、すぐに振り込まず、ご家族などに連絡を取り、本当に支払う必要のある請求か、事前に必ずご確認ください。<br>");
        pw.println("        </div>");
        pw.println("    </div>");
        pw.println("    <br><br><br><br><br>20206076<br>佐々木陽貴<br>");
        pw.println("    預金する口座の名前と金額を入力してください。<br>");
        pw.println("    <form action="+"bank"+" method="+"GET"+">");     //BankServletのdoGetへ送信
        pw.println("        <input type="+"hidden"+" name="+"command"+" value="+"deposit"+">");     //command=deposit
        pw.println("        名前：<input type="+"text"+" name="+"name"+" size="+"40"+" /><br>");    //name=口座名
        pw.println("        金額：<input type="+"text"+" name="+"amount"+" size="+"40"+"><br>");    //amount=金額
        pw.println("        <input type="+"submit"+" value="+"OK"+" formaction="+"bank"+" />");     //入力内容を送信
        pw.println("        <input type="+"reset"+" value="+"リセット"+" formaction="+"bank"+" />");    //入力内容をリセット
        pw.println("    </from>");
        pw.println("    <div class="+"container"+">");
        pw.println("        <header>");
        //pw.println("            <nav class="+"global-nav"+">");
        //pw.println("                <ul class="+"nav-list"+">");
        //pw.println("                    <li class="+"nav-item"+"><a href="+"deposit-success.html"+">決定</a></li>");
        //pw.println("                    <li class="+"nav-item"+"><a href="+"#"+">初期化</a></li>");
        //pw.println("                </ul>");
        //pw.println("            </nav>");
        pw.println("            <br>");
        pw.println("            <nav class="+"global-nav"+">");
        pw.println("                <ul class="+"nav-list"+">");
        pw.println("                    <li class="+"nav-item"+"><a href="+"index.html"+">戻る</a></li>");
        pw.println("                </ul>");
        pw.println("            </nav>");
        pw.println("        </header>");
        pw.println("        <div class="+"sidebar"+">");
        pw.println("            <div class="+"listback"+">");
        pw.println("                <li><a href="+"open"+">口座開設</a></li>");
        pw.println("                <li><a href="+"close"+">口座解約</a></li>");
        pw.println("                <li><a href="+"deposit"+">預金</a></li>");
        pw.println("                <li><a href="+"withdraw"+">引き出し</a></li>");
        pw.println("                <li><a href="+"balance"+">残高照会</a></li>");
        pw.println("           </div>");
        pw.println("        </div>");
        pw.println("        <br><br><br><br>");
        pw.println("    </div>");
        pw.println("</BODY>");
        pw.println("</HTML>"); 
        
    }
}