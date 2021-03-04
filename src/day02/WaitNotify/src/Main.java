public class Main {
    public static void main(String[] args) {
        WorkObject sharedObj = new WorkObject();

        ThreadA threadA = new ThreadA(sharedObj);
        ThreadB threadB = new ThreadB(sharedObj);

        threadA.start();
        threadB.start();

    }
}
