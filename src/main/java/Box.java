import java.util.ArrayList;

class Box<T extends Fruit> {
    private final ArrayList<T> spisokBox;

    public Box() {
        this.spisokBox = new ArrayList<>();
    }

    public void add(T fruit) {
        spisokBox.add(fruit);
    }

    public void removeFruit() {
        if (!spisokBox.isEmpty()) {
            spisokBox.remove(spisokBox.size() - 1);
        }
    }

    public float getWeight() {
        if (!spisokBox.isEmpty())
            return spisokBox.size() * spisokBox.get(0).getWeight();
        else
            return 0.0f;
    }

    public boolean compare(Box<?> box) {
        return (Math.abs(this.getWeight() - box.getWeight()) > 0.001);
    }

    public void peresip(Box<T> box) {
        while (!spisokBox.isEmpty()) {
            box.add(spisokBox.get(spisokBox.size() - 1));
            removeFruit();
        }
    }

    @Override
    public String toString() {
        return "Box содержит " + (spisokBox.size()) + " фруктов, весом " + getWeight() + " единиц";
    }
}
