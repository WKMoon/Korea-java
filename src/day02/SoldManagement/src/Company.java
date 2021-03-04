public class Company {
    int pcnt, ccnt;
    int pprice = 500000, cprice = 2000000;
    Company c;
    String prod;
    int price;
    int cnt;
    int total;
    public Company(Company c, String prod, int price, int cnt, int total){
        this.c = c;
        this.prod = prod;
        this.price = price;
        this.cnt = cnt;
        this.total = total;
    }
    public Company(){}
}//end company

class Seoul extends Company{

    public Seoul (){}
    public Seoul(Company c, String prod, int price, int cnt, int total){
        super(c, prod, price, cnt, total);
    }

    public String toString(){
        return "서울지사";
    }
}//end Seoul

class Kangwon extends Company{
    public Kangwon (){}
    public Kangwon(Company c, String prod, int price, int cnt, int total){super(c, prod, price, cnt, total);}

    public String toString(){
        return "강원지사";
    }
}//end Seoul

class Jeju extends Company{
    public Jeju (){}
    public Jeju(Company c, String prod, int price, int cnt, int total){super(c, prod, price, cnt, total);}

    public String toString(){
        return "제주지사";
    }
}//end Seoul

class Kyungin extends Company{
    public Kyungin (){}
    public Kyungin(Company c, String prod, int price, int cnt, int total){super(c, prod, price, cnt, total);}

    public String toString(){
        return "경인인지사";
    }
}//end Seoul