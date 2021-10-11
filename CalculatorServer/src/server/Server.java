package server;

import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.server.UnicastRemoteObject;
import service.ICalculator;

/**
 *
 * @author Wesley
 */

// UnicastRemoteObject: torna os metodos da classe acessiveis remotamente
public class Server extends UnicastRemoteObject implements ICalculator {
    
    public Server() throws RemoteException{
        super();
    }

    @Override
    public double getSum(double x, double y) throws RemoteException {
        return x + y;
    }

    @Override
    public double getSubtraction(double x, double y) throws RemoteException {
        return x - y;
    }

    @Override
    public double getMultiplication(double x, double y) throws RemoteException {
        return x * y;
    }

    @Override
    public double getDivision(double x, double y) throws RemoteException {
        return x / y;
    }

    @Override
    public double getSquareRoot(double n) throws RemoteException {
        return Math.sqrt(n);
    }

    @Override
    public double getPotentiation(double b, double e) throws RemoteException {
        return Math.pow(b, e);
    }

    @Override
    public double getLogarithm(double n) throws RemoteException {
        return Math.log10(n);
    }

    @Override
    public double getFahrenheitToCelsius(double f) throws RemoteException {
        return (f - 32.0) * 5.0 / 9.0;
    }

    @Override
    public double getCelsiusToFahrenheit(double c) throws RemoteException {
        return c * (9.0 / 5.0) + 32.0;
    }
    
    // EXECUTAR O SERVIDOR
    public static void main(String[] args) {
        try {
            ICalculator srv = new Server();
            
            // Registrar a porta de comunicacao
            Registry rg = LocateRegistry.createRegistry(ICalculator.PORT);
            
            // Disponibilizar o servico
            rg.bind(ICalculator.SERVICE_NAME, srv);
            
            System.err.println("Servidor em execução...");
        } catch (Exception e) {
            System.err.println("ERRO: " + e.getMessage());
        }
    }
}
