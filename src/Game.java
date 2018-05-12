import java.io.File;
import java.util.Scanner;


import static javafx.scene.input.KeyCode.Z;

public class Game {

// fileds:
    private String guessChar;// 猜的字元
    private int times;//猜的次數
    private String result;// 猜中的字元及位置
    public String title;//題目


// counstruct:建立遊戲
      Game() {
          times = 0;
      }

// methes:
    // 制作題目
        public String getTheTitle() throws Exception {
            //取亂數
            int movieIndexOf;
            movieIndexOf = (int) (Math.random() * 10);
            //System.out.println(movieIndexOf);

            // 讀入電影檔 並亂數取猜測對像
            File movieName = new File("movies.txt");
            Scanner input = new Scanner(movieName);

            // 依亂數取出一個電影名當題目

            int word = 0;

            String[] noMoves = new String[10];
            while (input.hasNextLine()) {
                String line = input.nextLine();
                // for (X：Y組）即將Y裡的值 給X
                for (String retval : line.split("\n")) {
                    noMoves[word] = retval;
                    title = noMoves[movieIndexOf];
                    word++;
                }
            }
            return title;
        }


    // 用戶輸入猜測字母
        public void guess() {
            // guessChar = String.valueOf(System.in.read());
            //prOut("字在第 "+ guessChar.indexOf(str1)+"個");
            // prOut(guessChar);
            //isGetOrNot(guessChar);
//char x = s.charAt(8) :將S字串裡的第8個字元設為X 字符
            // jnd.indexOf('a'): 找出jnd字串中第1次a出現的位置
            //^[A-Za-z]+$
            //if()

            Scanner guessing = new Scanner(System.in);

            if (guessing.hasNext("[A-Za-z]")) {
                guessChar = guessing.next();
                prOut("输入的数据为：" + guessChar);
                isGetOrNot(guessChar);
            }else {
                prOut("請輸入 英文字母");
                guess();
            }
        }


    //檢查猜中字符及位罝
        public void isGetOrNot (String str1) {
          if(title.indexOf(str1) >= 0){
              prOut("有猜中");
          }else {
              prOut("沒有猜中");
          }
        }

    //玩家互動訊息，在螢幕秀出結果與提示
        public void prOut (String message) {
          System.out.print(message+"\n");
        }

    //main
        public static void main(String[] args)throws Exception{
           Game guessMovie = new Game();
           String exmeTitle = guessMovie.getTheTitle();
           for(int i = 10 ; i > 0 ; i-- ){
                System.out.print("REMAIN :"+i+" times!\n");
                System.out.print("Guess the movie:"+exmeTitle+">>"+exmeTitle.replaceAll(".","_"));//提示訊息
                System.out.print("Enter a char");
                guessMovie.guess();
            }
        }
}




