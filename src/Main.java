import java.util.List;

public class Main {
    public static void main(String[] args) {
        BigBredlam bigBredlam = new BigBredlam();
        bigBredlam.createBredlams();
        bigBredlam.getAllCapitalistsFromBredlams();
        bigBredlam.getTogether();
        bigBredlam.setTotalPayout();
        bigBredlam.setBaseSalary();

        for (int i=0; i < 10; i++) {
            bigBredlam.tick();
        }
    }
}
