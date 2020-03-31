public abstract class Card {
    private int money;
    private int transactions;

    public Card(int money){
        this.money = money;
        transactions = 0;
    }

    public void withdraw(int amount){
        if(money < amount){
            System.out.println("insuficcent");
            return;
        }
        else
            money -= amount;
        transactions ++;
    }
    public void deposit(int amount){
        money += amount;
        transactions ++;
    }

    public int getMoney(){
        return money;
    }

    abstract public void tax();

    public void endMonth(){
        tax();
        System.out.println("month ended\n transactions: " + transactions + " money: " + money + " class: " + this.getClass().getName());
        transactions = 0;
    }

}
