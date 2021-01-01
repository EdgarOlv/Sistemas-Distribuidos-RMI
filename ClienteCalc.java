import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.*;

public class ClienteCalc {
    public static void main(String args[])
    {
        Scanner teclado = new Scanner(System.in);
        try{
            Registry registro = LocateRegistry.getRegistry("127.0.0.1");
            ICalculadora calc = (ICalculadora) registro.lookup("Calculadora");

            System.out.println("Digite um Numero: ");
            int a = teclado.nextInt();
            System.out.println("Digite outro Numero: ");
            int b = teclado.nextInt();

            int soma = calc.soma(a,b);
            System.out.println(soma);
        } catch (Exception e) {
            System.out.println("Erro!!");
        }
    }
}
