public class Main {
    public static void main(String[] args) {
        Calc calc = new Calc();

        User1 user1 = new User1();
        User2 user2 = new User2();
        user1.setCalc(calc);
        user1.start();

        user2.setCalc(calc);
        user2.start();
    }
}
