import java.util.*;

public class Worker extends Person {
    private float salary;

    @Override
    public void addDisappointment(int disappointment){
        if(this.disappointment >= 100){
            riot();
        } else if (this.disappointment < 0) {
            this.disappointment += 0;
        } else {
            this.disappointment += disappointment;
        }
        if (disappointment > 0){
            System.out.println("Рабочий "+super.name + " повысил уровень злобы до "+this.disappointment);

        }else{
            System.out.println("Рабочий "+super.name + " понизил уровень злобы до "+this.disappointment);
        }
        beatWhore();
    }

    public Worker(String name, float balance, int disappointment) {
        super(name, balance);
        this.disappointment = disappointment;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getName() {
        return super.name;
    }

    public static List<Worker> createWorkers(int count) {
        Random random = new Random();
        List<Worker> workers = new ArrayList<>();
        List<String> names = Arrays.asList("Жека", "Дима", "Работяга с Девяткино", "Сашенька", "Владимир Владимирович");

        for (int i=0; i<count; i++) {
            workers.add(new Worker(names.get(random.nextInt(names.size())),100 + random.nextInt(1000), 10));
        }

        return workers;
    }

    private void riot() {
        System.out.println("ШОК! РАБОТЯГА " + name + " ВЗБУНТОВАЛСЯ! А стоп... Это же мир бредламов, который похож на одну страну.. Бунт отменяется");
        this.disappointment = 0;
    }

    public void work() {
        addDisappointment(2);
        System.out.println("РАБОТЯГА " + name + " ПОШЕЛ НА ЗАВОД ДЕЛАТЬ КИРПИЧИ!");

    }

    public void beatWhore() {
        class Wife extends Person {
            Wife(String name, float balance) {
                super(name, balance);
            }

            void getDamage(Worker husband) {
                System.out.println("Баба получила пизды. В общем-то, ничего нового. Рабочий " + Worker.this.name + " любезно выдал их ей.");
            }
        }

        Wife wife = new Wife("Наташа", 1);
        wife.getDamage(this);

    }

    @Override
    public String toString() {
        return super.name;
    }

    @Override
    public boolean equals(Object o) {
        
        if (this == o) return true;
        if (!(o instanceof Worker)) return false;
        if (!super.equals(o)) return false;
        Worker worker = (Worker) o;
        return Float.compare(worker.salary, salary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), salary);
    }
}
