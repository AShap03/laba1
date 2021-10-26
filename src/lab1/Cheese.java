package lab1;

public class Cheese extends Food{
    public Cheese() {
        super("Cheese", 400);
    }
    //public Cheese это конструктор без параметров а вызывая super у нас вызыввается конструктор класса родителя, так мы определяем переменные класса родителя


    @Override
    public void consume() {
        System.out.println(get_name() + " eaten. Yummy!");
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
