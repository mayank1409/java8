package multipleinheritance;

/**
 * Intermediate interface in the hierarchy extending BaseHierarchyInterface.
 * Demonstrates overriding inherited default methods and adding new ones.
 */
public interface IntermediateHierarchyInterface extends BaseHierarchyInterface {
    /**
     * New default method unique to IntermediateHierarchyInterface.
     */
    default void methodB() {
        System.out.println("IntermediateHierarchyInterface.methodB()");
    }

    /**
     * Override methodA from BaseHierarchyInterface with different implementation.
     */
    @Override
    default void methodA() {
        System.out.println("IntermediateHierarchyInterface.methodA() - overridden");
    }
}
