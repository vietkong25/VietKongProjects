package midterm;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

public class Registration extends JFrame implements ActionListener
{
	user SnG = new user();
	
	GridLayout gridLayout = new GridLayout(0, 1);
	
	String[] cities = {"Select City","*************",
					   "Quezon City", "Caloocan City", "Manila City", 
					   "Davao City", 
					   "San Juan City", "Marikina City", 
					   "Baguio City","Caloocan City","*************"};
	
	public JPanel panel;	
	private JLabel name, password, confPass,city,gender,blank,gmail;	
	private JTextField nameTF, gmailTF;	
	private JPasswordField passwordPF, confPassPF;
	private JComboBox cityCB;	
	private JButton submitB;	
	private JRadioButton genderMaleRB,genderFemaleRB;	
	private ButtonGroup buttonGroup;

	public Registration()
	{
		super("Simple Registration Form");
		setTitle("Registration Form");
		getContentPane().setBackground(Color.PINK);
		setForeground(Color.PINK);
		panel = new JPanel();
		panel.setLayout(gridLayout);
	
		name = new JLabel("Name: ");
		name.setHorizontalAlignment(SwingConstants.CENTER);
		name.setBackground(Color.YELLOW);
		password = new JLabel("Password: ");
		password.setHorizontalAlignment(SwingConstants.CENTER);
		confPass = new JLabel("Confirm Password: ");
		confPass.setHorizontalAlignment(SwingConstants.CENTER);
		city = new JLabel("City: ");
		city.setHorizontalAlignment(SwingConstants.CENTER);
		gender = new JLabel("Gender: ");
		gender.setHorizontalAlignment(SwingConstants.CENTER);
		blank = new JLabel("");
		gmail = new JLabel("Gmail: ");
		gmail.setHorizontalAlignment(SwingConstants.CENTER);
	
		nameTF = new JTextField(30);
		nameTF.setHorizontalAlignment(SwingConstants.CENTER);
		passwordPF = new JPasswordField(20);
		passwordPF.setHorizontalAlignment(SwingConstants.CENTER);
		confPassPF = new JPasswordField(20);
		confPassPF.setHorizontalAlignment(SwingConstants.CENTER);
	
		cityCB = new JComboBox(cities);
		cityCB.setBounds(new Rectangle(5, 5, 5, 5));
		cityCB.setToolTipText("Select City");
		cityCB.setBackground(Color.WHITE);
	
		genderMaleRB = new JRadioButton("Male");
		genderMaleRB.setHorizontalAlignment(SwingConstants.CENTER);
		genderMaleRB.setAlignmentX(Component.RIGHT_ALIGNMENT);
		genderMaleRB.setActionCommand("Male");
		genderMaleRB.setSelected(false);
		genderMaleRB.setBackground(Color.WHITE);
	
		genderFemaleRB = new JRadioButton("Female");
		genderFemaleRB.setHorizontalAlignment(SwingConstants.CENTER);
		genderFemaleRB.setActionCommand("Female");
		genderFemaleRB.setSelected(false);
		genderFemaleRB.setBackground(Color.WHITE);
		
		buttonGroup = new ButtonGroup();
		buttonGroup.add(genderMaleRB);
		buttonGroup.add(genderFemaleRB);
		
		panel.add(name);
		panel.add(nameTF);
		panel.add(password);
		panel.add(passwordPF);
		panel.add(confPass);
		panel.add(confPassPF);
		panel.add(city);
		panel.add(cityCB);
		panel.add(gender);
		panel.add(genderMaleRB);
		panel.add(blank);
		panel.add(genderFemaleRB);
		panel.add(gmail);
		getContentPane().add(panel);
		
		setSize(677, 418);
		setVisible(true);
		setResizable(true);
		panel.setBackground(Color.WHITE);
		gmailTF = new JTextField(40);
		gmailTF.setHorizontalAlignment(SwingConstants.CENTER);
		gmailTF.setForeground(new Color(0, 0, 0));
		panel.add(gmailTF);
		gmailTF.addActionListener(this);
		
		submitB = new JButton("Submit");
		submitB.setForeground(Color.RED);
		submitB.setBackground(Color.DARK_GRAY);
		submitB.setAutoscrolls(true);
		submitB.setBorder(null);
		submitB.setAlignmentX(Component.RIGHT_ALIGNMENT);
		submitB.setBounds(new Rectangle(5, 5, 5, 5));
		panel.add(submitB);
		submitB.addActionListener(this);
		
		nameTF.addActionListener(this);
		passwordPF.addActionListener(this);
		confPassPF.addActionListener(this);
		cityCB.addActionListener(this);
		genderMaleRB.addActionListener(this);
		genderFemaleRB.addActionListener(this);
	}	
	
	public void actionPerformed(ActionEvent event) 
	{
		// PASSWORD SECTION
		if(!(Arrays.equals(passwordPF.getPassword(), confPassPF.getPassword())))
		{
			JOptionPane.showMessageDialog(null, "Password do not match.", "OOOPPPPSSSS",
					JOptionPane.ERROR_MESSAGE);
        }
		
		// SUBMIT BUTTON
		String action = event.getActionCommand();
		
		if(action.equals("Submit"))
		{
			if(nameTF.getText().equals("") || passwordPF.getText().equals("") || confPassPF.getText().equals("")
					|| cityCB.getSelectedItem().equals("Select City") || gmailTF.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null, "Complete all the informations.", "***Warning Message***", 
							JOptionPane.WARNING_MESSAGE);
				}
			
			else
			{
				JOptionPane.showMessageDialog(null, "Thank you, you are Registered", "***Message***",
						JOptionPane.PLAIN_MESSAGE);
				try
				{
					File file = new File("C:/Users/Aji_Blanco/Desktop/output form/forms.doc");
					PrintWriter pw = new PrintWriter(new FileWriter(file, true));
					
					SnG.setName(nameTF.getText());
					SnG.setPassword(passwordPF.getText());
					SnG.setConfPass(confPassPF.getText());
					SnG.setCity(cityCB.getSelectedItem().toString());
					SnG.setGender(buttonGroup.getSelection().getActionCommand().toString());
					SnG.setGmail(gmailTF.getText());
					
					String name = SnG.getName();
					String password = SnG.getPassword();
					String confPass = SnG.getConfPass();
					String city = SnG.getCity();
					String gender = SnG.getGender();
					String gmail = SnG.getGmail();
					
					pw.print(name + ";\n" + password + ";\n" + confPass + ";\n" + city + ";\n"
							+ gender + ";\n" + gmail + "\n");
					pw.close();
				}
				
				catch (Exception a)
				{
					System.out.println("Thank you you are registered");
				}
			}
			nameTF.setText(null);
			passwordPF.setText(null);
			confPassPF.setText(null);
			cityCB.setSelectedIndex(0);
			buttonGroup.clearSelection();
			gmailTF.setText(null);
		}
	}

	public static void main(String[] args)
	{
		new Registration();
	}
}