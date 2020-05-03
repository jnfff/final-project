import java.util.ArrayList;
import java.util.List;

public class Team extends Organization {
    List<Member> members = new ArrayList<Member>();
    private int nums;

    public int getNums() {
        return nums;
    }

    public void setNums(int nums) {
        this.nums = nums;
    }

    public List<Member> getMembers() {
        return members;
    }

    public void setMembers(List<Member> members) {
        this.members = members;
    }
}
