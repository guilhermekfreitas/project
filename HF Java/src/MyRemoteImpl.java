import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.text.DateFormat;
import java.util.Date;

public class MyRemoteImpl extends UnicastRemoteObject implements MyRemote {

	private String myValue;
	
	public MyRemoteImpl() throws RemoteException {
		myValue = "default";
	}
	
	@Override
	public String sayHello() throws RemoteException {
		return "Servidor says:'Hi'" + myValue;
	}

	@Override
	public void setValue(String value) throws RemoteException {
		this.myValue = value;
	}

}
