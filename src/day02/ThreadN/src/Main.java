public class Main {
    public static void main(String[] args) {
        Thread ct = Thread.currentThread();
        System.out.println("프로그램 시작 스레드 이름: " + ct);
        ThreadA threadA = new ThreadA();
        ThreadB threadB = new ThreadB();

        System.out.println(threadA.getName());
        System.out.println(threadB.getName());



    }

}
