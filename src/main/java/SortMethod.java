import java.util.Comparator;

public class SortMethod implements Comparator<MethodClass> {
    @Override
    public int compare(MethodClass o1, MethodClass o2) {
        return o1.p - o2.p;
    }
}
