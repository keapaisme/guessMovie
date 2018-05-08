import java.util.Scanner;

public class GuessIO {
//field:

    private String guessChar;// 猜的字元
    private boolean getOrNot;
    //private int freeSteps;//
    private String result;// 猜中的字元及位置

//struct:
    public GuessIO(){

    }
//method:
    // 用戶輸入猜測字母，計算10次
    public void guess(String as){
        System.out.println("Guess the movie:"+as+">>"+as.replaceAll(".","_"));
        Scanner guessing = new Scanner(System.in);

        if (guessing.hasNext()) {
            String str1 = guessing.next();
            System.out.println("输入的数据为：" + str1);
        }
        guessing.close();



    }
    //檢查猜中幾個字及位罝
    public boolean isGetOrNot () {
        return getOrNot;
    }

    //玩家互動訊息，在螢幕秀出結果與提示
    public String checkWin () {
        return result;
    }

    //main
    public static void main(String[] args)throws Exception{
        Game xxx = new Game();
        System.out.print(xxx.getTheTitle()+"This version need 2.09 sec");
    }

}
