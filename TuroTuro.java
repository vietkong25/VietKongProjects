package NSEP;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import java.awt.Color;

public class TuroTuro 
{

	private JFrame frame;
	private JTextField txtTotalAmount;
	private JTextField textField;


	public static void main(String[] args) 
	{
		EventQueue.invokeLater(new Runnable() 
		{
			public void run() 
			{
				try 
				{
					
					TuroTuro window = new TuroTuro();
					window.frame.setVisible(true);
				}
				catch (Exception e) 
				
				{
					e.printStackTrace();
				}
			}
		});
	}

	public TuroTuro() 
	{
		initialize();
	}

	
	private void initialize() 
	{
		frame = new JFrame();
		frame.getContentPane().setForeground(Color.DARK_GRAY);
		frame.setBounds(100, 100, 450, 269);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton bananaCue = new JButton("Banana Cue");
		bananaCue.addActionListener(new ActionListener() 
		{
			public void actionPerformed(ActionEvent arg0) 
			{
				//if(bananaCue == );
			}
		});
		bananaCue.setBounds(10, 145, 110, 23);
		frame.getContentPane().add(bananaCue);
		
		JButton maruya = new JButton("Maruya");
		maruya.setBounds(150, 145, 110, 23);
		frame.getContentPane().add(maruya);
		
		JButton confirmButton = new JButton("Confirm");
		confirmButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		confirmButton.setBounds(162, 196, 89, 23);
		frame.getContentPane().add(confirmButton);
		
		JButton gulaman = new JButton("Gulaman");
		gulaman.setBounds(287, 145, 110, 23);
		frame.getContentPane().add(gulaman);
		
		txtTotalAmount = new JTextField();
		txtTotalAmount.setEditable(false);
		txtTotalAmount.setText("TOTAL AMOUNT:");
		txtTotalAmount.setBounds(10, 11, 110, 20);
		frame.getContentPane().add(txtTotalAmount);
		txtTotalAmount.setColumns(10);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(20, 42, 377, 58);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	}
		public void printTotal()
		{
			
		}
	
}
