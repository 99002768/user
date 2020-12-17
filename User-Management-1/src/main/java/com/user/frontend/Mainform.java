package com.user.frontend;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.user.model.Valid;
import com.user.service.RegisterService;

public class Mainform {

	private JFrame frame;
	private JTextField textField;
	 private JPasswordField passwordField;
	   private BufferedImage img;
	private Valid valid=new Valid();
	@Autowired
	RegisterService registerService;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainform window = new Mainform();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Mainform() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 574, 384);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		frame.setVisible(true);
		JLabel lblNewLabel = new JLabel("Email");
		lblNewLabel.setBounds(22, 94, 92, 26);
		frame.getContentPane().add(lblNewLabel);
		
		textField = new JTextField();
		textField.setBounds(137, 92, 152, 31);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("Password");
		lblNewLabel_1.setBounds(22, 142, 92, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(137,143 , 152, 31);
        frame.getContentPane().add(passwordField);
        
        Button button = new Button("Sign in");
        button.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		int flag=0;
        		 try {
        			 
        			 if((textField.getText().length()==0)||(passwordField.getText().length()==0)) {
        				 JOptionPane.showMessageDialog(button, "Enter Username & Password");
        			 }
        			 if((textField.getText().length()!=0)&&(passwordField.getText().length()!=0)){
//					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3333/project", "root", "password");
//					String sql = "select email,passwd from  where email=? and passwd=?";
//					PreparedStatement ps = connection.prepareStatement(sql);
//					ps.setString(1, textField.getText());
//					ps.setString(2, passwordField.getText());
//					ResultSet rs = ps.executeQuery();
//					if (rs.next()) { 
//                        JOptionPane.showMessageDialog(button, "You have successfully logged in");
//                        flag=1;
//                    }
//					else {
//                        JOptionPane.showMessageDialog(button, "Wrong Email & Password");
//                    }
//					connection.close();
        			 }
        			 valid.setEmailid(textField.getText());
        			 valid.setPassword(passwordField.getText());
        			if(registerService.authenticate(valid)) {
        				System.out.println("Logged in");
//        				new Secondpage(valid);
        			}
        			else {
        				  JOptionPane.showMessageDialog(button, "Wrong Email & Password");
        			}
				} 
        		 catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
//        		 if(flag==1) {
//        			 new Secondpage(valid);
//        		 }
        	}
        });
        button.setBackground(new Color(135, 206, 250));
        button.setBounds(164, 202, 92, 22);
        frame.getContentPane().add(button);
        
        JLabel lblNewLabel_2 = new JLabel("Create an account?");
        lblNewLabel_2.setForeground(Color.RED);
        lblNewLabel_2.setBounds(137, 272, 181, 26);
        frame.getContentPane().add(lblNewLabel_2);
        
        JLabel lblNewLabel_3 = new JLabel("<HTML><U>Click here</U></HTML>");
        lblNewLabel_3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		Registration use=new Registration();
        		frame.dispose();
        	}
        });
        lblNewLabel_3.setBounds(272, 272, 86, 26);
        frame.getContentPane().add(lblNewLabel_3);
        
//        Canvas canvas = new Canvas();
//        canvas.setBounds(164, 10, 92, 76);
//        Object image = Toolkit.getDefaultToolkit().getImage("avatar1.png");
//		canvas.paint((Graphics) image);
//        frame.getContentPane().add(canvas);
//        
//        Canvas canvas = new Canvas();
//        canvas.setBounds(178, 10, 92, 50);
//        Graphics g;
//        img = ImageIO.read(new File("avatar1.png"));
//        canvas.paint(g.drawImage(img, 178,10 , this.img));
//        frame.getContentPane().add(canvas);

	}
}
