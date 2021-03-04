public class User1 extends Thread{
    private Calc calc;

    public Calc getCalc() {
        return calc;
    }

    public void setCalc(Calc calc){
        this.setName("User1");
        this.calc = calc;
    }

    @Override
    public void run() {
        calc.setMemory(100);
    }
}
