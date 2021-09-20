package tcp;

import java.io.Serializable;

/**
 *
 * @author Wesley
 */
public class Mensagem implements Serializable {

    private int tipo;       // Tipo da mensagem
    private String body;    // Corpo da mensagem

    public Mensagem() {}

    public Mensagem(int tipo, String body) {
        this.tipo = tipo;
        this.body = body;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Mensagem{" + "tipo=" + tipo + ", body=" + body + '}';
    }
}
