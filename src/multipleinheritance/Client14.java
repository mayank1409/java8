package multipleinheritance;

/**
 * Implements Interface1 and Interface4 (multiple inheritance of unrelated interfaces).
 * Both interfaces define methodA, causing a diamond problem.
 * Implementation must override methodA to resolve the conflict.
 */
public class Client14 implements Interface1, Interface4 {
    
    /**
     * Override methodA to resolve ambiguity.
     * When multiple interfaces provide the same method, implementation must choose.
     */
    @Override
    public void methodA() {
        System.out.println("Client14.methodA() - resolved from Interface1 and Interface4 conflict");
    }

    public static void main(String[] args) {
        Client14 client = new Client14();
        
        System.out.println("\n===== Testing Multiple Inheritance =====");
        client.methodA();
    }
}
