public class ThreadB extends Thread{
    public boolean stop=false;
    public boolean work=true;

    @Override
    public void run() {
        while(!stop){
            if(work){
                System.out.println("ThreadB work");
            }
            else{
                System.out.println("ThreadA YIELD");

                Thread.yield();
            }
        }
        System.out.println("ThreadB terminated");
    }
}
