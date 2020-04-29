import java.util.*;

public class Util {

    public  static String findSameFirstName(Father f1,Father f2){
        Set<String> name = new HashSet<String>();
        for (int i = 0; i < f1.getList().size(); i++) {
            String tempname = f1.getList().get(i).getName();
            //System.out.println(tempname);
            name.add(tempname.split(" ")[0]);
        }
        for (int i = 0; i < f2.getList().size(); i++) {
            if(name.contains(f2.getList().get(i).getName().split(" ")[0])){
                return f2.getList().get(i).getName().split(" ")[0];
            }
        }
        return null;
    }

    public static Map<String,Integer> findAllDistinctNamesCount(Father f1, Father f2){
        Map<String,Integer> map = new HashMap<String,Integer>();
        for (int i = 0; i < f1.getList().size(); i++) {
            String name = f1.getList().get(i).getName().split(" ")[0];
            map.put(name,1);
        }
        for (int i = 0; i < f2.getList().size(); i++) {
            String name = f2.getList().get(i).getName().split(" ")[0];
            if(map.containsKey(name)){
                map.put(name,map.get(name)+1);
            }
        }
        return map;
    }
}
