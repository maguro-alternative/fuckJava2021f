//佐々木陽貴
//20206076
//課題9-ExtendedBank.java
import java.util.Hashtable;

public class ExtendedBank {
    private Hashtable<String, Account> customer; /* 口座リスト */

    public ExtendedBank(){  /* 口座リストを初期化する */
        customer = new Hashtable<String,Account>();
        // 必要な処理があれば追加する        
    } 
    /* 口座開設 */
    public int open(String name){/* 口座名 */
        if(customer.get(name)!=null) return -7;
        else{
            Account acName=new Account(name);
            customer.put(name,acName);
        }
        return 0;
    }
    /* 口座解約 */
    public int close(String name){/* 口座名 */
        if(customer.get(name)==null) return -7;
        if(customer.get(name).showBalance()!=0) return -1;
        customer.remove(name);
        return 0;
    }
    /* 預金 */
    public int deposit(String name, int amount){/* 口座名 , 預金額 */
        if(customer.get(name)==null) return -7;
        return customer.get(name).deposit(amount);
    } 
    /* 払い戻し*/
    public int withdraw(String name, int amount){/* 口座名 , 引き出し額 */
        if(customer.get(name)==null) return -7;
        return customer.get(name).withdraw(amount);
    } 
    /* 預金 */
    public int deposit(String name, String amount){/* 口座名 , 預金額 */
        try{
            return this.deposit(name,Integer.parseInt(amount));
        }catch(NumberFormatException e){
            if(this.showBalance(name)==-7) return this.showBalance(name);
            return -4;
        }
    } 
    /* 払い戻し*/
    public int withdraw(String name, String amount){/* 口座名 , 引き出し額 */
        try{
            return this.withdraw(name,Integer.parseInt(amount));
        }catch(NumberFormatException e){
            if(this.showBalance(name)==-7) return this.showBalance(name);
            return -4;
        }
    } 
    /* 残高照会 */
    public int showBalance(String name){/* 口座名 */
        if(customer.get(name)==null) return -7;
        return customer.get(name).showBalance();
    } 
}