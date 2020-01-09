import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BigBredlam {
    String name;
    final String owner = "Спрутс";
    List<Bredlam> bredlams;
    private boolean united = false;
    private float totalPayout;
    private float baseSalary;

    public BigBredlam(String name) {
        this.name = name;
    }

    public float getBaseSalary() {
        return baseSalary;
    }

    public void createBredlams() {
        List<Bredlam> bredlams = new ArrayList<>();
        for (Products products: Products.values()) {
            bredlams.add(Bredlam.createBredlam(products));
        }

        this.bredlams = bredlams;
    }  // Создание листа всех бредламов.

    public List<Capitalist> getAllCapitalistsFromBredlams() {
        List<Capitalist> capitalists = new ArrayList<>();
        for (Bredlam bredlam:this.bredlams) {
            for (Fabrique fabrique: bredlam.getFabriquesFromBredlam()) {
                capitalists.add(fabrique.getOwner());
            }
        }

        return capitalists;
    }

    public void getTogether() {
        this.united = true;
        System.out.println("Сбор всех капиталистов! Пришло время отжимать у работяг последний кусок хлеба!");
        getAllCapitalistsFromBredlams().forEach(x -> System.out.println("На встречу прибыл " + x.getName()));
    }

    public void setTotalPayout() {
        if (united) {
            Random random = new Random();
            for(Capitalist capitalist:getAllCapitalistsFromBredlams()) {
                // Скидываемся в общак для общей зарплаты
                float payoutRatio = (float) (0.02 + random.nextFloat() * (0.15 - 0.02));
                float payoutAmount = capitalist.balance * payoutRatio;
                capitalist.charge(payoutAmount);
                System.out.println(capitalist.getName()+" скинулся в общак " + payoutAmount + " тугриков");
                totalPayout += payoutAmount;
            }
            System.out.println("Общим решением, капиталисты вынули из своих подлых кармашек и скинули в общак " + this.totalPayout + " тугриков");
        } else {
            System.out.println("Беды с башкой? Капиталисты еще не собрались!");
        }
    }

    public void setBaseSalary() {
        int workersCount = 0;
        List<Worker> workers = new ArrayList<>();
        if (united) {
            for (Bredlam bredlam:this.bredlams) {
                for (Fabrique fabrique: bredlam.getFabriquesFromBredlam()) {
                    workersCount += fabrique.getWorkersFromFabrique().size();
                }
            }

            baseSalary = totalPayout / workersCount;

            for (Bredlam bredlam:this.bredlams) {
                for (Fabrique fabrique: bredlam.getFabriquesFromBredlam()) {
                    fabrique.getWorkersFromFabrique().forEach(x -> x.setSalary(baseSalary));
                }
            }

            System.out.println("Каждому работяге установлена зарплата в размере " + baseSalary + " тугриков");

        } else {
            System.out.println("Сбора капиталистов еще не было, зарплату установить невозможно.");
        }
    }

    public void paySalary() {
        for (Bredlam bredlam:this.bredlams) {
            bredlam.getFabriquesFromBredlam().forEach(x -> x.payWorkerSalary(baseSalary));
        }
    }
}
