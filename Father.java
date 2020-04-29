import java.util.ArrayList;
import java.util.List;

public class Father extends People{
    List<Son> list = new ArrayList<Son>();

    public void drive(String carType){
        System.out.println("drive "+carType);
    }

    public List<Son> getList() {
        return list;
    }

    public void setList(List<Son> list) {
        this.list = list;
    }
}
