package multipleinheritance;

/**
 * Leaf interface in multi-level hierarchy extending IntermediateHierarchyInterface.
 * Demonstrates multi-level interface inheritance (3 levels deep).
 */
public interface LeafHierarchyInterface extends IntermediateHierarchyInterface {
    /**
     * New default method unique to Interface3.
     */
    default void methodC() {
        System.out.println("Interface3.methodC()");
    }
}
