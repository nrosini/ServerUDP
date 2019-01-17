package chatethread;

import java.net.*;
import java.io.IOException;

public class SocketUDP extends Thread {
    private DatagramSocket socketInvio;
    private DatagramPacket pacchettoInvio;
    private String stringa;

    public SocketUDP(String stringa) {
        this.stringa = stringa;
    }

    @Override
    public void run() {
        System.out.println("Thread: Adesso parto io");
        this.inviaStringa();
    }

    private void inviaStringa() {
        byte[] stringaDaInviare = this.stringa.getBytes();
        try {
            this.pacchettoInvio = new DatagramPacket(stringaDaInviare,stringaDaInviare.length,InetAddress.getByName("127.0.0.1"),4316);
            this.socketInvio = new DatagramSocket();
            this.socketInvio.send(this.pacchettoInvio);
            this.socketInvio.close();
        } catch (UnknownHostException hostSconosciuto) {
            System.err.println("L'host indicato non è in rete");
        } catch (SocketException erroreSocket) {
            System.err.println("Errore del socket");
        } catch (IOException erroreFlusso) {
            System.err.println("Errore del flusso");
        }

    }
}
