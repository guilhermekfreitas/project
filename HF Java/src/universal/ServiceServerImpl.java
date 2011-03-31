package universal;

import java.rmi.*;
import java.util.*;
import java.rmi.server.*;

public class ServiceServerImpl extends UnicastRemoteObject implements ServiceServer {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8383990848799999026L;
	private HashMap<String,Service> serviceList; // <String,Service>
	
	public ServiceServerImpl() throws RemoteException {
		setUpServices();
	}
	
	private void setUpServices() {
		serviceList = new HashMap<String,Service>();
		serviceList.put( "Dice Rolling Service", new DiceService() );
		serviceList.put( "Day of the Week Service", new DayOfTheWeekService());
		serviceList.put( "Visual Music Service", new MiniMusicServer() );
	}


	@Override
	public String[] getServiceList() throws RemoteException {
		System.out.println("[In remote]");
		return serviceList.keySet().toArray(new String[0]);
	}

	@Override
	public Service getService(Object serviceKey) throws RemoteException {
		return serviceList.get(serviceKey);
	}

	public static void main(String[] args) {
		try {
			ServiceServer ss = new ServiceServerImpl();
			Naming.rebind("ServiceServer", ss);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Remote system is running..");
		
	}
	
}
