/**
    20206076
    佐々木陽貴
    課題9-BankServlet.java
**/
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse; 
public class BankServlet extends HttpServlet {
    private ExtendedBank bank; /* 口座の管理をするオブジェクト */
    private HttpServletRequest request; //requestをプライベート化するオブジェクト
    private HttpServletResponse response; //responseをプライベート化するオブジェクト
    public BankServlet() {  /* bankを初期化する */
        bank = new ExtendedBank();
    } 
    public void doGet(HttpServletRequest request2,
                    HttpServletResponse response2)
                    throws ServletException, IOException {
        request=request2;   //受け取ったリクエスト
        response=response2; //受け取ったレスポンス
        String command=request.getParameter("command"); //どのサーブレットから受け取ったか判断する
        if(command.equals("open")) open();
        if(command.equals("close")) close();
        if(command.equals("deposit")) deposit();
        if(command.equals("withdraw")) withdraw();
        if(command.equals("balance")) balance();
    }
    private void open()
        throws ServletException, IOException{
        String name=request.getParameter("name");   //口座名
        String pageText,title;
        int nameFlag;
        //口座開設(0で成功、-7は開設済みで失敗)
        nameFlag=bank.open(name);
        //nullの場合はじく
        if(name.equals("")){
            pageText="    名前を指定してください。<br>";
            title="不正な入力です";
        }else if(nameFlag==0){
            pageText="    開設しました。（結果コード100)<br>口座名 "+name+"<br>";
            title="開設成功";
        }else{
            pageText="    この名前はすでに開設済みです。（結果コード107)<br>口座名 "+name+"<br>";
            title="開設失敗";
        }
        page(pageText,title);
    }
    private void close()
        throws ServletException, IOException{
        String name=request.getParameter("name");   //口座名
        String pageText,title;
        int nameFlag;
        //口座解約(0で成功、-1は残高があるので失敗、-7は存在しないので失敗)
        nameFlag=bank.close(name);
        //nullの場合はじく
        if(name.equals("")){
            pageText="    名前を指定してください。<br>";
            title="不正な入力";
        }else if(nameFlag==0){
            pageText="    解約しました。（結果コード200)<br>口座名 "+name+"<br>";
            title="解約成功";
        }else if(nameFlag==-1){
            pageText="    残高が"+bank.showBalance(name)+"円残っています。（結果コード201)<br>口座名 "+name+"<br>";
            title="残高がまだ残っています！！";
        }else{
            pageText="    存在しない口座です。（結果コード207)<br>口座名 "+name+"<br>";
            title="解約失敗";
        }
        page(pageText,title);
    }
    private void deposit()
        throws ServletException, IOException{
        String name=request.getParameter("name");   //口座名
        String amount=request.getParameter("amount");   //預金金額
        String pageText,title;
        int nameFlag;
        //預金(0で成功、-3は負の値で失敗、-4は整数ではないので失敗、-7は存在しないので失敗)
        nameFlag=bank.deposit(name,amount);
        //nullの場合はじく
        if(name.equals("") || amount.equals("")){
            pageText="    名前と金額を指定してください。<br>";
            title="不正な入力";
        }else if(nameFlag==0){
            pageText="    預金しました。（結果コード300)<br>口座名 "+name+"<br>預金額　"+amount+"円<br>現在の残高　"+bank.showBalance(name)+"円<br>";
            title="預金成功";
        }else if(nameFlag==-3){
            pageText="    預金額に負の値または0が指定されています。（結果コード303)<br>口座名 "+name+"<br>預金額　"+amount+"円<br>";
            title="負の値が指定";
        }else if(nameFlag==-4){
            pageText="    預金額が整数ではありません。（結果コード304)<br>口座名 "+name+"<br>預金額　"+amount+"円<br>";
            title="整数ではない額";
        }else{
            pageText="    存在しない口座です。（結果コード307)<br>口座名 "+name+"<br>預金額　"+amount+"円<br>";
            title="預金失敗";
        }
        page(pageText,title);
    }
    private void withdraw()
        throws ServletException, IOException{
        String name=request.getParameter("name");   //口座名
        String amount=request.getParameter("amount");   //引き出し金額
        String pageText,title;
        int nameFlag;
        //引き出し(0で成功、-1は金額オーバーで失敗、-3は負の値で失敗、-4は整数ではないので失敗、-7は存在しないので失敗)
        nameFlag=bank.withdraw(name,amount);
        //nullの場合はじく
        if(name.equals("") || amount.equals("")){
            pageText="    名前と金額を指定してください。<br>";
            title="不正な入力";
        }else if(nameFlag==0){
            pageText="    引き出しました。（結果コード400)<br>口座名 "+name+"<br>引き出し額　"+amount+"円<br>現在の残高　"+bank.showBalance(name)+"円<br>";
            title="引き出し成功";
        }else if(nameFlag==-1){
            pageText="    引き出し額が預金額を超えています。（結果コード401)<br>口座名 "+name+"<br>引き出し額　"+amount+"円<br>現在の残高　"+bank.showBalance(name)+"円<br>";
            title="金額オーバー";
        }else if(nameFlag==-3){
            pageText="    引き出し額に負の値または0が指定されています。（結果コード403)<br>口座名 "+name+"<br>引き出し額　"+amount+"円<br>";
            title="負の値が指定";
        }else if(nameFlag==-4){
            pageText="    引き出し額が整数ではありません。（結果コード404)<br>口座名 "+name+"<br>引き出し額　"+amount+"円<br>";
            title="整数ではない額";
        }else{
            pageText="    存在しない口座です。（結果コード407)<br>口座名 "+name+"<br>引き出し額　"+amount+"円<br>";
            title="預金失敗";
        }
        page(pageText,title);
    }
    private void balance()
        throws ServletException, IOException{
        String name=request.getParameter("name");   //口座名
        String pageText,title;
        int nameFlag;
        //残高照会(0以上の値で成功、戻り値がそのまま預金残高になる。-7は存在しないので失敗)
        nameFlag=bank.showBalance(name);
        //nullの場合はじく
        if(name.equals("")){
            pageText="    名前を指定してください。<br>";
            title="不正な入力です";
        }else if(nameFlag>=0){
            pageText="    口座名 "+name+"<br>現在の残高　"+bank.showBalance(name)+"円<br>（結果コード500)<br>";
            title="残高照会";
        }else{
            pageText="    存在しない口座です。（結果コード507)<br>口座名 "+name+"<br>";
            title="照会失敗";
        }
        page(pageText,title);
    }
    private void page(String text,String title)
        throws ServletException, IOException{
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter pw = response.getWriter();
        pw.println("<HTML>");
        pw.println("<HEAD>");
        pw.println("<meta charset="+"utf-8"+"/>");
        pw.println("<meta name="+"viewport"+" content="+"width=640"+" />");
        pw.println("<meta name="+"viewport"+" content="+"width=device-width,initial-scale=1.0"+">");
        pw.println("<link rel="+"stylesheet"+" href="+"list.css"+">");

        //ページタイトル
        pw.println("<TITLE>"+title+"</TITLE>");

        pw.println("<meta property="+"og:title"+" content="+"Javaの課題DAAAAAAAAAA!!!"+">");
        pw.println("<meta property="+"og:url"+" content="+"https://java.cse.ce.nihon-u.ac.jp/"+">");
        pw.println("<meta property="+"og:image"+" content="+"https://pbs.twimg.com/profile_images/931900473962926080/F_lBY59l_400x400.jpg"+">");
        pw.println("<meta property="+"og:type"+" content="+"article"+" />");
        pw.println("<meta property="+"og:description"+" content="+"Javaの課題DAAAAAAAAAA"+" /> ");
        pw.println("<meta property="+"og:site_name"+" content="+"Javaの課題DAAAAAAAAAA"+" /> ");
        pw.println("</HEAD>");
        pw.println("<BODY>");
        pw.println("    20206076<br>佐々木陽貴<br><br><br><br><br><br>");
        
        //メゾットから受け取ったメッセージの表示
        pw.println(text);
        
        pw.println("    <div class="+"container"+">");
        pw.println("        <header>");
        pw.println("            <nav class="+"global-nav"+">");
        pw.println("                <ul class="+"nav-list"+">");
        pw.println("                    <li class="+"nav-item"+"><a href="+"index.html"+">戻る</a></li>");
        pw.println("                </ul>");
        pw.println("            </nav>");
        pw.println("            <br>");
        pw.println("        </header>");
        pw.println("        <div class="+"sidebar"+">");
        pw.println("            <div class="+"listback"+">");
        pw.println("                <li><a href="+"open"+">口座開設</a></li>");
        pw.println("                <li><a href="+"close"+">口座解約</a></li>");
        pw.println("                <li><a href="+"deposit"+">預金</a></li>");
        pw.println("                <li><a href="+"withdraw"+">引き出し</a></li>");
        pw.println("                <li><a href="+"balance"+">残高照会</a></li>");
        pw.println("            </div>");
        pw.println("        </div>");
        pw.println("        <br><br><br><br>");
        pw.println("    </div>");
        pw.println("");
        pw.println("");
        pw.println("");
        pw.println("</BODY>");
        pw.println("</HTML>");
    }
}