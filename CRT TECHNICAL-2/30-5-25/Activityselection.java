import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
class Greedy {
    int start,end;
    Greedy(int start,int end){
        this.start=start;
        this.end=end;
    }
}
class Activityselection{
    public static void selectActivities(List<Greedy> Activities){
        Activities.sort(Comparator.comparingInt(a->a.end));
        int lastend=0;
        for(Greedy act:Activities){
            if(act.start>=lastend){
                System.out.println("Selected :("+act.start+","+act.end+")");
                lastend=act.end;
            }
        }
    }
    public static void main(String[] args) {
        List<Greedy> activities=Arrays.asList(
            new Greedy(1, 4),
            new Greedy(3, 5),
            new Greedy(0, 6),
            new Greedy(5, 7),
            new Greedy(8, 9),
            new Greedy(5, 9)
        );
        selectActivities(activities);
    }
}
