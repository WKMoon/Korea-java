import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BusinessClass bc = new BusinessClass();
        while(true){
            System.out.println("-------------------------------");
            System.out.println("성적 관리 프로그램");
            System.out.println("-------------------------------");
            System.out.println("1.입력 2.출력 3.종료");
            System.out.println("선택-->");
            int sel = sc.nextInt();

            switch(sel){
                case 1: bc.input(); break;
                case 2: bc.output(bc.arr);break;
                case 3: System.exit(0);
            }//end switch
        }//end while
    }//end main
}//end class
