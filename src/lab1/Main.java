package lab1;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {

    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Do u want to sort? (y/n) ");
        String sorted = scanner.nextLine();

        System.out.print("Do u want to calculate calories? (y/n) ");
        String calories = scanner.nextLine();

        ArrayList<Food> breakfast = new ArrayList<Food>();
        FillArrayList(breakfast);
        PrintArrayList(breakfast);

        if (sorted.equals("y")) {
            SortArrayList(breakfast);
            System.out.println("Sorted breakfast");
            PrintArrayList(breakfast);
        }

        Consume(breakfast);

        if (calories.equals("y"))
            System.out.println("U ate " + CalculateCalories(breakfast) + " calories");
    }

    private static void Consume(ArrayList<Food> breakfast) {
        if (breakfast == null)
            return;
        for (Food el:breakfast)
            el.consume();
    }

    public static void FillArrayList(ArrayList<Food> breakfast) throws Exception{
        String answer;
        do {
            System.out.print("Enter food: ");
            String food = scanner.nextLine();

            if (food.equals("Apple"))
                breakfast.add(new Apple());
            else if (food.equals("Cheese"))
                breakfast.add(new Cheese());
            else if (food.equals("Tea")){
                System.out.println("Enter first filling of tea: ");
                String filling1 = scanner.nextLine();
                if (filling1.equals("Green") || filling1.equals("Black")){
                    breakfast.add(new Tea(filling1));
                }

            }

            System.out.print("Do u want more? (y/n) ");
            answer = scanner.nextLine();
        } while(answer.equals("y"));
    }

    public static void PrintArrayList(final ArrayList<Food> breakfast) {
        if (breakfast == null)
            System.out.println("U are fat, u are not allowed to eat!");
        System.out.println("U want to ate today: ");
        for (Food item : breakfast) {
            Class MyClass = item.getClass();
            System.out.println(MyClass.getSimpleName());

            Field[] fields = MyClass.getDeclaredFields();
            for (Field it : fields){
                System.out.println(it);
            }
            //System.out.print(item.toString() + ", ");
        }
        System.out.println();
    }

    public static void SortArrayList(ArrayList<Food> breakfast){
        Collections.sort(breakfast, new Comparator<Food>() {
            @Override
            public int compare(Food o1, Food o2) {
                return o1.get_name().length() < o2.get_name().length() ? -1 :
                        o1.get_name().length() > o2.get_name().length() ? 1 : 0;
            }
        });
    }

    public static int CalculateCalories(ArrayList<Food> breakfast){
        if (breakfast == null)
            return 0;
        int calories = 0;
        for (Food el : breakfast)
            calories += el.calculateCalories();
        return calories;
    }
}
