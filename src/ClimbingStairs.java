import java.util.ArrayList;
import java.util.List;

public class ClimbingStairs {
    List<Integer> stepsList = new ArrayList<>(List.of(0,1,2));
    public int climbStairs(int n) {
        if(n<0){
            return 0;
        }
        if (n < stepsList.size()){
            return stepsList.get(n);
        }
        stepsList.add(climbStairs(n-1)+climbStairs(n-2));
        return stepsList.getLast();
    }

    public static void main(String[] args) {
        ClimbingStairs cs = new ClimbingStairs();
        System.out.println(cs.climbStairs(5));
    }
}
