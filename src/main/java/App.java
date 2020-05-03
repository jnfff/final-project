import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws IOException {
        System.out.println("What is the name of first team?");
        Scanner sc = new Scanner(System.in);
        String name1 = sc.next();
        System.out.println("How many team members in this team?");
        String count1 = sc.next();
        System.out.println("What are the names of these team members?(Use comma to split)");
        String members = sc.next();
        System.out.println("What is the name of second team?");
        String name2 = sc.next();
        System.out.println("How many team members in this team?");
        String count2 = sc.next();
        System.out.println("What are the names of these team members?(Use comma to split");
        String members2 = sc.next();

        String[] memberNames = members.split(",");
        List<Member> list = new ArrayList<Member>();
        for (int i = 0; i < memberNames.length; i++) {
            Member member = new Member();
            member.setName(memberNames[i]);
            list.add(member);
        }
        Team team1 = new Team();
        team1.setMembers(list);
        team1.setName(name1);
        team1.setNums(Integer.parseInt(count1));

        String[] memberNames2 = members2.split(",");
        List<Member> list2 = new ArrayList<Member>();
        for (int i = 0; i < memberNames2.length; i++) {
            Member member = new Member();
            member.setName(memberNames2[i]);
            list2.add(member);
        }
        Team team2 = new Team();
        team2.setMembers(list2);
        team2.setName(name2);
        team2.setNums(Integer.parseInt(count2));
        Util.execute(team1,team2);
    }
}
