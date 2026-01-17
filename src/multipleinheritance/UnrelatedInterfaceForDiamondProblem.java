package multipleinheritance;

/**
 * Independent interface used in diamond problem demonstration.
 * Also provides methodA (like Interface1) to create method conflict.
 * Used to show how to resolve multiple inheritance ambiguity.
 */
public interface UnrelatedInterfaceForDiamondProblem {
    /**
     * Default method similar to Interface1, demonstrating diamond problem.
     */
    default void methodA() {
        System.out.println("Interface4.methodA()");
    }
}
