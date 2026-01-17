package multipleinheritance;

/**
 * Demonstrates linear interface hierarchy resolution.
 * Implements LeafHierarchyInterface which extends IntermediateHierarchyInterface 
 * which extends BaseHierarchyInterface.
 * 
 * Hierarchy: LeafHierarchyInterface -> IntermediateHierarchyInterface -> BaseHierarchyInterface
 * 
 * Shows:
 * - Method inheritance through multiple levels
 * - Overriding inherited methods
 * - Adding new methods at each level
 */
public class LinearInterfaceHierarchyDemo implements LeafHierarchyInterface {

    /**
     * Override methodA to provide custom implementation for this client.
     * Must override to resolve which interface version to use when ambiguity exists.
     */
    @Override
    public void methodA() {
        System.out.println("LinearInterfaceHierarchyDemo.methodA() - Custom implementation");
    }

    public static void main(String[] args) {
        LinearInterfaceHierarchyDemo demo = new LinearInterfaceHierarchyDemo();

        System.out.println("\n===== Linear Interface Hierarchy Demo =====");
        System.out.println("Demonstrates: BaseHierarchyInterface -> IntermediateHierarchyInterface -> LeafHierarchyInterface");
        System.out.println();

        // Calling all inherited methods from the hierarchy
        System.out.println("--- Method inherited from LeafHierarchyInterface (3rd level) ---");
        demo.methodC();  // From LeafHierarchyInterface

        System.out.println("\n--- Method inherited from IntermediateHierarchyInterface (2nd level) ---");
        demo.methodB();  // From IntermediateHierarchyInterface

        System.out.println("\n--- Method overridden by LinearInterfaceHierarchyDemo ---");
        demo.methodA();  // Overridden in this class

        System.out.println("\n--- Using interface reference ---");
        LeafHierarchyInterface leafRef = demo;
        System.out.println("Calling through LeafHierarchyInterface reference:");
        leafRef.methodA();
        leafRef.methodB();
        leafRef.methodC();

        System.out.println("\n--- Using intermediate interface reference ---");
        IntermediateHierarchyInterface intermediateRef = demo;
        System.out.println("Calling through IntermediateHierarchyInterface reference:");
        intermediateRef.methodA();
        intermediateRef.methodB();

        System.out.println("\n--- Using base interface reference ---");
        BaseHierarchyInterface baseRef = demo;
        System.out.println("Calling through BaseHierarchyInterface reference:");
        baseRef.methodA();

        System.out.println("\n===== Key Points =====");
        System.out.println("1. methodA() from IntermediateHierarchyInterface overrides BaseHierarchyInterface.methodA()");
        System.out.println("2. LinearInterfaceHierarchyDemo.methodA() overrides IntermediateHierarchyInterface.methodA()");
        System.out.println("3. methodB() and methodC() are unique to their interfaces");
        System.out.println("4. All methods are accessible through the implementation");
    }
}
