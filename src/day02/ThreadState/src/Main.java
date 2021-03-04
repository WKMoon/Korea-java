public class Main {
    public static void main(String[] args) {
        StatePrintThread statePrintThread = new StatePrintThread(new TargetThread());

        statePrintThread.start();

    }
}
