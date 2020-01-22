import java.util.Objects;

abstract public class Person implements Buyable, Payable {
    protected String name;
    protected float balance;
    protected int disappointment;


    public void addDisappointment(int disappointment){
        if(this.disappointment >= 100){
            this.disappointment += 100;
        } else if (this.disappointment < 0) {
            this.disappointment += 0;
        } else {
            this.disappointment += disappointment;
        }
        if (disappointment > 0){
            System.out.println("Человек "+ name + " повысил уровень злобы до "+this.disappointment);

        }else{
            System.out.println("Человек "+ name + " понизил уровень злобы до "+this.disappointment);
        }
    }
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Person)) return false;
        Person person = (Person) o;
        return Float.compare(person.balance, balance) == 0 &&
                disappointment == person.disappointment &&
                Objects.equals(name, person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, balance, disappointment);
    }
}
