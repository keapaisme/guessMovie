
import java.io.File;
import java.util.Scanner;

public class Game {

// fields:
    private String letter;// 猜的字元
    private String wrongLetter ="";//玩家猜錯的字元
    private int times;//猜的次數
    private String theAnswer = "";// 猜中的字元及位置
    private String title;//題目
    private String guessTitle ="";//
    private boolean gameOver;
    private String result="";//儲存玩家猜中的字
    private char [] guessWordArray = {};
// construct:建立遊戲
    Game() {
        times = 0;
        gameOver = false;
    }
// method:
    // 制作題目:讀入電影檔Txt，計算未知題目個數 i，建題目數組 movies[]，依亂數取出一個電影名當題目 title
    public  void getTheTitle() throws Exception {
            // 讀入電影檔
            File moviesFile = new File("movies.txt");
            Scanner scan = new Scanner(moviesFile);
            // 計算未知題目個數 i
            int i = 0;
            String [] movies = new String[10];
            while (scan.hasNextLine()) {
               movies[i] = scan.nextLine(); //?為什麼一定要有這一行才能計算否則會無限加下去
               i ++ ;
            }
            //依亂數取出一個電影名當題目
            title =  movies[(int) (Math.random() * i )];
            result = title.replaceAll("[a-zA-Z0-9]", "-");
            //將題目字串 title 存成 數組 titleWordArray
            guessWordArray = result.toCharArray();
            prOut(title+"  title length  ="+title.length());
        prOut(result+"  result length  ="+result.length());
        prOut(guessWordArray+"  guessWordArray length  ="+guessWordArray.length);
        }

    // 用戶輸入猜測字母 5/14 不可改用 letter.matches("[a-z]") 因為要計算猜錯字
    public void guess() {
        prOut("You are guessing :" + String.valueOf(guessWordArray));
        Scanner guessing = new Scanner(System.in);
        prOut("Guess a letter:");
        if (guessing.hasNext("[A-Za-z]")) {
            letter = guessing.next();
            prOut("输入的字為：" + letter);
            gotIt();
        }else {
            prOut("請輸入 單一英文字母");
            guess();
        }
    }

    //檢查猜中字符及顯示位罝:
    public void gotIt () {
        if(title.indexOf(letter)>= 0){
        int x = 0;
        while ( x <= title.length()-1 ){
            if (title.startsWith(letter,x)){
                guessWordArray[x]= letter.charAt(0);
            }x++;
        }
            } else {
                wrongLetter = wrongLetter + letter + " ";
                times++;
                if (times == 10) {
                    gameOver = true;
                }
            }


        prOut("You have guessed (" + times + ") wrong letters: " + wrongLetter);
        //guessTitle = as.toString();
        //result = theAnswer;
        //return theAnswer;

    }

    //在螢幕秀出結果與提示
    public void prOut (String message) {
          System.out.print(message+"\n");
     }

    //main
    public static void main(String[] args)throws Exception{
          Game guessMovie = new Game();
          guessMovie.getTheTitle();
          while( !guessMovie.gameOver ){
              guessMovie.guess();
          }
    }
}


/* 2018/5/14
//  1. 將所有螢幕輸出集中統一
//  2. title 檢測 重複字元並正確顯示
//  3. 考慮題目有空格的做法
//  4. 統一參數名稱，並精簡
//  5. 將儲存猜字的數組 as 加一個題目出了後去尾巴的動作[取消]
//  6. 玩家重複猜的字應不要計算，要提醒
//  7. 檢查輸入enter無KEY字元要提醒
//  8.
*/
/*
//將題目字串 title 存成 數組 titleWordArray
            char [] titleWordArray = title.toCharArray();
 */