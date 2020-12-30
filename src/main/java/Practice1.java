import java.util.ArrayList;
import java.util.Arrays;


public class Practice1 {

    public static <T> void swap(T[] mas, int i, int j) {
        T t = mas[i];
        mas[i] = mas[j];
        mas[j] = t;
    }

    public static <T> ArrayList<T> arrayToList(T[] mas) {
        return new ArrayList<>(Arrays.asList(mas));
    }

    public static void main(String[] args) {

        String[] masStr = {"hello", "priv", "privet", "prived"};
        System.out.println(Arrays.toString(masStr));
        swap(masStr, 0, 3);
        System.out.println(Arrays.toString(masStr));

        Integer[] masInt = {1, 2, 3, 4};
        System.out.println(Arrays.toString(masInt));
        swap(masInt, 0, 3);
        System.out.println(Arrays.toString(masInt));

        ArrayList<String> arrayListStr = arrayToList(masStr);
        for (String s : arrayListStr) {
            System.out.println(s);
        }

        ArrayList<Integer> arrayListInt = arrayToList(masInt);
        for (Integer i : arrayListInt) {
            System.out.println(i);
        }

        Box<Apple> appleBox = new Box<>();
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        appleBox.add(new Apple());
        System.out.println(appleBox);

        Box<Orange> orangeBox = new Box<>();
        orangeBox.add(new Orange());
        orangeBox.add(new Orange());

        if (appleBox.compare(orangeBox)) {
            System.out.println("Коробка с яблоками весит больше");
        } else {
            System.out.println("Коробка с апельсинами тяжелее");
        }

        Box<Apple> newAppleBox = new Box<>();

        appleBox.peresip(newAppleBox);
        System.out.println(appleBox);
        System.out.println(newAppleBox);

    }
}
