public class User2 extends Thread{
    private Calc calc;

    public Calc getCalc() {
        return calc;
    }

    public void setCalc(Calc calc){
        this.setName("User2");
        this.calc = calc;
    }

    @Override
    public void run() {
        calc.setMemory(50);
    }
}
