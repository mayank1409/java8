package multipleinheritance;

/**
 * Independent interface used in diamond problem demonstration.
 * Also provides methodA (like BaseHierarchyInterface) to create method conflict.
 * Used to show how to resolve multiple inheritance ambiguity.
 */
public interface UnrelatedInterfaceForDiamondProblem {
    /**
     * Default method similar to BaseHierarchyInterface, demonstrating diamond problem.
     */
    default void methodA() {
        System.out.println("UnrelatedInterfaceForDiamondProblem.methodA()");
    }
}
