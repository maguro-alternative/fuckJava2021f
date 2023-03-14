//佐々木陽貴
//20206076
//課題9-Account.java
public class Account {
    private String name; /* 口座名 */
    private int balance; /* 口座の残高 */
    /* コンストラクタ　*/
    public Account(String myName){/* 口座名 */
        name=myName;    //口座のお名前で初期化
        balance=0;      //初期残高は0!!!!!!(悲しいね、普通1000円預金するのが常識だよね。)
    }
    /* 預金 */
    public int deposit(int amount){/* 預金額 */
        if(amount>0)balance=balance+amount;    //口座に入金(給与日は15,25日！常識だよね。)
        else return -3;                 //0以下ははじきますわよ
        return 0;                       //入金出来たらここに来るはず(0が返ってくる！！)
    }
    /* 払い戻し*/
    public int withdraw(int amount){/* 出金額 */
        int flag=0;                         //入金のフラグ管理を行う変数
        if(amount>balance)flag=-1;          //預金額より大きい場合は-1を返しはじく
        if(amount<1)flag=-3;                //0以下も-3で玉砕
        if(flag==0)balance=balance-amount;    //口座から引き出し(もの買うのってワクワクするよね)
        return flag;                        //フラグ管理の値をそのまま返す
    }
    /* 残高照会 */
    public int showBalance(){
        return balance;         //残高がそのまま返り血に
    } 
}
