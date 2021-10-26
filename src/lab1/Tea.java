package lab1;

public class Tea extends Food {
    private String _filling1 = null;

    public Tea(String filling1) {
        super("Tea", 1);
        _filling1 = filling1;
    }


    public String get_filling1() {
        return _filling1;
    }
    private void set_filling1(String filling1) { _filling1 = filling1; }

    @Override
    public void consume() {
        System.out.println(get_name() + " drinked!");
    }

    @Override
    public int calculateCalories() {
        if (get_filling1().equals("Green"))
            set_calories(get_calories() + 2);
        else if (get_filling1().equals("Black"))
            set_calories(get_calories() + 4);

        return get_calories();
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        if (!(obj instanceof Tea)) return false;
        return (_filling1.equals(((Tea) obj)._filling1));
    }

    @Override
    public String toString(){
        return super.toString() + " with " + get_filling1();
    }
}
