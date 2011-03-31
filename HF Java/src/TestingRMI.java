import java.rmi.Naming;
import java.util.Scanner;

/*
 * Registra o serviço "RemoteHello" . 
 * Para isso, é preciso seguir os passos:
 * 1. -> compile MyRemoteImpl
 * 2. -> rmic MyRemoteImpl (gerando o .stub: é por ele que será feita a conexão)
 * 3. -> rmiregistry (registra o serviço no rmi: é por aqui que o cliente pesquisa o nome do serviço).
 * 4. -> execute ESTA classe! 
 * Pronto! Seu objeto está acessível via RMI. Para acessá-lo, execute a classe
 * MyRemoteClient. (ou alguma similar).
 */
public class TestingRMI {
	public static void main(String[] args) {
		
		MyRemote service = null;
		try{
			service = new MyRemoteImpl();
			Naming.rebind("RemoteHello", service);
			
			System.out.println("Hey..");
			Scanner sc = new Scanner(System.in);
			while(sc.hasNext()){
				service.setValue(sc.next());
			}
		}
		catch(Exception exc){ 
			exc.printStackTrace(); 
		}
		
		
		
		
	}
}
