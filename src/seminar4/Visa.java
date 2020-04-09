package seminar4;

public class Visa extends Card {
    public Visa(int money) {
        super(money);
    }


    @Override
    public void tax() {
        this.withdraw(10);
    }
}
