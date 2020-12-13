package gestion;
import javax.swing.*;

import com.formdev.flatlaf.*;
import com.formdev.flatlaf.intellijthemes.FlatArcOrangeIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatCyanLightIJTheme;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;

public class Login extends JFrame {
	
	
	JFrame loginForm;
	
	public Login(){
		//redimensionner la fenetre en fonction de la résolution de l'écran
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		this.setSize(screenSize.width/4, screenSize.height/4);
		this.setLocationRelativeTo(null);
		
		//creation boite de dialogue de login
		loginForm = new JFrame("Log in");
		loginForm.setIconImage(new ImageIcon("icon/carentalogo.png").getImage());		
		loginForm.setSize(screenSize.width/4, screenSize.height/3);
		loginForm.setLocationRelativeTo(null);
		loginForm.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); 
		
		Icon iconLogo = new ImageIcon("icon/carental.png");
		
		
		JPanel container = (JPanel) loginForm.getContentPane();
		container.setLayout(null);
		
		//édité avec eclipse GUI
		JLabel label = new JLabel("username");
		label.setBounds(159, 141, 66, 20);
		container.add(label);
		
		JTextField username = new JTextField("");
		username.setBounds(159, 160, 100, 20);
		container.add(username);
		
		JLabel label2 = new JLabel("password");
		label2.setBounds(159, 179, 66, 20);
		container.add(label2);
		
		JPasswordField password = new JPasswordField("");
		password.setBounds(159, 197, 100, 20);
		container.add(password);
		
		JButton login = new JButton("Login");
		login.setBounds(159, 229, 100, 20);
		container.add(login);
		
		JButton sign_in = new JButton("Sign up");
		sign_in.setBounds(159, 256, 100, 20);
		loginForm.getContentPane().add(sign_in);
		
		JLabel logo = new JLabel(iconLogo);
		logo.setBounds(148, 28, 121, 101);
		//logo.setIcon(iconLogo);
		container.add(logo);

		
		sign_in.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		 
		
	
		//vérifier le informations d'authentification
		login.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					Connection conn=DriverManager.getConnection("jdbc:mysql://localhost:8889/agence","root","");
					Statement stm= conn.createStatement(); 
					String query = "select * from users where username = '"+ username.getText()+ "' and password ='" + password.getText()+ "'";
					
					ResultSet userCheck = stm.executeQuery(query);
					
					if(userCheck.next()){
							loginForm.dispose();
							App app = new App();
							app.show();
					}
					else {
						
						JOptionPane.showMessageDialog(null, "Veuillez réessayer");
						username.setText(null);
						password.setText(null);
						
					}
				}
				catch(Exception e1) {
					System.out.print("no");

				}
				
			}
			
		});
		
	}
	
	
	
			
			public static void main (String [] args) {
				 try { 
		             // Set look and feel 
		             UIManager.setLookAndFeel(new FlatCyanLightIJTheme()); 
		   
		             
		         } 
		         catch (Exception e) { 
		         	System.out.println("erreur");
		         } 
				Login login =new Login();
				login.loginForm.show();

			}
}
