// SECTION 3: Constructor Chaining
class Base {
    Base() {
        System.out.println("Base no-arg constructor ran");
    }
}

class Child extends Base {
    Child() {
        // implicit super() inserted by Java
        System.out.println("Child constructor ran");
    }
}

public class ConstructorChainingDemo {
    public static void main(String[] args) {
        new Child();
    }
}
