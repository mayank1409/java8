package multipleinheritance;

/**
 * Implements Interface1, Interface2, Interface3.
 * Demonstrates linear interface hierarchy: Interface3 -> Interface2 -> Interface1.
 * Must override methodA to resolve ambiguity (Interface1 vs Interface2 versions).
 */
public class Client123 implements Interface3 {

    /**
     * Override methodA to resolve which interface's version to use.
     * Interfaces 1 and 2 both provide methodA, so implementation must choose.
     */
    @Override
    public void methodA() {
        System.out.println("Client123.methodA() - resolved");
    }

    public static void main(String[] args) {
        Client123 client = new Client123();
        
        System.out.println("\n===== Testing Interface Methods =====");
        client.methodA();  // Overridden in Client123
        client.methodB();  // From Interface2
        client.methodC();  // From Interface3
    }
}
