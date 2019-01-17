package chatethread;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main: Io sto facendo gli affari miei");
        SocketUDP socketUDP = new SocketUDP("SPAM");
        socketUDP.run();
        while (true) {
            System.out.println("Main: Io sto facendo ancora gli affari miei eh");
            try {
                Thread.sleep(20000);
            } catch (InterruptedException threadInterrotto) {}
        }
    }
}
