
public class Calc {
    public int getMemory() {
        return memory;
    }

    public void setMemory(int memory) {
        System.out.println("여러 쓰레드가 출력할수 있는 곳");
        synchronized (this){
            this.memory = memory;
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + ": " + this.memory);
        }//end block
        System.out.println("여러 쓰레드가 출력할수 있는 곳");

    }

    private int memory;

}
