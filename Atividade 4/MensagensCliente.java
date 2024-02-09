import java.rmi.Naming;
import java.util.List;

public class MensagensCliente {
    public static void main(String[] args) {
        try {
            String registryURL = "rmi://127.0.0.1:11099/RMIInterface";
            Mensagens mensagens = (Mensagens) Naming.lookup(registryURL);
            mensagens.guardarMensagem("Conectado ao servidor");
            List<String> listaMensagens = mensagens.listarMensagens();
            System.out.println("Lista de Mensagens: " + listaMensagens);
            String IP_servidor = mensagens.mostrarIP_Servidor();
            System.out.println("IP do Servidor: " + IP_servidor);
            String horaServidor = mensagens.mostrarHoraServidor();
            System.out.println("Data e Hora do Servidor: " + horaServidor);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
