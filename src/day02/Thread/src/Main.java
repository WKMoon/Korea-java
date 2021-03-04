public class Main {
    public static void main(String[] args) {
        Go go = new Go();
        Come come = new Come();
        Stop stop = new Stop();
        Pause pause = new Pause();


        Thread th1 = new Thread(go);//10 go먼저
        Thread th2 = new Thread(come);//5
        Thread th3 = new Thread(stop);//1 stop나중에
        Thread th4 = new Thread(pause);//5

        th1.setPriority(Thread.MAX_PRIORITY);//10
        th3.setPriority(Thread.MIN_PRIORITY);//1

        th1.start();
        th2.start();
        th3.start();
        th4.start();
    }
}
