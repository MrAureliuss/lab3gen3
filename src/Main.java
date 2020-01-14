import java.util.List;

public class Main {
    public static void main(String[] args) {

        BigBredlam bigBredlam = new BigBredlam();
        bigBredlam.createBredlams();
        bigBredlam.getAllCapitalistsFromBredlams();
        bigBredlam.getTogether();
        bigBredlam.setTotalPayout();
        bigBredlam.setBaseSalary();

        for (int i=0; i < 1; i++) {
            bigBredlam.tick(); // Тик обозначает 1 день работы дятлов этих
        }
        BigBredlam.Secretary secretary = bigBredlam.new Secretary("Василиса Пышка", (float) 14.88);
        secretary.notifyCapitalists();
        bigBredlam.tick();
        bigBredlam.getTogether(); // Опять
        GiantTree giantTree = new GiantTree((float) 5, (float) 2, (float) 20);
        BigBredlam.Sproots sproots = bigBredlam.new Sproots((float) 228228);
        sproots.giveSpeech("Нам угрожают "+giantTree.getName()+", так что давайте что-нибудь с§делаем, ежи бля");
        bigBredlam.getAllCapitalistsWonder(); 
        sproots.giveSpeech("Нужно убить "+giantTree.getName()+", пока эта ебота не разрослась как девятиэташка");
        Dubotolk dube = new Dubotolk("Господин Дубе", 15002);
        dube.giveSpeech("У меня есть очень способные и талантливые люди, которы могут убрать Незнайку, Мигу, Жулию");
    }
}
