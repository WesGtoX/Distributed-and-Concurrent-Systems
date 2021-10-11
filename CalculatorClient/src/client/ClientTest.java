package client;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import service.ICalculator;

/**
 *
 * @author Wesley
 */
public class ClientTest {
    
    public static void main(String[] args) {
        try {
            // Registrar o Servico que sera acessado
            Registry srv = LocateRegistry.getRegistry(
                ICalculator.SERVICE_HOST,
                ICalculator.PORT
            );
            
            // Descobrir quais metodos remotos estao disponiveis
            ICalculator op = (ICalculator)srv.lookup(ICalculator.SERVICE_NAME);
            
            System.out.println("Sum " + op.getSum(2, 5));
            System.out.println("Subtraction " + op.getSubtraction(5, 2));
            System.out.println("Multiplication " + op.getMultiplication(2, 5));
            System.out.println("Division " + op.getDivision(10, 2));
            System.out.println("Square Root " + op.getSquareRoot(9));
            System.out.println("Potentiation " + op.getPotentiation(5, 2));
            System.out.println("Logarithm " + op.getLogarithm(2));
            System.out.println("Fahrenheit To Celsius " + op.getFahrenheitToCelsius(90));
            System.out.println("Celsius To Fahrenheit " + op.getCelsiusToFahrenheit(22));

        } catch (NotBoundException | RemoteException e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
}
