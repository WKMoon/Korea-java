import java.util.Scanner;

public class Manager {
    Scanner sc = new Scanner(System.in);
    Company[] comArr = new Company[10];
    static int i = 0;
    void buy(){
        while(true) {

            System.out.println("지사는? 1 서울지사 2.경인지사 3.강원지사 4.제주지사");
            System.out.println("선택?");

            int location = sc.nextInt();

            System.out.println("제품은?");
            String prod = sc.next();
            if (location == 1) {
                if (prod.equals("컴퓨터")) {
                    Company c = new Seoul();
                    System.out.println(c + "의 컴퓨터 판매량은?");
                    c.ccnt = sc.nextInt();
                    int price = c.ccnt * c.cprice;
                    Company company = new Seoul(c, "컴퓨터", c.cprice, c.ccnt, price);
                    comArr[i++] = company;
                }//end if
                else if (prod.equals("프린터")) {
                    Company c = new Seoul();
                    System.out.println(c + "의 프린터 판매량은?");
                    c.pcnt = sc.nextInt();
                    int price = c.pcnt * c.pprice;
                    Company company = new Seoul(c, "프린터", c.pprice, c.pcnt, price);
                    comArr[i++] = company;
                }//end else if
            }//end if
            else if (location == 2) {
                if (prod.equals("컴퓨터")) {
                    Company c = new Kyungin();
                    System.out.println(c + "의 컴퓨터 판매량은?");
                    c.ccnt = sc.nextInt();
                    int price = c.ccnt * c.cprice;
                    Company company = new Kyungin(c, "컴퓨터", c.cprice, c.ccnt, price);
                    comArr[i++] = company;
                }//end if
                else if (prod.equals("프린터")) {
                    Company c = new Kyungin();
                    System.out.println(c + "의 프린터 판매량은?");
                    c.pcnt = sc.nextInt();
                    int price = c.pcnt * c.pprice;
                    Company company = new Kyungin(c, "프린터", c.pprice, c.pcnt, price);
                    comArr[i++] = company;
                }//end else if
            }//end if
            else if (location == 3) {
                if (prod.equals("컴퓨터")) {
                    Company c = new Kangwon();
                    System.out.println(c + "의 컴퓨터 판매량은?");
                    c.ccnt = sc.nextInt();
                    int price = c.ccnt * c.cprice;
                    Company company = new Kangwon(c, "컴퓨터", c.cprice, c.ccnt, price);
                    comArr[i++] = company;
                }//end if
                else if (prod.equals("프린터")) {
                    Company c = new Kangwon();
                    System.out.println(c + "의 프린터 판매량은?");
                    c.pcnt = sc.nextInt();
                    int price = c.pcnt * c.pprice;
                    Company company = new Kangwon(c, "프린터", c.pprice, c.pcnt, price);
                    comArr[i++] = company;
                }//end else if
            }//end if
            else if (location == 4) {
                if (prod.equals("컴퓨터")) {
                    Company c = new Jeju();
                    System.out.println(c + "의 컴퓨터 판매량은?");
                    c.ccnt = sc.nextInt();
                    int price = c.ccnt * c.cprice;
                    Company company = new Jeju(c, "컴퓨터", c.cprice, c.ccnt, price);
                    comArr[i++] = company;
                }//end if
                else if (prod.equals("프린터")) {
                    Company c = new Jeju();
                    System.out.println(c + "의 프린터 판매량은?");
                    c.pcnt = sc.nextInt();
                    int price = c.pcnt * c.pprice;
                    Company company = new Jeju(c, "프린터", c.pprice, c.pcnt, price);
                    comArr[i++] = company;
                }//end else if
            }//end if
            System.out.println("계속 입력하시겠습니까?");
            String ans = sc.next();
            if(ans.equals("n")){
                break;
            }//end if
        }//end while
    }//end buy


    String output(Company[] comArr){
        System.out.println("---------------------------");
        System.out.println("각 지사별 판매현황");
        System.out.println("---------------------------");
        System.out.println("지사명 제품명 제품가격 판매량 매출현황");
        System.out.println("---------------------------");

        String result = "";
        for(int j = 0; j < comArr.length; j++){
            if(comArr[j] == null){break;}
            result += comArr[j] + " " + comArr[j].prod + " " + comArr[j].price + " " + comArr[j].cnt + " " + comArr[j].total + "\n";
        }//end for
        return result;
    }//end output

}//end manager
