
import java.io.File;
import java.util.Scanner;

public class Game {

// fields:
    private String letter="";// 猜的字
    private String wrongLetter ="";
    private int times;//猜的次數
    private String result;// 猜中的字元及位置
    private String title;//題目
    public int length;
    private String guessTitle;//
    private boolean gameOver;
    private String [] as = new String[10];

// construct:建立遊戲
    Game() {
        times = 0;
        gameOver = false;
        //初始數組

      }

// method:
    // 制作題目
    public String getTheTitle() throws Exception {
            //取亂數
            int movieIndexOf;
            movieIndexOf = (int) (Math.random() * 10);//需要修改此處
            //System.out.println(movieIndexOf);

            // 讀入電影檔 並亂數取猜測對像
            File movieName = new File("movies.txt");
            Scanner movieFile = new Scanner(movieName);

            // 依亂數取出一個電影名當題目
            int word = 0;
            String[] noMoves = new String[10];
            while (movieFile.hasNextLine()) {
                String line = movieFile.nextLine();
                // for (X：Y組）即將Y裡的值 給X
                for (String retval : line.split("\n")) {
                    noMoves[word] = retval;
                    title = noMoves[movieIndexOf];
                    word++;
                }

            }

            for (int i = 0; i < as.length; i++) {
            as[i] = "-";
            System.out.print(as[i]+"");
        }
            length = title.length();
            return title;
        }

    // 用戶輸入猜測字母 5/14 不可改用 letter.matches("[a-z]") 因為要計算猜錯字
    public void guess() {
        //prOut("You are guessing :" + guessTitle);
        Scanner guessing = new Scanner(System.in);
        prOut("Guess a letter:"+ letter);
        if (guessing.hasNext("[A-Za-z]")) {
            letter = guessing.next();
            prOut("输入的字為：" + letter);
            isGetOrNot();
        }else {
            prOut("請輸入 英文字母");
            guess();
        }
    }

    //檢查猜中字符及顯示位罝
    public void isGetOrNot () {
        int posit = title.indexOf(letter);

        if(title.indexOf(letter) >=0 ){
            as[posit]=letter;
            //prOut("as "+posit+ as[posit]);
            for (int i = 0; i < as.length; i++) {
                System.out.print(as[i]+"");
            }
        }else {

            wrongLetter =  wrongLetter + letter +" ";
            times ++ ;
            if ( times == 10 ){
                gameOver = true;
            }
        }
        prOut("You have guessed ("+times+") wrong letters: "+ wrongLetter);
        guessTitle = as.toString();
    }

    //在螢幕秀出結果與提示
    public void prOut (String message) {
          System.out.print(message+"\n");
     }

    //main
    public static void main(String[] args)throws Exception{
          Game guessMovie = new Game();
          String exmeTitle = guessMovie.getTheTitle();
       //   guessMovie.guessTitle = exmeTitle.replaceAll(".","_");//提示訊息
         // System.out.print("You are guessing:" + guessMovie.guessTitle +"\n");
          //System.out.print("  you have 10 times can guess it!!\n");

          while( !guessMovie.gameOver ){
              guessMovie.guess();
          }
    }

}



/*

char x = s.charAt(8) :將S字串裡的第8個字元設為X 字符
            // jnd.indexOf('a'): 找出jnd字串中第1次a出現的位置

            //prOut("字在第 "+ guessChar.indexOf(str1)+"個");


                //檢查猜中字符及顯示位罝
    public void isGetOrNot () {
        if(letter.matches("[a-z]")){
            int posit = title.indexOf(letter);
            as[posit]=letter;
            prOut("as "+posit+ as[posit]);
        }else {
            wrongLetter =  wrongLetter + letter +" ";
            times ++ ;
            if ( times == 10 ){
                gameOver = true;
            }
        }
        //prOut("You are guessing:" + guessTitle);
        prOut("You have guessed ("+times+") wrong letters: "+ wrongLetter);
    }

 */
