import java.util.ArrayList;
import java.util.List;

public class Bredlam {
    private List<Fabrique> fabriques;
    private Products productType;
    private float productPrice;


    public Bredlam(List<Fabrique> fabriques, Products productType) {
        this.fabriques = fabriques;
        this.productType = productType;
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
