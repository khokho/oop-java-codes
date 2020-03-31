public class Amex extends Card {
    public Amex(int money) {
        super(money);
    }

    @Override
    public void tax() {
        this.withdraw(0);
    }
}
