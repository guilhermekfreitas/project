package universal;

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.io.*;
import java.util.*;
import java.text.*;

public class DayOfTheWeekService implements Service {

	private JLabel outputLabel;
	private JComboBox month;
	private JTextField day;
	private JTextField year;
	
	@Override
	public JPanel getGuiPanel() {
		JPanel panel = new JPanel();
		JButton button = new JButton("Do it!");
		button.addActionListener( new DoItListener() );
		outputLabel = new JLabel("date appears here");
		DateFormatSymbols dateStuff = new DateFormatSymbols();
		
		month = new JComboBox(dateStuff.getMonths());
		day = new JTextField(8);
		year = new JTextField(8);
		JPanel inputPanel = new JPanel(new GridLayout(3,2));
		inputPanel.add(new JLabel("Month"));
		inputPanel.add(month);
		inputPanel.add(new JLabel("Day"));
		inputPanel.add(day);
		inputPanel.add(new JLabel("Year"));
		inputPanel.add(year);
		
		panel.add(inputPanel);
		panel.add(button);
		panel.add(outputLabel);
		return panel;
	}

	class DoItListener implements ActionListener {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			
			if (validate()) {
				int monthNum = month.getSelectedIndex();
				int dayNum = Integer.parseInt(day.getText());
				int yearNum = Integer.parseInt(year.getText());

				DateFormat df = DateFormat.getDateInstance();
				Date dt = null;
				try {
					dt = df.parse(String.format("%2$s/%1$s/%3$s", month.getSelectedIndex(), day.getText(), year.getText()));
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
					return;
				}
				
				Calendar c = Calendar.getInstance();
				c.set(Calendar.MONTH, monthNum);
				c.set(Calendar.DAY_OF_MONTH, dayNum);
				c.set(Calendar.YEAR, yearNum );
				
				
				Date date = c.getTime();
				String dayOfWeek = (new SimpleDateFormat("EEEE")).format(dt);
				outputLabel.setText(dayOfWeek);
			}
		}
		
		private boolean isNull(String input){
			return (input == null);
		}
		
		private boolean validate() {
			
			boolean isValid = true;
			String sDay = day.getText();
			String sYear = year.getText();
			
			if (isNull(sDay) || sDay.isEmpty() )
				isValid = false;
			else if (isNull(sYear) || sYear.isEmpty())
				isValid = false;
			
			return isValid;
		}
		
	} // fim classe interna
}