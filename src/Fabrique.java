import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Fabrique {
    private Capitalist owner;
    private List<Worker> workers;
    private Products productType;
    private int productCount = 500;

    public Fabrique(Products productType, Capitalist owner, List<Worker> workers) {
        this.productType = productType;
        this.owner = owner;
        this.workers = workers;
    }

    public Capitalist getOwner() {
        return this.owner;
    }

    public List<Worker> getWorkersFromFabrique() {
        return this.workers;
    }

    public Products getProductType() {
        return this.productType;
    }

    public static List<Fabrique> createFabriques(int count, Products productType) {
        List<Fabrique> fabriques = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            Fabrique fabrique = new Fabrique(productType, Capitalist.createCapitalist(), Worker.createWorkers(5));
            System.out.println("Создана фабрика с продуктами "+ productType.getProduct() + ", рабочими " + fabrique.getWorkersFromFabrique() + " и хозяином " + fabrique.getOwner().getName());
            fabriques.add(fabrique);
        }
        return fabriques;
    }

    public void payWorkerSalary(float baseSalary) {
        workers.forEach(x -> x.income(baseSalary));
    }

    public int getProductCount() {
        return this.productCount;
    }

    public void makeProduct() {
        productCount += 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fabrique)) return false;
        Fabrique fabrique = (Fabrique) o;
        return productCount == fabrique.productCount &&
                Objects.equals(owner, fabrique.owner) &&
                Objects.equals(workers, fabrique.workers) &&
                productType == fabrique.productType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner, workers, productType, productCount);
    }
}
