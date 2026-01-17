package multipleinheritance;

/**
 * Base interface in the hierarchy demonstrating default methods.
 * Provides methodA with default implementation.
 * Serves as foundation for other interfaces that extend it.
 */
public interface BaseHierarchyInterface {
    /**
     * Default method: provides implementation that can be inherited or overridden.
     */
    default void methodA() {
        System.out.println("BaseHierarchyInterface.methodA()");
    }
}
