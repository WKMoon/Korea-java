package P1;

public class Main {
    public static void main(String[] args) {
        DataBox dataBox = new DataBox();//shared obj
        ProducerThread producerThread = new ProducerThread(dataBox);
        ConsumerThread consumerThread = new ConsumerThread(dataBox);

        producerThread.start();
        consumerThread.start();


    }
}
