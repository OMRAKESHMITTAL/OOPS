// Base class A
class A {
    public int x = 10;       // Public: accessible everywhere
    protected int y = 20;    // Protected: accessible in the same package and subclasses
    private int z = 30;      // Private: only accessible within class A

    public void display() {
        System.out.println("x = " + x);
        System.out.println("y = " + y);
        System.out.println("z = " + z);  // Can be accessed here within class A
    }
}

// Class B inherits A (using public inheritance)
class B extends A {
    public void show() {
        System.out.println("x = " + x);  // Public, so accessible
        System.out.println("y = " + y);  // Protected, so accessible within subclass
        // System.out.println("z = " + z);  // Error: z is private in A, so not accessible
    }
}

// Class C inherits A (using protected inheritance)
class C extends A {
    // In Java, there's no such thing as protected inheritance,
    // but we can still access protected members in a subclass.
    public void show() {
        System.out.println("x = " + x);  // Public is accessible
        System.out.println("y = " + y);  // Protected is accessible in subclass
        // System.out.println("z = " + z);  // Error: z is private in A
    }
}

// Class D inherits A (using private inheritance)
class D extends A {
    // In Java, private inheritance is not allowed,
    // but by default, subclass D can access public and protected members.
    public void show() {
        System.out.println("x = " + x);  // Public is accessible
        System.out.println("y = " + y);  // Protected is accessible in subclass
        // System.out.println("z = " + z);  // Error: z is private in A
    }
}

public class AccessSpecifiers {
    public static void main(String[] args) {
        A objA = new A();
        objA.display();  // Output: x = 10, y = 20, z = 30 (z is accessible inside class A)

        B objB = new B();
        objB.show();     // Output: x = 10, y = 20 (z not accessible)

        C objC = new C();
        objC.show();     // Output: x = 10, y = 20 (z not accessible)

        D objD = new D();
        objD.show();     // Output: x = 10, y = 20 (z not accessible)
    }
}
