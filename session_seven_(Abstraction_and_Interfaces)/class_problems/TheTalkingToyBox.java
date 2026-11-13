// PROBLEM 1: The Talking Toy Box (Abstract Class with Counter & Subclasses)
abstract class Toy {
    private static int counter = 1000;
    protected final String toyId;
    protected String name;

    public Toy(String name) {
        counter++;
        this.toyId = "TOY-" + counter;
        this.name = name;
    }

    public abstract String makeSound();

    public String getToyId() {
        return toyId;
    }
}

class ToyCar extends Toy {
    public ToyCar(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return name + ": Vroom vroom!";
    }
}

class ToyRobot extends Toy {
    public ToyRobot(String name) {
        super(name);
    }

    @Override
    public String makeSound() {
        return name + ": Beep boop!";
    }
}

public class TheTalkingToyBox {
    public static void main(String[] args) {
        ToyCar c = new ToyCar("Speedster");
        ToyRobot r = new ToyRobot("Bolt");
        System.out.println(c.makeSound());
        System.out.println(r.makeSound());
        System.out.println(c.getToyId());
        System.out.println(r.getToyId());
    }
}
