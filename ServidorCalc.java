import java.rmi.registry.Registry;
import java.rmi.registry.LocateRegistry;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServidorCalc implements ICalculadora {

    public ServidorCalc(){ }

    public int soma(int a, int b) {
        return a+b;
    }

    public static void main(String args[])
    {
        try {
            ServidorCalc obj = new ServidorCalc();
            ICalculadora stub = (ICalculadora)
                UnicastRemoteObject.exportObject(obj,0);
            Registry registro = LocateRegistry.getRegistry();
            registro.rebind("Calculadora",obj);
            System.out.println("Objeto Registrado !!!!");
        }
        catch (Exception e) {
            System.out.println("Erro");
        }
    }

}
