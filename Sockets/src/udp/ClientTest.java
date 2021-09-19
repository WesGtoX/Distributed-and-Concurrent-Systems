package udp;

/**
 *
 * @author Wesley
 */
public class ClientTest {
    public static void main(String[] args) {
        Client cli = new Client();
        cli.send("Esta é uma mensagem de teste");
    }
}
