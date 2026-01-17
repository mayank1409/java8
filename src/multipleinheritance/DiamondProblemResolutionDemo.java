package multipleinheritance;

/**
 * Demonstrates diamond problem resolution with multiple interface inheritance.
 * Implements BaseHierarchyInterface and UnrelatedInterfaceForDiamondProblem.
 * 
 * Both interfaces define methodA(), creating an ambiguous situation (diamond problem).
 * Java 8 requires explicit override to resolve the conflict.
 * 
 * Shows:
 * - Multiple inheritance from unrelated interfaces
 * - Handling method name conflicts
 * - Resolution strategies using super references
 */
public class DiamondProblemResolutionDemo implements BaseHierarchyInterface, UnrelatedInterfaceForDiamondProblem {

    /**
     * Override methodA to resolve ambiguity from both interfaces.
     * Must explicitly choose which interface's version to use.
     */
    @Override
    public void methodA() {
        System.out.println("DiamondProblemResolutionDemo.methodA() - Resolved custom implementation");
    }

    /**
     * Demonstrates calling a specific interface's default method using super.
     * This shows explicit resolution of ambiguous methods.
     */
    public void callBaseMethodA() {
        BaseHierarchyInterface.super.methodA();
    }

    /**
     * Demonstrates calling the other interface's default method using super.
     */
    public void callUnrelatedMethodA() {
        UnrelatedInterfaceForDiamondProblem.super.methodA();
    }

    public static void main(String[] args) {
        DiamondProblemResolutionDemo demo = new DiamondProblemResolutionDemo();

        System.out.println("\n===== Diamond Problem Resolution Demo =====");
        System.out.println("Implements: BaseHierarchyInterface AND UnrelatedInterfaceForDiamondProblem");
        System.out.println("Both interfaces define methodA() - creating ambiguity");
        System.out.println();

        System.out.println("--- Calling overridden methodA() ---");
        demo.methodA();

        System.out.println("\n--- Calling BaseHierarchyInterface.super.methodA() ---");
        demo.callBaseMethodA();

        System.out.println("\n--- Calling UnrelatedInterfaceForDiamondProblem.super.methodA() ---");
        demo.callUnrelatedMethodA();

        System.out.println("\n--- Using BaseHierarchyInterface reference ---");
        BaseHierarchyInterface baseRef = demo;
        baseRef.methodA();

        System.out.println("\n--- Using UnrelatedInterfaceForDiamondProblem reference ---");
        UnrelatedInterfaceForDiamondProblem unrelatedRef = demo;
        unrelatedRef.methodA();

        System.out.println("\n===== Diamond Problem Resolution Strategies =====");
        System.out.println("1. Class override: DiamondProblemResolutionDemo.methodA() - REQUIRED");
        System.out.println("2. Super reference: InterfaceName.super.methodA() - Optional, for specificity");
        System.out.println("3. Interface polymorphism: Use reference type to call specific version");

        System.out.println("\n===== Why This Matters =====");
        System.out.println("- Java 8 introduced default methods in interfaces");
        System.out.println("- Multiple inheritance of implementations can cause ambiguity");
        System.out.println("- Unlike C++, Java requires explicit resolution");
        System.out.println("- This ensures clarity and avoids hidden behavior");
    }
}
