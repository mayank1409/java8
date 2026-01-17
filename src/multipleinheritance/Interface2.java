package multipleinheritance;

/**
 * Interface extending Interface1.
 * Demonstrates overriding inherited default methods and adding new ones.
 */
public interface Interface2 extends Interface1 {
    /**
     * New default method unique to Interface2.
     */
    default void methodB() {
        System.out.println("Interface2.methodB()");
    }

    /**
     * Override methodA from Interface1 with different implementation.
     */
    @Override
    default void methodA() {
        System.out.println("Interface2.methodA() - overridden");
    }
}
