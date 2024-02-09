import java.rmi.Naming;

public class ConversaoCliente {
    public static void main(String[] args) {
        try {
            String registryURL = "rmi://127.0.0.1:11099/RMIInterface";
            Conversao conversao = (Conversao) Naming.lookup(registryURL);
            float realParaDolar = conversao.realParaDolar(100);
            System.out.println("100 reais em dolar: " + realParaDolar);
            float dolarParaReal = conversao.dolarParaReal(100);
            System.out.println("100 dolares em real: " + dolarParaReal);
            float realParaEuro = conversao.realParaEuro(100);
            System.out.println("100 reais em euro: " + realParaEuro);
            float euroParaReal = conversao.euroParaReal(100);
            System.out.println("100 euros em real: " + euroParaReal);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
