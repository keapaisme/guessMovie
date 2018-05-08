import java.io.File;
import java.util.Scanner;

public class Game {

// fileds:
    private String guessChar;// 猜的字元
    private boolean getOrNot;
    //private int freeSteps;//
    private String result;// 猜中的字元及位置
    private String title;//題目


// counstruct:建立遊戲
        public Game() throws Exception{
          guess(getTheTitle());
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
                    this.title = noMoves[movieIndexOf];
                    word++;
                }
            }
            return this.title;
        }


    // 用戶輸入猜測字母，計算10次
        public void guess(String as){
            System.out.println("Guess the movie:"+as+">>"+as.replaceAll(".","_"));//提示訊息
            Scanner guessing = new Scanner(System.in);

            if (guessing.hasNext()) {
                String str1 = guessing.next();
                System.out.println("输入的数据为：" + str1);
            }
            guessing.close();

            //System.out.println("You are guessing:"+ guessing);


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
           Game guessMovie = new Game();
            }

    }




