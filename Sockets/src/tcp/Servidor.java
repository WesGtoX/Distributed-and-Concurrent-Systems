package tcp;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;

/**
 *
 * @author Wesley
 */
public class Servidor extends Thread{
    
    // Definir a porta de comunicacao
    private final int PORTA = 5000;
    
    // Definir os fluxos (stream) de comunicacao
    private ObjectInputStream fluxo_entrada;
    private ObjectOutputStream fluxo_saida;
    
    private final JTextArea txt;
    
    public Servidor(JTextArea txt){
        this.txt = txt;
    }
    
    public void enviar(Mensagem msg){
        try {
            fluxo_saida.writeObject(msg);
            fluxo_saida.flush();
        } catch (IOException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
    
    private void show(String msg){
        txt.append(msg + "\n");
    }
    
    @Override
    public void run(){
        try {
            // Iniciar o Servidor Stream Socket
            ServerSocket srv = new ServerSocket(PORTA);
            show("Servidor iniciado na porta " + PORTA);
            
            while(true){
                show("Aguardando conexão...");
                Socket con = srv.accept();
                
                show("Conexão de: " + con.getInetAddress().getHostName());
                
                // Instanciar os fluxos de comunicacao
                fluxo_saida = new ObjectOutputStream(con.getOutputStream());
                fluxo_entrada = new ObjectInputStream(con.getInputStream());
                
                enviar(new Mensagem(1,"Conexão realizada com sucesso!"));
                
                // Processar as mensagens
                Mensagem msg;
                do{
                    msg = (Mensagem)fluxo_entrada.readObject();
                    show("\nMensagem");
                    show("Tipo: " + msg.getTipo());
                    show("Body: " + msg.getBody());
                }while(msg.getTipo() != -1); // Tipo -1 = FIM da comunicacao
                
                fluxo_entrada.close();
                fluxo_saida.close();
                con.close();
            }
            
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
}
