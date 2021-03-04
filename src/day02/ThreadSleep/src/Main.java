import java.awt.*;

public class Main {
    public static void main(String[] args) {
        //sleep
//        Toolkit toolkit = Toolkit.getDefaultToolkit();
//        for(int i = 0; i < 10; i++){
//            toolkit.beep();
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }


    //yield
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        threadA.start();
        threadB.start();

        try {
            Thread.sleep(50);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        threadA.work = false;

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.work = true;
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        threadA.stop = true;
        threadB.stop = true;

    }
}
