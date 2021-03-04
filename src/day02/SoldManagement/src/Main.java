import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Manager m = new Manager();

        while(true){
            System.out.println("---------------------------");
            System.out.println("판매량 관리 프로젝트");
            System.out.println("---------------------------");
            System.out.println("1.입력 2.출력 3.종료");

            int sel = sc.nextInt();
            switch (sel){
                case 1: m.buy(); break;
                case 2:
                    System.out.println(m.output(m.comArr)); break;
                case 3: System.exit(0);
            }//end switch
        }//end while
    }//end void

}//end class
