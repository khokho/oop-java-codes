public class Mastercard extends Card {
    public Mastercard(int money) {
        super(money);
    }

    @Override
    public void tax() {
        this.withdraw(5);
    }
}
