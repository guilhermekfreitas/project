package universal;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.rmi.Naming;

import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * GUI do Cliente. Realiza a conex�o com o servidor e obt�m os servi�os.
 */
public class ServiceBrowser {

	private JPanel mainPanel;
	private JComboBox serviceList;
	private ServiceServer server;

	public void buildGUI() {
		JFrame frame = new JFrame("RMI Browser");
		mainPanel = new JPanel();
		frame.getContentPane().add(BorderLayout.CENTER, mainPanel);

		server = connectToServer("rmi://127.0.0.1/ServiceServer");
		String[] services = getServicesList();
		serviceList = new JComboBox(services);

		frame.getContentPane().add(BorderLayout.NORTH, serviceList);
		serviceList.addActionListener(new MyListListener());

		frame.setSize(500, 500);
		frame.setVisible(true);

	}

	public static void main(String[] args) {
		new ServiceBrowser().buildGUI();
	}

	private ServiceServer connectToServer(String address) {
		ServiceServer myServer = null;
		try {
			myServer = (ServiceServer) Naming.lookup(address);
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return myServer;
	}

	private String[] getServicesList() {

		// criar m�todo connectToServer()

		// Object obj = null;
		String[] services = null;

		/*
		 * try { obj = Naming.lookup("rmi://127.0.0.1/ServiceServer"); // obt�m
		 * servi�o. } catch( Exception exc ){ exc.printStackTrace(); }
		 * 
		 * server = (ServiceServer) obj;
		 */

		try {
			services = server.getServiceList(); // pega lista dos servi�os
												// dispon�veis.
		} catch (Exception exc) {
			exc.printStackTrace();
		}
		return services;
	}

	private void loadService(Object serviceSelection) {
		try {
			Service svc = server.getService(serviceSelection);

			mainPanel.removeAll();
			mainPanel.add(svc.getGuiPanel());
			mainPanel.validate();
			mainPanel.repaint();
		} catch (Exception exc) {
			exc.printStackTrace();
		}
	}

	class MyListListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			Object selection = serviceList.getSelectedItem();
			loadService(selection);
		}

	}

}
