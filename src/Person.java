abstract public class Person implements Buyable {
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
    public void buyProduct(Fabrique fabrique, Products product) {

    }
}
