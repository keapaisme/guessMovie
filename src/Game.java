
import java.io.File;
import java.util.Scanner;

/**
 * 項目2：猜測電影
 * 计算机随机选择一个电影名称，并告诉你它由多少个字母组成。你的目标是通过一次猜测一个字母猜出电影名称。
 * 如果名称中的确有该字母，计算机将告诉你它在单词中的位置，如果不在名称里，那么你就失去一分。如果你失去 10 分，游戏结束！
 * @author Kas Huang
 * @version 1.0
 */

public class Game {
// fields:
    private String letter;// 猜的字元
    private String wrongLetter ="";//玩家猜錯的字元
    private int times;//猜的次數
    private String title;//題目
    private boolean gameOver;//遊戲是否結束
    private String result="";//儲存玩家猜中的字
    private char [] guessWordArray = {};//存放最新猜測結果

// construct:建立遊戲
    Game() {
        times = 0;
        gameOver = false;
    }

// method:
    /**
     * 這個Methos用來制作題目:讀入電影檔Txt，
     * 計算未知題目個數 movNum，建題目數組 movies[]，
     * 依亂數取出一個電影名當題目 title
     * @throws Exception
     */
    public void getTheTitle() throws Exception {
            // 讀入電影檔
            File moviesFile = new File("movies.txt");
            Scanner scan = new Scanner(moviesFile);

            // 計算題目個數
            String movNum ="";
            int count = 0;
            while(scan.hasNextLine()){
                count++;
                movNum = movNum+scan.nextLine()+"-";
            }
            String [] movies = new String[count];
            movies = movNum.split("-");

            //依亂數取出一個電影名當題目
            title =  movies[(int) (Math.random() * count )];
            result = title.replaceAll("[a-zA-Z]", "_");
            //將題目字串 title 存成 數組 titleWordArray
            guessWordArray = result.toCharArray();
    }
    /**
     * 這Method提示玩家輸入猜測字母,
     * 提示猜錯的字母及猜錯幾次
     * 判斷猜中了還是錯了10次即結束遊戲
     */
    public void guess() {
        prOut("You are guessing :" + String.valueOf(guessWordArray));
        prOut("You have guessed (" + times + ") wrong letters: " + wrongLetter);
        if((String.valueOf(guessWordArray)).equals(title)){
            prOut("******* you win ********");
            gameOver = true;
            return;
        }
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
    /**
     * 這method檢查猜中字符及顯示位罝:
     */
    public void gotIt () {
        if(title.indexOf(letter)>= 0){
        int x = 0;
        while ( x <= title.length()-1 ){
            if (title.startsWith(letter,x)){
                guessWordArray[x]= letter.charAt(0);
            }
            x++;
        }
            } else {
                wrongLetter = wrongLetter + letter + " ";
                times++;
                if (times == 10) {
                    gameOver = true;
                }
            }
    }
    /**
     * 這method在螢幕秀出結果與提示
     */
    public void prOut (String message) {
          System.out.print(message+"\n");
     }

// main：
    public static void main(String[] args)throws Exception{
          Game guessMovie = new Game();
          guessMovie.getTheTitle();
          while( !guessMovie.gameOver ){
              guessMovie.guess();
          }
    }
}

/**
 * 這裡標示進度及預計完成的功能
 * 2018/5/20
 * 1. 寫文檔
 * 2. 統一參數名稱，並精簡
 * 3. 使輸出符合 project 輸出要求
 * 2018/5/14
 * 1. 將所有螢幕輸出集中統一
 * 2. title 檢測 重複字元並正確顯示
 * 3. 考慮題目有空格的做法
 * 4. 依題目大小取亂數
 * 5. 判斷猜對
 * 未完成
 * 1. 玩家重複猜的字應不要計算，要提醒
 * 2. 檢查輸入enter無KEY字元要提醒
 * 3. 拆成兩個類
*/
