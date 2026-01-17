package multipleinheritance;

/**
 * Interface extending Interface2 (which extends Interface1).
 * Demonstrates multi-level interface inheritance.
 */
public interface Interface3 extends Interface2 {
    /**
     * New default method unique to Interface3.
     */
    default void methodC() {
        System.out.println("Interface3.methodC()");
    }
}
