package universal;

import java.io.*;
import javax.swing.*;


/*
 * Interface comum que todos os serviços implementarão.
 */

interface Service extends Serializable {
	public JPanel getGuiPanel();
}
