package multipleinheritance;

/**
 * Independent interface with methodA.
 * Used to demonstrate multiple inheritance conflict resolution in Client14.
 */
public interface Interface4 {
    /**
     * Default method similar to Interface1, demonstrating diamond problem.
     */
    default void methodA() {
        System.out.println("Interface4.methodA()");
    }
}
