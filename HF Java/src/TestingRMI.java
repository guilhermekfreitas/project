import java.rmi.Naming;
import java.util.Scanner;

/*
 * Registra o servi�o "RemoteHello" . 
 * Para isso, � preciso seguir os passos:
 * 1. -> compile MyRemoteImpl
 * 2. -> rmic MyRemoteImpl (gerando o .stub: � por ele que ser� feita a conex�o)
 * 3. -> rmiregistry (registra o servi�o no rmi: � por aqui que o cliente pesquisa o nome do servi�o).
 * 4. -> execute ESTA classe! 
 * Pronto! Seu objeto est� acess�vel via RMI. Para acess�-lo, execute a classe
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
