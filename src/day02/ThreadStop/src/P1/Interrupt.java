package P1;

public class Interrupt {
    public static void main(String[] args) {
        PrintThread2 printThread2 = new PrintThread2();
        printThread2.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        printThread2.interrupt();
    }
}

class PrintThread2 extends Thread{
    @Override
    public void run() {
//        방법 1
//        try {
//            while(true){
//                System.out.println("Processing");
//                Thread.sleep(1);
//            }//end while
//        } catch (InterruptedException e) {
//            System.out.println("예외 발생하여서 종료함");
//        }//end catch

//        방법 2
        while(true){
            System.out.println("Processing");
            if(Thread.interrupted()){
             break;
            }//end if
        }

        System.out.println("자원정리");
        System.out.println("실행종료");
    }//end run
}//end class
