package multipleinheritance;

public interface Interface1 {
    default void methodA() {
        System.out.println("methodA");
    }
}
