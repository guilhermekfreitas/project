package universal;

import java.io.*;
import javax.swing.*;


/*
 * Interface comum que todos os servi�os implementar�o.
 */

interface Service extends Serializable {
	public JPanel getGuiPanel();
}
