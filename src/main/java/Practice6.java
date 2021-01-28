
public class Practice6 {

    public int[] newMas(int[] mas) throws RuntimeException {
        int index = mas.length + 1;
        for (int i = mas.length - 1; i > 0; i--) {
            if (mas[i] == 4) {
                index = ++i;
                break;
            }
        }
        if (index == mas.length + 1) {
            throw new RuntimeException("Missing find element");
        }
        int[] resultmas = new int[mas.length - index];
        System.arraycopy(mas, index, resultmas, 0, mas.length - index);
        return resultmas;
    }

    public boolean findMas(int[] mas) {
        if (mas.length == 0) {
            return false;
        }
        boolean find1 = false;
        boolean find4 = false;
        for (int i : mas) {
            if (i != 4 && i != 1) return false;
            if (i == 1) find1 = true;
            if (i == 4) find4 = true;
        }
        return find1 && find4;
    }

}
