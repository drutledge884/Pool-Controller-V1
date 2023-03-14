package poolControllerUI;

import javax.swing.JFrame;
import javax.swing.JPanel;
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

public class PumpsModPanel extends JPanel 
{
	JButton btnNewButton_1;
	JButton btnNewButton_2;

	/**
	 * Instantiate the panel.
	 */
	public PumpsModPanel(JFrame currentFrame, Pool pool) 
	{
		setLayout(null);
		this.setBackground(Color.BLACK);		
		JLabel lblNewLabel2;
		//display if the filter is on or not
		if(pool.getFilter().getActive())
			lblNewLabel2 = new JLabel("Pump Status: On");
		else
			lblNewLabel2 = new JLabel("Pump Status: Off");
		lblNewLabel2.setFont(new Font("Courier", Font.BOLD, 36));
		lblNewLabel2.setForeground(Color.white);
		lblNewLabel2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel2.setBounds(260, 100, 450, 50);
		add(lblNewLabel2);
		//turn filter on
		btnNewButton_1 = new JButton("Pump On");
		btnNewButton_1.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) 
			{
				pool.getFilter().setActive(true);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PumpsModPanel(currentFrame, pool));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_1.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_1.setBounds(385, 400, 180, 30);
		btnNewButton_1.setEnabled(true);
		add(btnNewButton_1);
		//turn filter off
		btnNewButton_2 = new JButton("Pump Off");
		btnNewButton_2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				pool.getFilter().setActive(false);
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PumpsModPanel(currentFrame, pool));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_2.setHorizontalAlignment(SwingConstants.CENTER);
		btnNewButton_2.setBounds(385, 500, 180, 30);
		btnNewButton_2.setEnabled(true);
		add(btnNewButton_2);	
		//refresh runtime calculator
		JButton btnNewButton_3 = new JButton("Refresh");
		btnNewButton_3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent e) 
			{
				currentFrame.getContentPane().removeAll();
				currentFrame.getContentPane().add(new PumpsModPanel(currentFrame, pool));
				currentFrame.getContentPane().revalidate();
			}
		});
		btnNewButton_3.setBounds(50, 220, 100, 30);
		btnNewButton_3.setEnabled(true);
		add(btnNewButton_3);
		//display run time
		int i = 1;
		while(i > 0)
		{
			String lblStr = new String("Run Time: " + pool.getPump().toString());

			try 
			{
				currentFrame.getContentPane().add(new PumpsModPanel(currentFrame, pool));
				Thread.sleep(1000);

			} 
			catch (InterruptedException e1) 
			{
				e1.printStackTrace();
			}
		}
		String lblStr = new String("Run Time: " + pool.getPump().toString());
		JLabel labelString = new JLabel(lblStr);
		labelString.setFont(new Font("Courier", Font.BOLD, 36));
		labelString.setForeground(Color.white);
		labelString.setHorizontalAlignment(SwingConstants.CENTER);
		labelString.setBounds(180, 200, 600, 50);
		add(labelString);
	}
}
