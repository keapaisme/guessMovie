import java.io.File;
import java.util.Scanner;

public class Game {

// fileds:

    private String title;//題目

// construct:建立遊戲
        public Game() throws Exception{

         }

// method:制作題目
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



}




