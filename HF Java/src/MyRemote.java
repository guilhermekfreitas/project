
import java.rmi.*;

public interface MyRemote extends Remote {
	public String sayHello() throws RemoteException;
	
	public void setValue(String value) throws RemoteException;
}
