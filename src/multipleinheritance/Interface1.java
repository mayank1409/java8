package multipleinheritance;

/**
 * Base interface demonstrating default method.
 * Can be extended by other interfaces to create inheritance hierarchy.
 */
public interface Interface1 {
    /**
     * Default method: provides implementation that can be inherited or overridden.
     */
    default void methodA() {
        System.out.println("Interface1.methodA()");
    }
}
