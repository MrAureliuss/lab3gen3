public interface Payable {
    void income(float amount);

    void charge(float amount);

    void buyProduct(Fabrique fabrique, Products product);
}
