abstract public class Person implements Buyable, Payable {
    protected String name;
    protected float balance;

    Person(String name, float balance) {
        this.name = name;
        this.balance = balance;
    }

    protected String getName() {
        return this.name;
    }

    protected float getBalance() {
        return this.balance;
    }

    @Override
    public void buyProduct(Bredlam bredlam, Products product) {

    }

    @Override
    public void income(float amount) {
        this.balance += amount;
    }

    @Override
    public void charge(float amount) {
        this.balance -= amount;
    }
}
