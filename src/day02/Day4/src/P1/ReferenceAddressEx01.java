package P1;

public class ReferenceAddressEx01 {
    public static void main(String[] args) {
        Object1 obj1 = new Object1();
        Object2 obj2 = new Object2();
        Object2 obj3 = new Object2();

        if(obj2.equals(obj3)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

        if(obj1.irum1.equals(obj3.irum2)){
            System.out.println("true");
        }else{
            System.out.println("false");
        }


        String name1 = "moon";
        String name2 = "moon";
        if(name1==name2){
            System.out.println("true");
        }else{
            System.out.println("false");
        }

        String name3 = new String("moon");
        String name4 = new String("moon");
        if(name3==name4){
            System.out.println("true");
        }else{
            System.out.println("false");
        }
    }
}

class Object1{
    String irum1 = "홍길동";
}//end obj1

class Object2{
    String irum2 = "홍길동";
}//end obj2
