//佐々木陽貴
//20206076
//課題5-(2)
public class ExtendedBankTest{
    public static void main(String[] args){
        ExtendedBank testBank=new ExtendedBank();
        int flag;
        //一郎、口座開設
        flag=testBank.open("一郎");
        if(flag==0) System.out.println("開設できたので正常です");         //正常の場合
        else if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");   //失敗（名前重複）の場合
        //三郎、口座開設
        flag=testBank.open("三郎");
        if(flag==0) System.out.println("開設できたので正常です");         //正常の場合
        else if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");   //失敗（名前重複）の場合

        System.out.println("");

        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==0) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合
        //三郎、残高照会
        flag=testBank.showBalance("三郎");
        System.out.print("三郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==0) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //一郎、口座開設（既に開設済みなのではじかれる）
        flag=testBank.open("一郎");
        if(flag==-7) System.out.println("開設できなかったので正常です");        //正常の場合（開設済み）
        else if(flag==0) System.out.println("戻り値が"+flag+"で誤りです");            //失敗（開設できてしまった場合。）
        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==0) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //一郎、初めての預金、の巻(10000円)
        flag=testBank.deposit("一郎",10000);
        if(flag==0) System.out.println("預金成功で正常です");                     //預金成功（正常です。）
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //0以下が指定された場合
        else if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");   //そもそも口座がない場合
        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==10000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //三郎、初めての預金、の巻(50000円)
        flag=testBank.deposit("三郎",50000);
        if(flag==0) System.out.println("預金成功で正常です");                     //預金成功（正常です。）
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //0以下が指定された場合
        else if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");   //そもそも口座がない場合
        //三郎、残高照会
        flag=testBank.showBalance("三郎");
        System.out.print("三郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==50000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //一郎、負の金額を預金、の巻（余裕ではじかれます。）
        flag=testBank.deposit("一郎",-1000);
        if(flag==-3) System.out.println("預金失敗で正常です");            //0以下の値なので正常です
        else if(flag==0) System.out.println("戻り値が"+flag+"で誤りです");                   //成功しちゃった場合←やばい
        else if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");   //そもそも口座がないので誤りです。
        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==10000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //三郎、負の金額を預金、の巻（余裕ではじかれます。）
        flag=testBank.deposit("三郎",-1000);
        if(flag==-3) System.out.println("預金失敗で正常です");            //0以下の値なので正常です
        else if(flag==0) System.out.println("戻り値が"+flag+"で誤りです");                   //成功しちゃった場合←やばい
        else if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");   //そもそも口座がないので誤りです。
        //三郎、残高照会
        flag=testBank.showBalance("三郎");
        System.out.print("三郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==50000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //郎(誰？)、初めての預金、の巻(10000円)
        flag=testBank.deposit("郎",10000);
        if(flag==-7) System.out.println("存在しない口座で正常です");            //そもそも口座がないので正常です
        else if(flag==0) System.out.println("戻り値が"+flag+"なので誤りです");                   //成功しちゃった場合←やばい
        else if(flag==-3) System.out.println("戻り値が"+flag+"なので誤りです");   //誤りです。ゼロ以下です。
        //郎、残高照会(誰？？？？)
        flag=testBank.showBalance("郎");
        System.out.print("郎:");
        if(flag==-7) System.out.println("存在しない口座で正常です");    //口座が存在しない場合
        else if(flag==10000) System.out.println("残高が"+flag+"円で誤りです");    //金額が出てしまった場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //郎、負の金額を預金、の巻（いや誰だよ）
        flag=testBank.deposit("郎",-1000);
        if(flag==-7) System.out.println("存在しない口座で正常です");            //そもそも口座がないので正常です
        else if(flag==0) System.out.println("戻り値が"+flag+"で誤りです");                   //成功しちゃった場合←やばい
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //誤りです。ゼロ以下です。
        //郎、残高照会(誰？？？？)
        flag=testBank.showBalance("郎");
        System.out.print("郎:");
        if(flag==-7) System.out.println("存在しない口座で正常です");    //口座が存在しない場合
        else if(flag==10000) System.out.println("残高が"+flag+"円で誤りです");    //金額が出てしまった場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //一郎、引き出しまくる編
        flag=testBank.withdraw("一郎",5000);
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");        //存在しない口座
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //残高が0以下
        else if(flag==-1) System.out.println("戻り値が"+flag+"で誤りです");   //預金額より大きい場合はじく
        else System.out.println("引き出し成功で正常です");                      //成功の場合
        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==5000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //三郎、一郎に続き引き出しまくる編
        flag=testBank.withdraw("三郎",25000);
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");        //存在しない口座
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //残高が0以下
        else if(flag==-1) System.out.println("戻り値が"+flag+"で誤りです");   //預金額より大きい場合はじく
        else System.out.println("引き出し成功で正常です");                      //成功の場合
        //三郎、残高照会
        flag=testBank.showBalance("三郎");
        System.out.print("三郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==25000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //郎？？？？？？？三郎、一郎に続き引き出しまくる編
        flag=testBank.withdraw("郎",10000);
        if(flag==-7) System.out.println("存在しない口座で正常です");        //存在しない口座
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //残高が0以下
        else if(flag==-1) System.out.println("戻り値が"+flag+"で誤りです");   //預金額より大きい場合はじく
        else System.out.println("戻り値が"+flag+"で誤りです");                      //成功してしまった場合
        //郎、残高照会(誰？？？？)
        flag=testBank.showBalance("郎");
        System.out.print("郎:");
        if(flag==-7) System.out.println("存在しない口座で正常です");    //口座が存在しない場合
        else if(flag==10000) System.out.println("残高が"+flag+"円で誤りです");    //金額が出てしまった場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //一郎、負のスパイラルへ引き出しまくる編
        flag=testBank.withdraw("一郎",-5000);
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");        //存在しない口座
        else if(flag==-3) System.out.println("不正な金額で正常です");   //残高が0以下
        else if(flag==-1) System.out.println("戻り値が"+flag+"で誤りです");   //預金額より大きい場合はじく
        else System.out.println("戻り値が"+flag+"で誤りです");                      //成功の場合
        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==5000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //三郎、負のスパイラル一郎に続き引き出しまくる編
        flag=testBank.withdraw("三郎",-25000);
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");        //存在しない口座
        else if(flag==-3) System.out.println("不正な金額で正常です");   //残高が0以下
        else if(flag==-1) System.out.println("戻り値が"+flag+"で誤りです");   //預金額より大きい場合はじく
        else System.out.println("戻り値が"+flag+"で誤りです");                      //成功の場合
        //三郎、残高照会
        flag=testBank.showBalance("三郎");
        System.out.print("三郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==25000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //郎？？？？？？？三郎、一郎に続き負のスパイラル引き出しまくる編
        flag=testBank.withdraw("郎",-10000);
        if(flag==-7) System.out.println("存在しない口座で正常です");        //存在しない口座
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //残高が0以下
        else if(flag==-1) System.out.println("戻り値が"+flag+"で誤りです");   //預金額より大きい場合はじく
        else System.out.println("戻り値が"+flag+"で誤りです");                      //成功の場合
        //郎、残高照会(誰？？？？)
        flag=testBank.showBalance("郎");
        System.out.print("郎:");
        if(flag==-7) System.out.println("存在しない口座で正常です");    //口座が存在しない場合
        else if(flag==10000) System.out.println("残高が"+flag+"円で誤りです");    //金額が出てしまった場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //一郎、オーバー引き出しまくる編
        flag=testBank.withdraw("一郎",50000);
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");        //存在しない口座
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //残高が0以下
        else if(flag==-1) System.out.println("残高不足で正常です");   //預金額より大きい場合はじく
        else System.out.println("戻り値が"+flag+"で誤りです");                      //成功の場合
        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==5000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //三郎、一郎に続きオーバー引き出しまくる編
        flag=testBank.withdraw("三郎",250000);
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");        //存在しない口座
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //残高が0以下
        else if(flag==-1) System.out.println("残高不足で正常です");   //預金額より大きい場合はじく
        else System.out.println("戻り値が"+flag+"で誤りです");                      //成功の場合
        //三郎、残高照会
        flag=testBank.showBalance("三郎");
        System.out.print("三郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==25000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //郎？？？？？？？三郎、一郎に続きオーバー引き出しまくる編
        flag=testBank.withdraw("郎",100000);
        if(flag==-7) System.out.println("存在しない口座で正常です");        //存在しない口座
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //残高が0以下
        else if(flag==-1) System.out.println("戻り値が"+flag+"で誤りです");   //預金額より大きい場合はじく
        else System.out.println("戻り値が"+flag+"で誤りです");                      //成功の場合
        //郎、残高照会(誰？？？？)
        flag=testBank.showBalance("郎");
        System.out.print("郎:");
        if(flag==-7) System.out.println("存在しない口座で正常です");    //口座が存在しない場合
        else if(flag==10000) System.out.println("残高が"+flag+"円で誤りです");    //金額が出てしまった場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //課題5からの追記部分
        //一郎の現時点での残高:5000円
        //三郎の現時点での残高:25000円

        //一郎、初めてのsrt預金、の巻(10000円)
        flag=testBank.deposit("一郎","１００００");
        if(flag==0) System.out.println("預金成功で正常です");                     //預金成功（正常です。）
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //0以下が指定された場合
        else if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");   //そもそも口座がない場合
        else if(flag==-4) System.out.println("戻り値が"+flag+"で誤りです");   //int型に変換できなかった場合
        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==15000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //一郎、初めての-srt預金、の巻(-10000円)
        flag=testBank.deposit("一郎","-１００００");
        if(flag==-3) System.out.println("不正な金額で正常です");               //0以下が指定された場合     
        else if(flag==0) System.out.println("戻り値が"+flag+"で誤りです");    //預金成功（異常です。）
        else if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");   //そもそも口座がない場合
        else if(flag==-4) System.out.println("戻り値が"+flag+"で誤りです");   //int型に変換できなかった場合
        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==15000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //一郎、初めてのsrt預金、の巻(一万円)
        flag=testBank.deposit("一郎","一万円");
        if(flag==-4) System.out.println("不正な値で正常です");             //int型に変換できなかった場合        
        else if(flag==0) System.out.println("戻り値が"+flag+"で誤りです");   //預金成功（異常です。）
        else if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");   //そもそも口座がない場合
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //0以下が指定された場合
        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==15000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //郎(誰？)、初めての-str預金、の巻(10000円)
        flag=testBank.deposit("郎","-１００００");
        if(flag==-7) System.out.println("存在しない口座で正常です");            //そもそも口座がないので正常です
        else if(flag==0) System.out.println("戻り値が"+flag+"なので誤りです");                   //成功しちゃった場合←やばい
        else if(flag==-3) System.out.println("戻り値が"+flag+"なので誤りです");   //誤りです。ゼロ以下です。
        else if(flag==-4) System.out.println("戻り値が"+flag+"で誤りです");   //int型に変換できなかった場合
        //郎、残高照会(誰？？？？)
        flag=testBank.showBalance("郎");
        System.out.print("郎:");
        if(flag==-7) System.out.println("存在しない口座で正常です");    //口座が存在しない場合
        else if(flag==10000) System.out.println("残高が"+flag+"円で誤りです");    //金額が出てしまった場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");


        //郎(誰？)、初めてのstr預金、の巻(10000円)
        flag=testBank.deposit("郎","１００００");
        if(flag==-7) System.out.println("存在しない口座で正常です");            //そもそも口座がないので正常です
        else if(flag==0) System.out.println("戻り値が"+flag+"なので誤りです");                   //成功しちゃった場合←やばい
        else if(flag==-3) System.out.println("戻り値が"+flag+"なので誤りです");   //誤りです。ゼロ以下です。
        else if(flag==-4) System.out.println("戻り値が"+flag+"で誤りです");   //int型に変換できなかった場合
        //郎、残高照会(誰？？？？)
        flag=testBank.showBalance("郎");
        System.out.print("郎:");
        if(flag==-7) System.out.println("存在しない口座で正常です");    //口座が存在しない場合
        else if(flag==10000) System.out.println("残高が"+flag+"円で誤りです");    //金額が出てしまった場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //引き出し
        //一郎の残高:15000円

        //一郎、str引き出しまくる編
        flag=testBank.withdraw("一郎","１００００");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");        //存在しない口座
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //残高が0以下
        else if(flag==-1) System.out.println("戻り値が"+flag+"で誤りです");   //預金額より大きい場合はじく
        else if(flag==-4) System.out.println("戻り値が"+flag+"で誤りです");   //int型に変換できなかった場合
        else System.out.println("引き出し成功で正常です");                      //成功の場合
        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==5000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //一郎、-str引き出しまくる編
        flag=testBank.withdraw("一郎","-１００００");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");        //存在しない口座
        else if(flag==-3) System.out.println("不正な金額で正常です");   //残高が0以下
        else if(flag==-1) System.out.println("戻り値が"+flag+"で誤りです");   //預金額より大きい場合はじく
        else if(flag==-4) System.out.println("戻り値が"+flag+"で誤りです");   //int型に変換できなかった場合
        else if(flag==0) System.out.println("戻り値が"+flag+"で誤りです");                      //成功の場合
        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==5000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //一郎、str型引き出しまくる編
        flag=testBank.withdraw("一郎","いちまんえん！！");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");        //存在しない口座
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //残高が0以下
        else if(flag==-1) System.out.println("戻り値が"+flag+"で誤りです");   //預金額より大きい場合はじく
        else if(flag==-4) System.out.println("不正な金額で正常です");   //int型に変換できなかった場合
        else if(flag==0) System.out.println("戻り値が"+flag+"で誤りです");                      //成功の場合
        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==5000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //一郎、str型引き出しまくる編
        flag=testBank.withdraw("一郎","１００００");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");        //存在しない口座
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //残高が0以下
        else if(flag==-1) System.out.println("残高不足で正常です");   //預金額より大きい場合はじく
        else if(flag==-4) System.out.println("戻り値が"+flag+"で誤りです");   //int型に変換できなかった場合
        else if(flag==0) System.out.println("戻り値が"+flag+"で誤りです");                      //成功の場合
        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==5000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //郎(誰？)、-str型引き出しまくる編
        flag=testBank.withdraw("郎","-１００００");
        if(flag==-7) System.out.println("存在しない口座で正常です");            //そもそも口座がないので正常です
        else if(flag==0) System.out.println("戻り値が"+flag+"なので誤りです");                   //成功しちゃった場合←やばい
        else if(flag==-3) System.out.println("戻り値が"+flag+"なので誤りです");   //誤りです。ゼロ以下です。
        else if(flag==-4) System.out.println("戻り値が"+flag+"で誤りです");   //int型に変換できなかった場合
        //郎、残高照会(誰？？？？)
        flag=testBank.showBalance("郎");
        System.out.print("郎:");
        if(flag==-7) System.out.println("存在しない口座で正常です");    //口座が存在しない場合
        else if(flag==10000) System.out.println("残高が"+flag+"円で誤りです");    //金額が出てしまった場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //郎(誰？)、str型引き出しまくる編
        flag=testBank.withdraw("郎","１００００");
        if(flag==-7) System.out.println("存在しない口座で正常です");            //そもそも口座がないので正常です
        else if(flag==0) System.out.println("戻り値が"+flag+"なので誤りです");                   //成功しちゃった場合←やばい
        else if(flag==-3) System.out.println("戻り値が"+flag+"なので誤りです");   //誤りです。ゼロ以下です。
        else if(flag==-4) System.out.println("戻り値が"+flag+"で誤りです");   //int型に変換できなかった場合
        //郎、残高照会(誰？？？？)
        flag=testBank.showBalance("郎");
        System.out.print("郎:");
        if(flag==-7) System.out.println("存在しない口座で正常です");    //口座が存在しない場合
        else if(flag==10000) System.out.println("残高が"+flag+"円で誤りです");    //金額が出てしまった場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");


        //追記終了
        //一郎の現時点での残高:5000円
        //三郎の現時点での残高:25000円


        //さらば一郎、前編!
        flag=testBank.close("一郎");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");      //口座がない場合
        else if(flag==-1) System.out.println("解約失敗で正常です"); //まだ残高がある場合
        else System.out.println("戻り値が"+flag+"で誤りです");                      //解約できた場合
        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==5000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //さらば三郎、前編!
        flag=testBank.close("三郎");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");      //口座がない場合
        else if(flag==-1) System.out.println("解約失敗で正常です"); //まだ残高がある場合
        else System.out.println("戻り値が"+flag+"で誤りです");                      //解約できた場合
        //三郎、残高照会
        flag=testBank.showBalance("三郎");
        System.out.print("三郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==25000) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //さらば??????????、前編!
        flag=testBank.close("郎");
        if(flag==-7) System.out.println("存在しない口座で正常です");      //口座がない場合
        else if(flag==-1) System.out.println("戻り値が"+flag+"で誤りです"); //まだ残高がある場合
        else System.out.println("解約成功で誤りです");                      //解約できた場合
        //???????,残高照会
        flag=testBank.showBalance("郎");
        System.out.print("郎:");
        if(flag==-7) System.out.println("存在しない口座で正常です");    //口座が存在しない場合
        else if(flag==10000) System.out.println("残高が"+flag+"円で誤りです");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //一郎、引き出しまくる編
        flag=testBank.withdraw("一郎",5000);
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");        //存在しない口座
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //残高が0以下
        else if(flag==-1) System.out.println("戻り値が"+flag+"で誤りです");   //預金額より大きい場合はじく
        else System.out.println("引き出し成功で正常です");                      //成功の場合
        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==0) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //三郎、一郎に続き引き出しまくる編
        flag=testBank.withdraw("三郎",25000);
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");        //存在しない口座
        else if(flag==-3) System.out.println("戻り値が"+flag+"で誤りです");   //残高が0以下
        else if(flag==-1) System.out.println("戻り値が"+flag+"で誤りです");   //預金額より大きい場合はじく
        else System.out.println("引き出し成功で正常です");                      //成功の場合
        //三郎、残高照会
        flag=testBank.showBalance("三郎");
        System.out.print("三郎:");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");    //口座が存在しない場合
        else if(flag==0) System.out.println("残高が"+flag+"円で正常です");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //さらば一郎、後編!
        flag=testBank.close("一郎");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");      //口座がない場合
        else if(flag==-1) System.out.println("戻り値が"+flag+"で誤りです"); //まだ残高がある場合
        else System.out.println("解約成功で正常です");                      //解約できた場合
        //一郎、残高照会
        flag=testBank.showBalance("一郎");
        System.out.print("一郎:");
        if(flag==-7) System.out.println("存在しない口座で正常です");    //口座が存在しない場合
        else if(flag==0) System.out.println("残高が"+flag+"円で誤りです");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合

        System.out.println("");

        //さらば三郎、後編!
        flag=testBank.close("三郎");
        if(flag==-7) System.out.println("戻り値が"+flag+"で誤りです");      //口座がない場合
        else if(flag==-1) System.out.println("戻り値が"+flag+"で誤りです"); //まだ残高がある場合
        else System.out.println("解約成功で正常です");                      //解約できた場合
        //三郎、残高照会
        flag=testBank.showBalance("三郎");
        System.out.print("三郎:");
        if(flag==-7) System.out.println("存在しない口座で正常です");    //口座が存在しない場合
        else if(flag==5000) System.out.println("残高が"+flag+"円で誤りです");    //正常な金額の場合
        else System.out.println("残高が"+flag+"円で誤りです");                //残高が違う場合
    }
}