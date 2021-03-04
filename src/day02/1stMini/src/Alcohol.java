import java.util.*;

import static java.lang.System.*;

public class Alcohol {
    static Scanner sc = new Scanner(System.in);
    static List<Info> arr = new LinkedList<>();//For speeding up from Editing and Deleting.
    static private final String ID = "moon";
    static private final int PASS = 1234;

    public static void main(String[] args) {
        int cnt=1;
        while(true){
            out.println("Enter Name: ");
            String name = sc.next();
            out.println("Enter Password");
            while (!sc.hasNextInt()) {
                String input = sc.next();
                System.out.printf("\"%s\" is not a valid number.\n", input);
                out.println("Enter Password (Enter Number)");
            }//end while
            int password = sc.nextInt();
            if(cnt == 3){
                out.println("Failed 3 times. Bye Bye");
                System.exit(0);
            }//end if
            if(ID.equals(name) && PASS == password){
                break;
            }//end if
            else if(!ID.equals(name)){
                out.println("Invalid ID. Try again. Failed "+cnt);
                cnt++;
                continue;
            }//end else if
            else if(PASS != password){
                out.println("Invalid Password. Try again. Failed "+cnt);
                cnt++;
                continue;
            }//end else if

        }//end while

        int select;
        while(true){
            out.println("-------Moon's Alcohol-------");
            out.println("1. Register Record");
            out.println("2. Edit Record");
            out.println("3. Delete Record");
            out.println("4. Check Record");
            out.println("5. All of Record");
            out.println("0. Exit");
            System.out.println("Select: ");
            select = sc.nextInt();

            switch (select){
                case 1: input(); break;
                case 2: edit(); break;
                case 3: delete(); break;
                case 4: check(); break;
                case 5: display(); break;
                case 0: out.println("Bye Bye");exit(0);
                default: break;
            }//end switch

        }//end while

    }//end main



    private static void input(){
        do {
            String name;
            int num;
            int price;
            do{
                out.println("Enter Name of Alcohol");
                name = sc.next();
                out.println("Enter Number of sold the product");
                while (!sc.hasNextInt()) {
                    String input = sc.next();
                    System.out.printf("\"%s\" is not a valid number.\n", input);
                    out.println("Enter Number of sold the product");
                }//end while
                num = sc.nextInt();
                out.println("Enter price of the product");
                while (!sc.hasNextInt()) {
                    String input = sc.next();
                    System.out.printf("\"%s\" is not a valid number.\n", input);
                    out.println("Enter price of the product");
                }//end while

                price = sc.nextInt();

                if (letter(name)) //CALL to validate function
                {
                    break; //or loop = false;
                }else // if function returns false
                {
                    out.println("Invalid Type, please try again");
                    continue;
                }
            }while(true);


            for(int i = 0; i < arr.size(); i++){
                String checkDup = arr.get(i).getName();
                if(checkDup.equals(name)){
                    out.println("There is same product. Expected Edit");
                    edit();
                    return;
                }//end if
            }//end for

            Info info = new Info(name, num, price);
            arr.add(info);

            String ans;
            do{
                out.println("Do you want to add more? (y/n)");
                ans = sc.next();
                if (asking(ans)) //CALL to validate function
                {

                    break; //or loop = false;
                }else // if function returns false
                {
                    out.println("Invalid answer, please try again");
                    continue;
                }
            }while(true);//validate name


            if(ans.equals("y")){
                continue;
            }//end if
            else if(ans.equals("n")){
                break;
            }//end else if
        }while(true);
    }//end input



    private static void edit(){
            do{
                int i;
                while(true) {
                    if(arr.size() == 0){
                        out.println("There is no record. Lets get back to Menu");
                        return;
                    }//end if
                    for(int k = 0; k < arr.size(); k++){
                        out.println((k+1) + "." + arr.get(k).getName());
                    }//end for
                    out.println("What data do you want to edit? (Enter Number)");
                    while (!sc.hasNextInt()) {
                        String input = sc.next();
                        System.out.printf("\"%s\" is not a valid number.\n", input);
                        out.println("What data do you want to edit? (Enter Number)");
                    }//end while
                    i = sc.nextInt();
                    if (i > arr.size() || i < 1) {
                        out.println("Invalid Input");
                        continue;
                    }//end if
                    else {
                        String name;
                        int num;
                        int price;
                        do{
                            out.println("Enter Name of Alcohol");
                            name = sc.next();
                            out.println("Enter Number of sold the product");
                            while (!sc.hasNextInt()) {
                                String input = sc.next();
                                System.out.printf("\"%s\" is not a valid number.\n", input);
                                out.println("Enter Number of sold the product");
                            }//end while
                            num = sc.nextInt();
                            out.println("Enter price of the product");
                            while (!sc.hasNextInt()) {
                                String input = sc.next();
                                System.out.printf("\"%s\" is not a valid number.\n", input);
                                out.println("Enter price of the product");
                            }//end while
                            price = sc.nextInt();
                            if (letter(name)) //CALL to validate function
                            {

                                break; //or loop = false;
                            }else // if function returns false
                            {
                                out.println("Invalid Type, please try again");
                                continue;
                            }
                        }while(true);

                        out.println(arr.get(i-1).getName() + " is changed to "+ name);
                        out.println(arr.get(i-1).getNum() + " is changed to "+ num);
                        out.println(arr.get(i-1).getPrice() + " is changed to "+ price);

                        arr.get(i - 1).setName(name);
                        arr.get(i - 1).setNum(num);
                        arr.get(i - 1).setPrice(price);

                        break;
                    }//end else
                }//end while

                String ans;
                do{
                    out.println("Do you want to edit more? (y/n)");
                    ans = sc.next();
                    if (asking(ans)) //CALL to validate function
                    {

                        break; //or loop = false;
                    }else // if function returns false
                    {
                        out.println("Invalid answer, please try again");
                        continue;
                    }
                }while(true);//validate name

            if(ans.equals("y")){
                continue;
            }//end if
            else if(ans.equals("n")){
                break;
            }//end else if
        }while(true);
    }//end edit



    private static void delete(){
            do{
                int i;
                while(true) {
                    if(arr.size() == 0){
                        out.println("There is no record. Lets get back to Menu");
                        return;
                    }//end if
                    for(int k = 0; k < arr.size(); k++){
                        out.println((k+1) + "." + arr.get(k).getName());
                    }//end for
                    out.println("What data do you want to delete? (Enter Number)");
                    while (!sc.hasNextInt()) {
                        String input = sc.next();
                        System.out.printf("\"%s\" is not a valid number.\n", input);
                        out.println("What data do you want to delete? (Enter Number)");
                    }//end while
                    i = sc.nextInt();
                    if (i > arr.size() || i < 1) {
                        out.println("Invalid Input");
                        continue;
                    }//end if
                    else {
                        out.println(arr.get(i - 1).getName() + " is deleted");
                        arr.remove(i - 1);
                        break;
                    }//end else
                }//end while
                String ans;
                do{
                    out.println("Do you want to delete more? (y/n)");
                    ans = sc.next();
                    if (asking(ans)) //CALL to validate function
                    {

                        break; //or loop = false;
                    }else // if function returns false
                    {
                        out.println("Invalid answer, please try again");
                        continue;
                    }
                }while(true);//validate name
            if(ans.equals("y")){
                if(arr.size() == 0){
                    out.println("There is no record. Lets get back to Menu");
                    return;
                }//end if
                continue;
            }//end if
            else if(ans.equals("n")){
                break;
            }//end else if
        }while(true);
    }//end delete



    private static void check(){
            do{
                int i;
                while(true) {
                    if(arr.size() == 0){
                        out.println("There is no record. Lets get back to Menu");
                        return;
                    }//end if
                    for(int k = 0; k < arr.size(); k++){
                        out.println((k+1) + "." + arr.get(k).getName());
                    }//end for
                    out.println("What data do you want to check?");
                    while (!sc.hasNextInt()) {
                        String input = sc.next();
                        System.out.printf("\"%s\" is not a valid number.\n", input);
                        out.println("What data do you want to check?");
                    }//end while
                    i = sc.nextInt();
                    if (i > arr.size() || i < 1) {
                        out.println("Invalid Input");
                        continue;
                    }//end if
                    else {
                        out.println("Name: " + arr.get(i - 1).getName());
                        out.println("Number of sold: " + arr.get(i - 1).getNum());
                        out.println("Price: " + arr.get(i - 1).getPrice());
                        break;
                    }//end else
                }//end while
                String ans;
                do{
                    out.println("Do you want to check more? (y/n)");
                    ans = sc.next();
                    if (asking(ans)) //CALL to validate function
                    {

                        break; //or loop = false;
                    }else // if function returns false
                    {
                        out.println("Invalid answer, please try again");
                        continue;
                    }
                }while(true);//validate name
            if(ans.equals("y")){
                continue;
            }//end if
            else if(ans.equals("n")){
                break;
            }//end else if
        }while(true);
    }//end check



    private static void display(){
        if(arr.size() == 0){
            out.println("There is no record. Lets get back to Menu");
            return;
        }//end if
        for(int i = 0; i < arr.size(); i++){
            for(int j = 1; j < arr.size()-i; j++){
                if((arr.get(j).getNum() * arr.get(j).getPrice()) > (arr.get(j-1).getNum() * arr.get(j-1).getPrice())){
                    String name = arr.get(j-1).getName();
                    int num = arr.get(j-1).getNum();
                    int price = arr.get(j-1).getPrice();

                    arr.get(j-1).setName(arr.get(j).getName());
                    arr.get(j-1).setNum(arr.get(j).getNum());
                    arr.get(j-1).setPrice(arr.get(j).getPrice());

                    arr.get(j).setName(name);
                    arr.get(j).setNum(num);
                    arr.get(j).setPrice(price);

                }//end if
            }//end for
        }//end for

        for(int i = 0; i < arr.size(); i++){
            out.println("-----------------------------------");
            out.println((i+1)+". "+arr.get(i).getName());
            out.println("$ "+arr.get(i).getNum() * arr.get(i).getPrice());
        }//end for
    }//end display


    public static boolean letter (String s){
        s = s.toLowerCase();
        char testChar;
        String validChars = "abcdefghijklmnopqrstuvwxyz-'  ";
        for (int i = 0; i < s.length(); i++)
        {
            testChar = s.charAt(i);
            if (validChars.indexOf(testChar) < 0)
                return false;

        }//end for
        return true;
    }//end letter

    public static boolean asking (String a){
        a = a.toLowerCase();
        char testChar;
        String validChars = "yn";
        for (int j = 0; j < a.length(); j++)
        {
            testChar = a.charAt(j);
            if (validChars.indexOf(testChar) < 0)
                return false;

        }//end for
        return true;
    }//end asking




}//end alcohol class
