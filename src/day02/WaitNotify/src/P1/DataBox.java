package P1;

public class DataBox {
    public synchronized String getData() {
        if(this.data == null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//end if
            String returnValue = data;
            System.out.println("ComsumerThread read this data: " + returnValue);
            data = null;
            notify();
            return returnValue;
    }//end getData

    public synchronized void setData(String data) {
        if(this.data != null){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }//end if
        this.data = data;
        System.out.println("ProducerThread generate data: " + data);
        notify();

    }//end setData

    private String data;

}
