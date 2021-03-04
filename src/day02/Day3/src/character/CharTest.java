package character;

import java.util.Scanner;

public class CharTest {
    public static void main(String[] args) {

//        Q1
//        int cnt = 0;
//            for(int i = 1; i <= 100; i++){
//                if(i % 2 != 0 && i % 3 != 0 && i % 5 != 0 && i % 7 != 0){
//                    System.out.printf("%5d",i);
//                    cnt++;
//                }
//                if(cnt == 10){
//                    System.out.println();
//                    cnt = 0;
//                }
//            }

//        Q2
//        int i, j;//i는 행의 첨자 변수, j는 열의 첨자 변수
//        for(i = 0; i < 8; i++){
//            for(j = 8; j >= -8; j--){
//                if(Math.abs(j) > i){
//                    System.out.print(' ');
//                }
//                else{
//                    System.out.printf("%d", Math.abs(j));
//                }
//            }
//            System.out.println();
//        }


//        Q3

//        Q5

//        Q7
//        System.out.println("Enter num");
//        Scanner sc = new Scanner(System.in);
//        int sum = 0;
//        int num = sc.nextInt();
//
//        for(int i = 1; i <= num; i++){
//            sum += i;
//            if(sum >= 5000){
//                sum -= i;
//                break;
//            }
//        }//end for
//        System.out.println(sum);


//        Q8
        //        for(int i = 1; i <= 9; i++){
//            for(int j = 2; j <= 9; j++){
//                System.out.print(j +"*"+ i +"=" + i*j + " ");
//            }//end for
//            System.out.println();
//        }//end for
//
//        System.out.println();
//        System.out.println();
//
//        for(int i = 2; i <= 9; i++){
//            for(int j = 1; j <= 9; j++){
//                System.out.print(i +"*"+ j +"=" + i*j + " ");
//            }//end for
//            System.out.println();
//        }//end for
//        System.out.println();
//        System.out.println();
//Q9
//        for(int i = 1; i <= 5; i++){
//            for(int j = 1; j <= 5; j++){
//                System.out.print("["+ i + ","+ j +"]");
//            }//end for
//            System.out.println();
//        }//end for
//
//        System.out.println();
//        System.out.println();
//Q10
//        for(int i = 1; i <= 5; i++){
//            for(int j = i; j <= i; j++){
//                System.out.print("["+ i + ","+ j +"]");
//            }//end for
//            System.out.println();
//        }//end for
//        Q11
//        Scanner sc = new Scanner(System.in);
//        System.out.print("가위(1), 바위(2) 보(3)중 하나를 입력하세요 -->");
//        int sel = sc.nextInt();
//
//        int com = (int)(Math.random() * 3) + 1;
//
//        System.out.println("당신은 " + sel + "입니다.");
//        System.out.println("컴퓨터는 " + com + "입니다.");
//        switch(sel){
//            case 1:
//                if(com == 1){
//                    System.out.println("비겼습니다.");
//                }else if(com == 2){
//                    System.out.println("졌습니다.");
//                }else{
//                    System.out.println("이겼습니다.");
//                }
//                break;
//
//            case 2:
//                if(com == 1){
//                    System.out.println("이겼습니다.");
//                }else if(com == 2){
//                    System.out.println("비겼습니다.");
//                }else{
//                    System.out.println("졌습니다.");
//                }
//                break;
//            case 3:
//                if(com == 1){
//                    System.out.println("졌습니다.");
//                }else if(com == 2){
//                    System.out.println("이겼습니다.");
//                }else{
//                    System.out.println("비겼습니다.");
//                }
//                break;
//        }//end switch
//Q12
//        System.out.println("1과 100사이의 정수를 입력하세요");
//        Scanner sc = new Scanner(System.in);
//        int num = sc.nextInt();
//        int com = (int)(Math.random() * 100)+1;
//        while(true) {
//            if (num == 100) {
//                System.out.println("정답입니다.");
//                break;
//            }//end if
//            else if (num > 100) {
//                System.out.println("더 작은 값으로 다시 시도하세요");
//                continue;
//            }//end else if
//            else {
//                System.out.println("더 큰 값으로 다시 시도하세요");
//                continue;
//            }
//        }//end while

//        Q13
//        Scanner sc = new Scanner(System.in);
//        int sum = 0;
//        while(true){
//            System.out.println("입력하세요");
//            int num = sc.nextInt();
//            sum += num;
//            if(num == 0){
//                break;
//            }
//        }
//        System.out.println(sum);

//        Q14
//        Scanner sc = new Scanner(System.in);
//        System.out.println("수를 입력하세요");
//        String num = sc.next();
//        int sum = 0;
//        int length = num.length();
//        for(int i = 0; i < length; i++){
//            sum += Integer.parseInt(String.valueOf(num.charAt(num.length()-1)));
//            System.out.println("sum = " + sum + " number = " +num.toString());
//            num = num.substring(0,num.length()-1);
//        }//end for
//
//        System.out.println(sum);
//


    }//end main

}//end CharTest

//    int i=0, cnt = 0;
//        boolean flag = true;
//        while(flag){
//            i++;
//            if(i%2 == 0){
//                System.out.printf("%5d",i);
//            }
//            cnt++;
//            if(cnt==10){
//                System.out.println();
//                cnt=0;
//            }
//            if(i==100) flag = false;
//        }


//        int i = 101, cnt = 0;
//        do{
//
//            i--;
//
//            if(i % 5 != 0 || i % 10 == 0) {
//                System.out.printf("%5d", i);
//                cnt++;
//            }
//            if(cnt == 20){
//                System.out.println();
//                cnt = 0;
//            }
//            if(i == 1) break;
//        }while(true);