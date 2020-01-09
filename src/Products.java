public enum Products {
    SUGAR("Сахар", 1000, (float) 5000),
    BREAD("Хлеб", 1000, (float) 2000),
    CHEESE("Сыр", 1000, (float) 10000),
    LEATHER("Кожа", 1000, (float) 8000),
    COAL("Уголь", 1000, (float) 1500);

    private String product;
    private int count;
    private float baseCoef;

    Products(String product, int count, float baseCoef) {
        this.product = product;
        this.count = count;
        this.baseCoef = baseCoef;
    }

    public String getProduct() {
        return product;
    }

    public int getCount() {
        return count;
    }

    public float getBaseCoef() {
        return baseCoef;
    }

    public int sellProduct(Products productType) {
        productType.count -= 1;
        return productType.count;
    }
}
