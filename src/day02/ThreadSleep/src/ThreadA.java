public class ThreadA extends Thread{

    public boolean stop=false;
    public boolean work=true;

    @Override
    public void run() {
        while(!stop){
            if(work){
                System.out.println("ThreadA work");
            }
            else{
                System.out.println("ThreadA YIELD");
                Thread.yield();
            }
        }
        System.out.println("ThreadA terminated");
    }
}
