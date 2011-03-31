package universal;

import java.rmi.*;

/*
 * Serviço remoto. Interface pela qual
 * as outras aplicações terão acesso aos serviços 
 */
interface ServiceServer extends Remote {
	
	String[] getServiceList() throws RemoteException;
	
	Service getService(Object serviceKey) throws RemoteException;
}
