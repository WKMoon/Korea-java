package P1;

import com.sun.org.apache.xalan.internal.xsltc.trax.XSLTCSource;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class ArrayEx01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
//        (1)
//        1.
        //int[] temperature = new int[5];
        //2.
        //int[] input = new int[3];
//        3.
        //int[] data = new int[3];
//        4.
//        double[] score = {3.1, 4.5};
//        5.
//         double[][] values = new double[3][4];
//        6.
//         double[][] eval = new double[3][4];
//        7.
//        double[][] unit = {{1.1,2.3},{3.4,4.5}};
//        8.
//        double[] price = {2.3,3.4,5.6,2.1};
//        9.
//        double[][] amount = {{3.1,5.4,7.3},{4.3}};
//        10.
//        double[][][] time = {{6.1, 7.2}, {3.4, 5.6}, {3.9}};

//        (2)
//        double[] real = {2.13,5.71,2.87,7.89};
//        int[] ary = new int[12];
//        ary[2] = 10;
//
//        int[][] two = new int[3][4];
//        two[2][3] = 20;
//
//        int[] cnt = new int[20];
//
//        int[][] matrixA = {{12,23}{3,73},{43,2}};

//        Q1
//        System.out.println("Enter 10 num");
//        int num[] = new int[10];
//        int sum = 0;
//        for(int i = 0; i < num.length; i++){
//            System.out.println("Enter num");
//            num[i] = sc.nextInt();
//        }//end for
//        for(int i = 0; i < num.length; i++){
//            sum += num[i];
//        }//end for
//
//        System.out.println(sum);
//        System.out.println(sum/10);

//        Q2

//        double num[] = new double[10];
//        for(int i = 0; i < num.length; i++){
//            System.out.println("Enter double num");
//            num[i] = sc.nextInt();
//        }//end for
//
//        double min = num[0];
//        double max = num[0];
//
//        for(int i = 0; i < num.length; i++){
//            if(max < num[i]){
//                max = num[i];
//            }
//        }
//        for(int i = 0; i < num.length; i++){
//            if(min > num[i]){
//                min = num[i];
//            }
//        }
//        System.out.println(max);
//        System.out.println(min);

//        Q3
//
//        int[][] score = new int[5][2];
//        for(int i = 0; i < score.length; i++){
//            System.out.println(i+1 + "번째 국어점수는?");
//            score[i][0] = sc.nextInt();
//            System.out.println(i+1 + "번째 영어점수는?");
//            score[i][1] = sc.nextInt();
//        }//end for
//        int[] sum = new int[5];
//        for(int i = 0; i < sum.length; i++){
//            sum[i] = score[i][0] + score[i][1];
//        }//end for
//
//        System.out.println("번호 국어 영어 합계 평균 석차");
//
//        int[] rank = {1,1,1,1,1};
//        for(int i = 0; i < sum.length; i++){
//            for(int j = 0; j < sum.length; j++){
//                System.out.println(sum[i] + " " + sum[j]);
//                if(sum[i] < sum[j]){
//                    rank[i] += 1;
//                }//end if
//            }//end for
//        }//end for
//
//        for(int i = 0; i < score.length; i++){
//            System.out.print(i+1 + "  " + score[i][0] + "  " + score[i][1] + "  " + sum[i] + "  " + sum[i] + "  " + rank[i]);
//            System.out.println();
//        }//end for


//        Q4
//        String word;
//        int[] alpha = new int[26];   //알파벳 개수 넣을 배열
//
//        System.out.println("문자를 입력하세요: ");
//        word =sc.next();
//
//        for(int i=0;i<word.length();i++) {
//            char ch = word.charAt(i);
//            alpha[ch-97]++;
//        }
//        for(int i=0;i<26;i++) {
//            if(alpha[i]==0) {
//                continue;
//            }else {
//                System.out.println((char)(i+97)+": "+alpha[i]);
//            }
//        }

//
//        boolean[] bool = new boolean[3];
//        Student[] st = new Student[3];
//        InterEx[] in = new InterEx[3];
//        for(int i = 0; i < bool.length; i++){
//            System.out.println(bool[i]);
//        }
//        for(int i = 0; i < in.length; i++){
//            System.out.println(in[i]);
//        }



    }//end main
}//end class

class Student{

}

interface InterEx{

}