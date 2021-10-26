package lab1;

public class Apple extends Food {
    private String _size = null;
    public Apple(String size) {
        super("Apple", 50);
        _size = size;
    }

    public String get_size() {
        return _size;
    }
    private void set_size(String size) {
        _size = size;
    }
    @Override
    public void consume() {
        System.out.println(get_name() + " with worms! Damn!");
    }
    @Override
    public int calculateCalories() {
        return get_calories();
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
