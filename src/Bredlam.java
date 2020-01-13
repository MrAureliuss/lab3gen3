import java.util.ArrayList;
import java.util.List;

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

    public void setProductPrice() {
        getAllProductCountFromFabriques();
        setProductSaleCoefficient();
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
        }
    }

    public void sellProduct(Person person) {
        // СЮДА ОШИБКУ О ТОМ, ЧТО ПРОДУКТОВ НЕТ
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


}
