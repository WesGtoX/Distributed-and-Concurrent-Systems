package udp;

import java.net.DatagramPacket;
import java.net.DatagramSocket;

/**
 *
 * @author Wesley
 */
public class Server extends Thread {
    
    // Porta de comunicacao
    private final int PORTA = 12345;
    
    public Server() {
        System.out.println("-------------------------------------");
        System.out.println(" Servidor iniciado na porta " + PORTA );
        System.out.println("-------------------------------------");
    }
    
    @Override
    public void run() {
        try {
            // Criar um socket do tipo UDP
            DatagramSocket srv = new DatagramSocket(PORTA);
            
            while(true) {
                // Definir o buffer para recebimento da mensagem
                byte[] buffer = new byte[256];
                
                // Definir o pacote que sera recebido
                DatagramPacket pacote = new DatagramPacket(
                    buffer, buffer.length
                );
                
                // Receber o pacote
                srv.receive(pacote);
                
                // Transformar o pacote no tipo de dados esperado
                String msg = new String(pacote.getData()).trim();
                
                // Exibir a mensagem
                System.out.println("DE: " + pacote.getAddress().getHostAddress());
                System.out.println("MSG: " + msg);
            }
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
    
    public static void main(String[] args) {
        new Server().start();
    }
}
