public class DeliveryClass implements Interface{
    int timeFee;
    int amountFee;
    int totalFee;
    String area;
    int time;
    int amount;
    String name;



    @Override
    public int timeFee() {
        if(time<1)
            return timeFee = 1000;
        else if(time>=1 && 2>time)
            return timeFee = 2000;
        else if(time>=2 && 3>time)
            return timeFee = 3000;
        else if(3 <= time)
            return timeFee = 4000;
        return timeFee;
    }

    @Override
    public int amountFee() {
        if(amount <= 100)
            return amountFee = 1000;
        else if(amount > 100 && amount <= 200)
            return amountFee = 2000;
        else if(amount > 200 && amount <= 300)
            return amountFee = 3000;
        else if(300 < amount)
            return amountFee = 4000;
        return amountFee;
    }

    @Override
    public int deliveryFee() {
        return totalFee = timeFee() + amountFee();
    }

    DeliveryClass(String name, String area, int time, int amount){
        this.name = name;
        this.area = area;
        this.time = time;
        this.amount = amount;

    }

}
