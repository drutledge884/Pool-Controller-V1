package poolControllerUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import poolControllerPD.*;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import java.awt.event.ActionListener;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;

@SuppressWarnings({ "unused", "serial" })

public class HeaterModPanel extends JPanel 
{
	JTextField textField_1;
	/**
	 * Instantiate the panel.
	 */
	public HeaterModPanel(JFrame currentFrame, Pool pool) 
	{
		setLayout(null);
		this.setBackground(Color.BLACK);
		//decide if the heater should be on or not
		pool.getHeater().autoMaintain();
		//set the current temperature
		String tempStr = "Current Temp: " + pool.getHeater().getReadString() + " deg";
		JLabel lblNewLabel2 = new JLabel(tempStr);
		lblNewLabel2.setFont(new Font("Courier", Font.BOLD, 36));
		lblNewLabel2.setForeground(Color.white);
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setBounds(260, 100, 525, 70);
		add(lblNewLabel2);
		//set the desired temperature
		String strl = "Desired Temp: " + pool.getHeater().getTargetString() + " deg";
		JLabel lblNewLabel3 = new JLabel(strl);
		lblNewLabel3.setFont(new Font("Courier", Font.BOLD, 36));
		lblNewLabel3.setForeground(Color.white);
		lblNewLabel3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel3.setBounds(240, 200, 600, 70);
		String str2 = pool.getHeater().getTargetString();
		textField_1 = new JTextField(pool.getHeater().getTargetString());
		textField_1.setBounds(25, 220, 100, 30);
		add(textField_1);
		add(lblNewLabel3);
		//tell if the heater is on or not
		JLabel lblNewLabel1;
		if(pool.getHeater().getActive())
			lblNewLabel1 = new JLabel("Heater Status: On");
		else
			lblNewLabel1 = new JLabel("Heater Status: Off");
		lblNewLabel1.setFont(new Font("Courier", Font.BOLD, 36));
		lblNewLabel1.setForeground(Color.white);
		lblNewLabel1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel1.setBounds(280, 300, 450, 50);
		add(lblNewLabel1);
		//sets the target temperature to the temperature entered by user
		JButton btnNewButton_3 = new JButton("Enter");
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				pool.getHeater().setTargetString(textField_1.getText());
				pool.getHeater().autoMaintain();
				currentFrame.getContentPane().add(new HeaterModPanel(currentFrame, pool));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_3.setBounds(150, 220, 100, 30);
		btnNewButton_3.setEnabled(true);
		add(btnNewButton_3);
	}
}
