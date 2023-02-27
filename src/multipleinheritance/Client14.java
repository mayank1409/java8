package multipleinheritance;

public class Client14 implements Interface1, Interface4{
    @Override
    public void methodA() {
        System.out.println("Client14 methodA");
    }

    public static void main(String[] args) {
        Client14 client14 = new Client14();
        client14.methodA();
    }
}
