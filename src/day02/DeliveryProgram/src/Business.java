import java.util.Scanner;

public class Business {
    Scanner sc = new Scanner(System.in);
    DeliveryClass[] dc = new DeliveryClass[10];



    void start(){
        displayMenu();
    }//end start

    void displayMenu(){
            System.out.println("----------------------------");
            System.out.println("Delivery Status Program");
            System.out.println("----------------------------");
            System.out.print("Programmer: ");
            String prog = sc.next();
        while(true){

            System.out.println("1.input 2.output 3.exit");
            System.out.print("Select-->");
            int sel = sc.nextInt();

            switch (sel){
                case 1: input(); break;
                case 2: output(); break;
                case 3: System.exit(0);
            }//end switch
        }//end while
    }//end displayMenu

    int i = 0;
    void input(){
        while(true){
            System.out.println("Delivery Area(1.KangDong 2.KangSeo 3.KangNam 4.KangNam)");
            System.out.print("Select-->");
            int area = sc.nextInt();
            System.out.print("Delivery time? -->");
            int time = sc.nextInt();
            System.out.println("Delivery amount? -->");
            int amount = sc.nextInt();

            if(area == 1){
                    dc[i++] = new KangDong("Jang", "KangDong", time, amount);
            }//end if
            else if(area == 2){
                dc[i++] = new KangSeo("Park", "KangSeo", time, amount);
            }//end if
            else if(area == 3){
                dc[i++] = new KangNam("Lee", "KangNam", time, amount);
            }//end if
            else if(area == 2){
                dc[i++] = new KangBuk("Kim", "KangBuk", time, amount);
            }//end if

            System.out.println("Do you want to keep going?(y/n)");
            String ans = sc.next();
            if(ans.equals("n")) break;
        }//end while
    }//end input


    void output(){
        while(true) {
            System.out.println("1.Each Area 2.All Area 3.Exit");
            System.out.println("Select -- >");
            int sel = sc.nextInt();
            switch(sel){
                case 1: eachArea(); break;
                case 2: allArea(); break;
                case 3: System.exit(0);
            }//end switch
        }//end while
    }//end output

    void eachArea(){
        System.out.println("DeliveryMan Time Amount Fee");
        for(int i = 0; i < dc.length; i++){
            if(dc[i] == null) break;
            if(dc[i].area == "KangDong"){
                System.out.println("---------------");
                System.out.println("KangDong");
                System.out.println(dc[i].name + "  " + dc[i].time + "  " + dc[i].amount + "  " + dc[i].deliveryFee());
            }
            else if(dc[i].area == "KangSeo"){
                System.out.println("---------------");
                System.out.println("KangSeo");
                System.out.println(dc[i].name + "  " + dc[i].time + "  " + dc[i].amount + "  " + dc[i].deliveryFee());
            }
            else if(dc[i].area == "KangNam"){
                System.out.println("---------------");
                System.out.println("KangNam");
                System.out.println(dc[i].name + "  " + dc[i].time + "  " + dc[i].amount + "  " + dc[i].deliveryFee());
            }
            else if(dc[i].area == "KangBuk"){
                System.out.println("---------------");
                System.out.println("KangBuk");
                System.out.println(dc[i].name + "  " + dc[i].time + "  " + dc[i].amount + "  " + dc[i].deliveryFee());
            }
        }
    }//end eachArea

    void allArea(){
        System.out.println("DeliveryMan Time Amount Fee");
        for(int i = 0; i < dc.length; i++){
            if(dc[i] == null) break;
            System.out.println(dc[i].name + "  " + dc[i].time + "  " + dc[i].amount + "  " + dc[i].deliveryFee());
        }
    }//end allArea
}//end class
