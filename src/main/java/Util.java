import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.nio.Buffer;
import java.util.*;

public class Util {

    public static final Map<String,Integer> name_repeat_rate_year = new HashMap<String, Integer>();
    public static final Map<String,Integer> name_repeat_rate_count = new HashMap<String, Integer>();

    public static void loadData() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(System.getProperty("user.dir")+"/src/main/java/names.txt"));
        String line = "";
        while((line=reader.readLine())!=null){
            String data[] = line.split(" ");
            String username = data[0];
            Integer max = Integer.MIN_VALUE;
            for (int i = 1; i < data.length; i++) {
                if(Integer.parseInt(data[i])>max){
                    max = Integer.parseInt(data[i]);
                    name_repeat_rate_year.put(username,1900+(i-1)*10);
                    name_repeat_rate_count.put(username,max);
                }
            }
        }
    }

    public static Map<String,Integer> findNameCount(Team f1) {
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (int i = 0; i < f1.getMembers().size(); i++) {
            String name = f1.getMembers().get(i).getName();
            if(map.containsKey(name)){
                map.put(name,map.get(name)+1);
            }else {
                map.put(name,1);
            }
        }
        return map;
    }

    public static void execute(Team f1,Team f2) throws IOException {
        loadData();
        Set<String> name = new HashSet<String>();
        List<String> repeatNames = new ArrayList<String>();
        for (int i = 0; i < f1.getMembers().size(); i++) {
            String tempname = f1.getMembers().get(i).getName();
            name.add(tempname);
        }
        for (int i = 0; i < f2.getMembers().size(); i++) {
            if(name.contains(f2.getMembers().get(i).getName())&&!repeatNames.contains(f2.getMembers().get(i).getName())){
                repeatNames.add(f2.getMembers().get(i).getName());
            }
        }

        Map<String,Integer> namecount1 = findNameCount(f1);
        Map<String,Integer> namecount2 = findNameCount(f2);

        int max = 0;
        for (int i = 0; i < repeatNames.size(); i++) {
           int count = namecount1.get(repeatNames.get(i))+namecount2.get(repeatNames.get(i));
            max = Math.max(count,max);
        }

        List<String> names = new ArrayList<String>();
        System.out.println("Repetition times of the most popular name(s):"+max+"，the name：");
        for (int i = 0; i < repeatNames.size(); i++) {
            int count = namecount1.get(repeatNames.get(i))+namecount2.get(repeatNames.get(i));
            if(count==max){
                System.out.println(repeatNames.get(i));
                names.add(repeatNames.get(i));
            }
        }

        System.out.println("Repetition times："+max);

        List<Member> members2 = f1.getMembers();
        members2.addAll(f2.getMembers());

        System.out.println("======================================");
        Map<String,Integer> namecount3 = new HashMap<String, Integer>();
        for (int i = 0; i < members2.size(); i++) {
            if(namecount3.containsKey(members2.get(i).getName())){
                namecount3.put(members2.get(i).getName(),namecount3.get(members2.get(i).getName())+1);
            }else{
                namecount3.put(members2.get(i).getName(),1);
            }
        }
        max = 0;
        for (Map.Entry<String,Integer> entry: namecount3.entrySet()) {
            max = Math.max(max,entry.getValue());
        }
        System.out.println("Repetition times of the most popular name(s) (Ignore whether the name appears in both of team):"+max+"，the name：");
        for (Map.Entry<String,Integer> entry: namecount3.entrySet()) {
            if(entry.getValue()==max){
                System.out.println(entry.getKey()+","+"the year that the most popular name appeears the most："+name_repeat_rate_year.get(entry.getKey())+","+"repetition times："+name_repeat_rate_count.get(entry.getKey()));
            }
        }
    }

    public static void main(String[] args) throws IOException {
        loadData();
    }




}
