package com.company;

import java.util.Scanner;
import java.io.File;
import java.util.Arrays;

public class Main {


    public static void main(String[] args) throws Exception {
        //亂數取題目
        int movieIndexOf;
        movieIndexOf = (int) (Math.random() * 10 );
        System.out.println(movieIndexOf);

        // 讀入電影檔 並亂數取猜測對像
        File movieName = new File("movies.txt");
        Scanner scan = new Scanner(movieName);




        int word = 0;
        String [] noMoves = new String[10];
        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            // for (X：Y組）即將Y裡的值 給X
            for ( String retval : line.split("\n")) {
                noMoves[word] = retval;
              word = word +1;
            }
        }
        System.out.println(noMoves[movieIndexOf]);
       }




    }

        // 用戶輸入猜測字母，計算10次
        // 檢查是否有猜中 並在螢幕秀出結果與提示


