package lab1;

public class Apple extends Food {
    public Apple() {
        super("Apple", 50);
    }

    @Override
    public void consume() {
        System.out.println(get_name() + " with worms! Damn!");

        @Override
        public int calculateCalories() {
            return get_calories();
        }

        @Override
        public String toString() {
            return super.toString();
        }
    }
}
