import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class App {
    public static void main(String[] args) {
        Father f1 = new Father();
        f1.setName("LeBron George");
        f1.setAge(40);

        Father f2 = new Father();
        f1.setName("Anthony Jone");
        f1.setAge(40);

        Son son1 = new Son();
        son1.setAge(10);
        son1.setName("Kevin Geroge");

        Son son2 = new Son();
        son2.setAge(10);
        son2.setName("Dwyane Geroge");

        Son son3 = new Son();
        son3.setAge(10);
        son3.setName("Harden Geroge");

        Son son4 = new Son();
        son4.setAge(10);
        son4.setName("Klay Jone");

        Son son5 = new Son();
        son5.setAge(10);
        son5.setName("Kevin Jone");

        Son son6 = new Son();
        son6.setAge(10);
        son6.setName("DeMarcus Jone");

        List<Son> sonList = new ArrayList<Son>();
        sonList.add(son1);
        sonList.add(son2);
        sonList.add(son3);

        List<Son> sonList1 = new ArrayList<Son>();
        sonList1.add(son4);
        sonList1.add(son5);
        sonList1.add(son6);

        f1.setList(sonList);
        f2.setList(sonList1);

        System.out.println("Welcome to the app for finding ");
        System.out.println(Util.findSameFirstName(f1,f2));
        Map<String,Integer>  counts = Util.findAllDistinctNamesCount(f1,f2);
        for (Map.Entry<String,Integer> entry : counts.entrySet()){
            System.out.println(entry.getKey()+"->"+entry.getValue());
        }
    }
}
