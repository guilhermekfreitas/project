package universal;

import java.rmi.*;

/*
 * Servi�o remoto. Interface pela qual
 * as outras aplica��es ter�o acesso aos servi�os 
 */
interface ServiceServer extends Remote {
	
	String[] getServiceList() throws RemoteException;
	
	Service getService(Object serviceKey) throws RemoteException;
}
