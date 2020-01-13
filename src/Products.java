public enum Products {
    SUGAR("Сахар"),
    BREAD("Хлеб"),
    CHEESE("Сыр"),
    LEATHER("Кожа"),
    COAL("Уголь");

    private String product;

    Products(String product) {
        this.product = product;
    }

    public String getProduct() {
        return product;
    }

}
