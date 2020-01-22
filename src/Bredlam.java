import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Bredlam {
    private List<Fabrique> fabriques;
    private Products productType;
    private float productPrice;
    private int productCount;
    private int productSaleCoefficient;

    public Bredlam(List<Fabrique> fabriques, Products productType) {
        this.fabriques = fabriques;
        this.productType = productType;
        setProductPrice();
    }

    private void getAllProductCountFromFabriques() {  // Получаем количество продуктов с нашей фабрики.
        fabriques.forEach(fabrique -> productCount += fabrique.getProductCount()); // берем количество продуктов с наших фабрик.
    }

    public void setProductPrice() throws ArithmeticException {

        getAllProductCountFromFabriques();
        setProductSaleCoefficient();
        if(productCount <= 0){
            throw new ArithmeticException("Недостаточно продуктов, чтобы посчитать цену");
        }
        productPrice = productSaleCoefficient / productCount;
    }

    public void setProductSaleCoefficient() {
        switch (productType) {
            case COAL:
                productSaleCoefficient = 1500;
                break;
            case BREAD:
                productSaleCoefficient = 2000;
                break;
            case SUGAR:
                productSaleCoefficient = 5000;
                break;
            case CHEESE:
                productSaleCoefficient = 10000;
                break;
            case LEATHER:
                productSaleCoefficient = 8000;
                break;
            case WOOD:
                productSaleCoefficient = 1000;
                break;
        }
    }

    public void sellProduct(Person person) throws NoProductException {
        // СЮДА ОШИБКУ О ТОМ, ЧТО ПРОДУКТОВ НЕТ
        if(productCount < 0){
            throw new NoProductException("Нет продуктов");
        }
        person.charge(productPrice); // Снимаем человеку деньги со счета.
        fabriques.forEach(fabrique -> {fabrique.getOwner().income(productPrice / 4);  // Отдаем капиталисту четвертую часть от прибыли.
            System.out.println("Работяга " + person.getName() +" раскошелился на " + productType.name() + ", капиталист " + fabrique.getOwner().getName() +
                    " заработал " + productPrice / 4 + " тугриков. Теперь, его капитал составляет " +  fabrique.getOwner().getBalance());});
        fabriques.forEach(Fabrique::makeProduct); // Генерим новые продукты.
        getAllProductCountFromFabriques(); // Сообщаем бредламу о новых продуктах на фабрике и забираем их.
    }


    public List<Fabrique> getFabriquesFromBredlam() {
        return this.fabriques;
    }

    public Products getProductType() {
        return this.productType;
    }

    public static Bredlam createBredlam(Products productType) {
        return new Bredlam(Fabrique.createFabriques(2, productType), productType);
    }  // Создание одиночного Бредлама по типу продукта.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Bredlam)) return false;
        Bredlam bredlam = (Bredlam) o;
        return Float.compare(bredlam.productPrice, productPrice) == 0 &&
                productCount == bredlam.productCount &&
                productSaleCoefficient == bredlam.productSaleCoefficient &&
                Objects.equals(fabriques, bredlam.fabriques) &&
                productType == bredlam.productType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(fabriques, productType, productPrice, productCount, productSaleCoefficient);
    }
}
