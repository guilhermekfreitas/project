
import java.rmi.*;

/*
 * Classe que pesquisa o nome do serviço no rmiregistry, e obtém
 * o a conexão com o .stub do objeto desejado.
 */
public class MyRemoteClient {
	public static void main(String[] args) {
		
		String s;
		if (args.length == 0)
			s = "127.0.0.1";
		else
			s = args[0];
			
		new MyRemoteClient().go(s);
	}

	private void go(String specifiedIP) {
		
		String path = String.format("rmi://%s/RemoteHello", specifiedIP);
		
		try {
			
			MyRemote service = (MyRemote) Naming.lookup(path);
			String s = service.sayHello();
			
			System.out.println(s);
		} catch( Exception exc){
			exc.printStackTrace();
		}
	}
}
