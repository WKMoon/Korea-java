public class Main {
    public static void main(String[] args) {
        PrintThread1 printThread1 = new PrintThread1();
        printThread1.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        printThread1.setStop(true);

    }
}

class PrintThread1 extends Thread{
    private boolean stop;
    public void setStop(boolean stop){
        this.stop = stop;
    }

    @Override
    public void run() {
        while(!stop){
            System.out.println("Processing");
        }
        System.out.println("자원정리 - 열려있는 네트워크 로그아웃, 데이터베이스 닫기, 파일 닫기");
        System.out.println("Terminate");
    }
}
