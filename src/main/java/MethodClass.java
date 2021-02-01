import java.lang.reflect.Method;
import java.util.Objects;

public class MethodClass {
    public Method m;
    public int p;

    public MethodClass(Method m, int p) {
        this.m = m;
        this.p = p;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MethodClass that = (MethodClass) o;
        return p == that.p && Objects.equals(m, that.m);
    }

    @Override
    public int hashCode() {
        return Objects.hash(m, p);
    }
}
