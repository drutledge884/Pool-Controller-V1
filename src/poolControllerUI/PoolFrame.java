package poolControllerUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import poolControllerPD.Pool;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Image;
@SuppressWarnings({ "unused", "serial" })

public class PoolFrame extends JFrame 
{
	private JPanel contentPanel;
	private JFrame currentFrame;

	/**
	 * Launch the Pool
	 */
	public static void open(Pool pool) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					PoolFrame frame = new PoolFrame(pool);
					frame.setVisible(true);
				} 
				catch (Exception e) 
				{
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Instantiate the frame.
	 */
	public PoolFrame(Pool pool) 
	{
		currentFrame = this;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(360, 50, 1000, 800);
		//creates a menu bar
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//maintenance drop down menu
		JMenu mnNewMenu = new JMenu("Pool Maintainance");
		menuBar.add(mnNewMenu);
		//filter edit
		JMenuItem mntmNewMenuItem = new JMenuItem("Filter Controls");
		mntmNewMenuItem.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent a) 
			{
				getContentPane().removeAll();
				getContentPane().add(new FilterModPanel(currentFrame, pool));
				getContentPane().revalidate();
			}
		});
		mnNewMenu.add(mntmNewMenuItem);
		//pump edit
		JMenuItem mntmNewMenuItem2 = new JMenuItem("Pump Controls");
		mntmNewMenuItem2.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent b) 
			{
				getContentPane().removeAll();
				getContentPane().add(new PumpsModPanel(currentFrame, pool));
				getContentPane().revalidate();
			}
		});
		mnNewMenu.add(mntmNewMenuItem2);
		//lights edit
		JMenuItem mntmNewMenuItem3 = new JMenuItem("Light Controls");
		mntmNewMenuItem3.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent c) 
			{
				getContentPane().removeAll();
				getContentPane().add(new LightsModPanel(currentFrame, pool));
				getContentPane().revalidate();
			}
		});
		mnNewMenu.add(mntmNewMenuItem3);
		//heater edit
		JMenuItem mntmNewMenuItem4 = new JMenuItem("Heater Controls");
		mntmNewMenuItem4.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent d) 
			{
				getContentPane().removeAll();
				getContentPane().add(new HeaterModPanel(currentFrame, pool));
				getContentPane().revalidate();
			}
		});
		mnNewMenu.add(mntmNewMenuItem4);
		//create j panel and add a Pool Home		
		contentPanel = new JPanel();
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPanel.setLayout(new BorderLayout(0, 0));
		
		setContentPane(contentPanel);
		getContentPane().removeAll();
		getContentPane().add(new PoolHome(pool)); // This is where it creates a new PoolHome. Try to make a recursive function here!
		getContentPane().revalidate();
	}
}
