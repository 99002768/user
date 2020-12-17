package com.user.frontend;

import java.awt.Button;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.image.BufferedImage;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.border.Border;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.user.model.Add;
import com.user.model.User;
import com.user.model.Valid;
import com.user.service.RegisterService;
import com.user.service.RegisterServiceImpl;

@Component
public class Registration {

	@Autowired
    RegisterService registerservice;
	
	
	
//	@Autowired(required=true)
	
    User user=new User();
    Add  add=new Add();
    Valid valid=new Valid();
    
	private JFrame frame;
		private JTextField id;
	    private JTextField firstname;
	    private JTextField lastname;
	    private JTextField middlename;
	    private JTextField email;
	    private JTextField mobilenumber;
	    private JComboBox state;
	    private JTextField city;
	    private JTextField pincode;
	    private JRadioButton gender;
	    private JRadioButton gender1;
	    private JTextField adhar;
	    private JTextField country;
	    private JPasswordField passwordField;
	    private JPasswordField passwordFieldConfirm;
	    int x =0;
	    int source=0;
	    private JButton btnNewButton;
	    int flag=1;
	    
	    private JTextField firstnameerror;
		private JTextField textField;
		 private JPasswordField passwordFieldLogin;
		   private BufferedImage img;
		
	    /**
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registration window = new Registration();
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
	public Registration() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		System.out.println("i am in user");
		
		frame = new JFrame();
		frame.setBounds(450, 190, 1500, 800);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.getContentPane().setBackground(Color.getHSBColor(188, 66, 93));
		frame.setVisible(true);
		
		JLabel lblNewUserRegister = new JLabel(" User Registration");
        lblNewUserRegister.setFont(new Font("Times New Roman", Font.PLAIN, 42));
        lblNewUserRegister.setBounds(495, 51, 325, 50);
        lblNewUserRegister.setBackground(Color.blue);
        frame.getContentPane().add(lblNewUserRegister);

        JLabel lblName = new JLabel("First name*");
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblName.setBounds(50, 150, 150, 50);
        frame.getContentPane().add(lblName);
       
        firstname = new JTextField();
        firstname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        firstname.setBounds(200, 150, 230, 50);
        frame.getContentPane().add(firstname);
        firstname.setColumns(10);
        
        String reg="[a-zA-z]+([ '-][a-zA-Z]+)*.{2,20}\"";
        
        JLabel firsterror = new JLabel("Please Enter first name");
        firsterror.setForeground(Color.RED);
        firsterror.setBounds(210, 211, 220, 14);
        firsterror.setVisible(false);
        frame.getContentPane().add(firsterror);
        
    	firstname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
//				 firstname.setEditable(true);
				 Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				 firstname.setBorder(border);
			}
			@Override
			public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
				if((firstname.getText().length() == 0 )) {
					firsterror.setVisible(true);
					  Border border = BorderFactory.createLineBorder(Color.RED, 1);
					firstname.setBorder(border);
					
	                }
//				valid();
							
			}
		});
    	
    	
    	  firstname.addKeyListener(new KeyAdapter() {
    		  Pattern pattern = Pattern.compile(reg);
              Matcher matcher = pattern.matcher(firstname.getText());
              @Override
              public void keyTyped(KeyEvent e) {
                  char c=e.getKeyChar();
                 
				if((Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE||firstname.getText().length()>=12)) {
                      e.consume();
                  }
                  if((firstname.getText() == null)) {
  					firsterror.setVisible(true);
  					flag=0;
  	                }
  				else {
  					firsterror.setVisible(false);
  					flag=1;
  				}
              }
    	  	@Override
    	  	public void keyReleased(KeyEvent e) {
    	  		 if(!matcher.matches()) {
   					e.consume();
   	                }
//    	  		 valid();
    	  	}
    	  	
          });
       
       
        JLabel lblmiddlename = new JLabel("Middle name");
        lblmiddlename.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblmiddlename.setBounds(500, 150, 200, 50);
        frame.getContentPane().add(lblmiddlename);
       
        middlename = new JTextField();
        middlename.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c=e.getKeyChar();
                if((Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE||middlename.getText().length()>=12)) {
                    e.consume();
                }
        	}
        });
        middlename.setFont(new Font("Tahoma", Font.PLAIN, 32));
        middlename.setBounds(700, 150, 230, 50);
        frame.getContentPane().add(middlename);
        middlename.setColumns(10);
       
       
       
        JLabel lblNewLabel = new JLabel("Last name*");
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblNewLabel.setBounds(1000, 150, 150, 50);
        frame.getContentPane().add(lblNewLabel);
       
        lastname = new JTextField();
        lastname.setFont(new Font("Tahoma", Font.PLAIN, 32));
        lastname.setBounds(1200, 150, 230, 50);
        frame.getContentPane().add(lastname);
        lastname.setColumns(10);
        
        
        JLabel seconderror = new JLabel("please enter last name");
        seconderror.setBounds(1210, 211, 220, 14);
        frame.getContentPane().add(seconderror);
    	seconderror.setVisible(false);
       
    	lastname.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				 Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				 lastname.setBorder(border);
			}
			@Override
			public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
				if((lastname.getText().length() == 0 )) {
					seconderror.setVisible(true);
					Border border = BorderFactory.createLineBorder(Color.RED, 1);
					lastname.setBorder(border);
					seconderror.setForeground(Color.red);

	                }
				
//					valid();
				
			}
		});
    	
    	  lastname.addKeyListener(new KeyAdapter() {
              @Override
              public void keyTyped(KeyEvent e) {
                  char c=e.getKeyChar();
                  if((Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE||lastname.getText().length()>=12)) {
                      e.consume();
                  }
                  if((lastname.getText().toString() == null)) {
  					seconderror.setVisible(true);
  					flag=1;
  	                }
                  
  				else {
  					seconderror.setVisible(false);
  					flag=0;
  				}
//                  valid();
              }
    	  	@Override
    	  	public void keyReleased(KeyEvent e) {
    	  		 char c=e.getKeyChar();
    	  		if((c==KeyEvent.VK_BACK_SPACE)) {
//              	  valid();
                }
    	  	}
          });
         	  
        JLabel lblEmailAddress = new JLabel("Email\r\n address*");
        lblEmailAddress.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblEmailAddress.setBounds(50, 250, 150, 36);
        frame.getContentPane().add(lblEmailAddress);
       
        email = new JTextField();
        email.setFont(new Font("Tahoma", Font.PLAIN, 32));
        email.setBounds(200, 250, 228, 50);
        frame.getContentPane().add(email);
        email.setColumns(10);

        JLabel thirderror = new JLabel("Please Enter valid email id");
        thirderror.setForeground(Color.RED);
        thirderror.setBounds(200, 323, 230, 14);
        frame.getContentPane().add(thirderror);
        thirderror.setVisible(false);
        
        String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        
        email.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				 Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				 email.setBorder(border);
			}
			@Override
			public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
				if((!email.getText().matches(EMAIL_REGEX))) {

					thirderror.setVisible(true);
					  Border border = BorderFactory.createLineBorder(Color.RED, 1);
					email.setBorder(border);
					thirderror.setForeground(Color.red);
					
	                }
				
//					valid();
			}
		});
    	
    	  email.addKeyListener(new KeyAdapter() {
              @Override
              public void keyTyped(KeyEvent e) {
                 
                  if((email.getText() == null)) {
  					thirderror.setVisible(true);
  					flag=0;
  	                }
                  if((!email.getText().matches(EMAIL_REGEX))) {
  					thirderror.setVisible(false);
  					flag=1;
  				}
              }
          });
        
        
       
        JLabel lblMobileNumber = new JLabel("Mobile number*");
        lblMobileNumber.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblMobileNumber.setBounds(500, 250, 150, 26);
        frame.getContentPane().add(lblMobileNumber);

        mobilenumber = new JTextField();
        mobilenumber.setFont(new Font("Tahoma", Font.PLAIN, 32));
        mobilenumber.setBounds(700, 250, 228, 50);
        frame.getContentPane().add(mobilenumber);
        mobilenumber.setColumns(10);
     	
        JLabel fourtherror = new JLabel("Please Enter mobile number");
        fourtherror.setForeground(Color.RED);
        fourtherror.setBounds(700, 323, 230, 14);
        frame.getContentPane().add(fourtherror);
        fourtherror.setVisible(false);
        
        
        mobilenumber.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				 Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				 mobilenumber.setBorder(border);
				
			}
			@Override
			public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
				 if (mobilenumber.getText().length() != 10) {
					 fourtherror.setVisible(true);
					  Border border = BorderFactory.createLineBorder(Color.RED, 1);
					mobilenumber.setBorder(border);
					fourtherror.setForeground(Color.red);
					
                 }
				
//					 valid();
				 
			}
		});

        mobilenumber.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c=e.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)) {
                    e.consume();
                }
                if(mobilenumber.getText().length()!=10) {
                    fourtherror.setVisible(true);
                }
               
                else if(mobilenumber.getText().length()>=10) {
                     JOptionPane.showMessageDialog(lblMobileNumber, "please enter 10 digits only");
                     fourtherror.setVisible(false);
                     e.consume();
                 }
            }
        	@Override
        	public void keyReleased(KeyEvent e) {
        		 if(mobilenumber.getText().length()==10) {
                     fourtherror.setVisible(false);
                 }
//        		 valid();
        	}
        });
       
        
        
        JLabel genderEnter=new JLabel("Gender");
        genderEnter.setFont(new Font("Tahoma",Font.PLAIN,20));
        genderEnter.setBounds(1000,250,123,45);
        frame.getContentPane().add(genderEnter);
     
        gender = new JRadioButton();
        gender.setText("Male");
        gender.setFont(new Font("Tahoma", Font.PLAIN, 20));
        gender.setBounds(1200, 250, 100, 50);
        frame.getContentPane().add(gender);
       
        gender1 = new JRadioButton();
        gender1.setText("Female");
        gender1.setFont(new Font("Tahoma", Font.PLAIN, 20));
        gender1.setBounds(1300, 250, 150, 50);
        frame.getContentPane().add(gender1);
     
        ButtonGroup bg = new ButtonGroup(); 
        bg.add(gender); 
        bg.add(gender1); 
        
        
       
        JLabel lblstate = new JLabel("state");
        lblstate.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblstate.setBounds(50, 350, 99, 24);
        frame.getContentPane().add(lblstate);
    String s1[] = {	"select",
    							"AP",
                                "Arunachal",
                                "Assam",
                                "Bihar",
                                "Chhattisgarh",
                                "Goa",
                                "Gujarat",
                                "Haryana",
                                "HimachalPradesh",
                                "Jammu",
                                "Jharkhand",
                                "Karnataka",
                                "Kerala",
                                "MadhyaPradesh",
                                "Maharashtra",
                                "Manipur",
                                "Meghalaya",
                                "Mizoram",
                                "Nagaland",
                                "Odisha",
                                "Punjab",
                                "Rajasthan",
                                "Sikkim",
                                "Tamil Nadu",
                                "Telangana",
                                "Tripura",
                                "Uttarakhand",
                                "Uttar Pradesh",
                                "West Bengal",
                                "Andaman ",
                                "Chandigarh",
                                "Dadra",
                                "Daman and Diu",
                                "Delhi",
                                "Lakshadweep",
                                "Puducherry"};
       
        state = new JComboBox(s1);
        state.setFont(new Font("Tahoma", Font.PLAIN, 32));
        state.setBounds(200, 350, 250, 50);
        frame.getContentPane().add(state);
        System.out.println(state.getSelectedItem());
       
       
        JLabel lblCity = new JLabel("City");
        lblCity.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblCity.setBounds(500,350,123,45);
        frame.getContentPane().add(lblCity);
       
        city = new JTextField();
        city.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c=e.getKeyChar();
                if((Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE||city.getText().length()>=12)) {
                    e.consume();
                }
        	}
        });
        
        city.setFont(new Font("Tahoma", Font.PLAIN, 32));
        city.setBounds(700, 350, 228, 50);
        frame.getContentPane().add(city);
        city.setColumns(10);
       
        JLabel lblpin = new JLabel("PinCode");
        lblpin.setFont(new Font("Tahoma",Font.PLAIN,20));
        lblpin.setBounds(1000,350,123,45);
        frame.getContentPane().add(lblpin);
       
        pincode = new JTextField();
        pincode.setFont(new Font("Tahoma", Font.PLAIN, 32));
        pincode.setBounds(1200, 350, 228, 50);
        frame.getContentPane().add(pincode);
        pincode.setColumns(10);

        pincode.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c=e.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)) {
                    e.consume();
                }
                else if(pincode.getText().length()>=6) {
                     JOptionPane.showMessageDialog(lblMobileNumber, "please enter 6 digits only");
                     e.consume();
                 }
            }
        });

        JLabel lbladhar = new JLabel("Aadhar*");
        lbladhar.setFont(new Font("Tahoma",Font.PLAIN,20));
        lbladhar.setBounds(50, 450, 150, 24);
        frame.getContentPane().add(lbladhar);
       
        adhar = new JTextField();
        adhar.setFont(new Font("Tahoma", Font.PLAIN, 32));
        adhar.setBounds(200, 450, 228, 50);
        frame.getContentPane().add(adhar);
        adhar.setColumns(10);
       
        
        JLabel fiftherror = new JLabel("Please Enter valid aadhaar");
        fiftherror.setForeground(Color.RED);
        fiftherror.setBounds(204, 525, 226, 14);
        frame.getContentPane().add(fiftherror);
        fiftherror.setVisible(false);
        
        
        adhar.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				 Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				 adhar.setBorder(border);
				
			}
			@Override
			public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
				 if (adhar.getText().length() != 12) {
					 fiftherror.setVisible(true);
					  Border border = BorderFactory.createLineBorder(Color.RED, 1);
					adhar.setBorder(border);
					fiftherror.setForeground(Color.red);
				
                 }
				 
//					valid();
				 
			}
		});
        
        adhar.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
                char c=e.getKeyChar();
                if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE)) {
                    e.consume();
                }
                if(adhar.getText().length()!=12) {
                    fiftherror.setVisible(true);
                }
                else if(adhar.getText().length()>=12) {
                	e.consume();
                     fiftherror.setVisible(false);
                     e.consume();
                 }
            }
        	@Override
        	public void keyReleased(KeyEvent e) {
        		if(adhar.getText().length()==12) {
        			
				try {
					Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3333/project", "root", "password");

	                  PreparedStatement ps = connection.prepareStatement("select adhar from valid where adhar = ?");
	                  ps.setString(1, adhar.getText());
	                  ResultSet rs = ps.executeQuery();
        
	                  if(rs.next()) {
	                	
	                	  source=1;
	                	  
	                  }
	                
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				  if(source==1) {
					  System.out.println("1fff");
					  
                	  JOptionPane.showMessageDialog(null, "user exists");
                	  
                	  source=0;
                  }

        		  fiftherror.setVisible(false);
        		  
//        			valid();
        		  
                  }
        		if(adhar.getText().length()<12) {
        			btnNewButton.setEnabled(false);
        		}
        	}
        });
        
        
        JLabel countrylbl = new JLabel("Country");
        countrylbl.setFont(new Font("Tahoma",Font.PLAIN,20));
        countrylbl.setBounds(500,450,250,45);
        frame.getContentPane().add(countrylbl);
       
        country = new JTextField();
        country.addKeyListener(new KeyAdapter() {
        	@Override
        	public void keyTyped(KeyEvent e) {
        		char c=e.getKeyChar();
                if(((c==KeyEvent.VK_BACK_SPACE)|| c==KeyEvent.VK_DELETE||country.getText().length()>=12)) {
                    e.consume();
                }
        	}
        });
        country.setFont(new Font("Tahoma", Font.PLAIN, 32));
        country.setBounds(700, 450, 228, 50);
        frame.getContentPane().add(country);
        country.setColumns(10);

        
        JLabel lblPassword = new JLabel("Password*");
        lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPassword.setBounds(50, 550, 150, 24);
        frame.getContentPane().add(lblPassword);

        passwordField = new JPasswordField();
        passwordField.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordField.setBounds(200, 550, 228, 50);
        frame.getContentPane().add(passwordField);

        
        JLabel sixtherror = new JLabel("Please enter minimum 8 digit password");
        sixtherror.setForeground(Color.RED);
        sixtherror.setBounds(200, 630, 447, 14);
        frame.getContentPane().add(sixtherror);
        sixtherror.setVisible(false);
        
         String regex = "((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})";
                
        
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(passwordField.getText());
        
        
        passwordField.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				 Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
				 passwordField.setBorder(border);
			}
			@Override
			public void focusLost(FocusEvent e) {
			// TODO Auto-generated method stub
				if( (passwordField.getText().length()<8)) {

					 sixtherror.setVisible(true);
					  Border border = BorderFactory.createLineBorder(Color.RED, 1);
					  passwordField.setBorder(border);
					  sixtherror.setForeground(Color.red);
					 
	                }
			
//					valid();
			}
		
		});
    	
        passwordField.addKeyListener(new KeyAdapter() {
              @Override
              public void keyReleased(KeyEvent e) {
                 
                  if(( passwordField.getText() == null)) {
                	  sixtherror.setVisible(true);
                	  flag=0;
  	                }
                  if((passwordField.getText().length()>=8)) {
                	  sixtherror.setVisible(false);
                	  flag=1;
  				}
              }
          });
        
       
        JLabel lblPasswordConfirm = new JLabel("Confirm Password*");
       
        lblPasswordConfirm.setFont(new Font("Tahoma", Font.PLAIN, 20));
        lblPasswordConfirm.setBounds(500, 550, 200, 24);
        frame.getContentPane().add(lblPasswordConfirm);

        passwordFieldConfirm = new JPasswordField();
        passwordFieldConfirm.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordFieldConfirm.setBounds(700, 550, 228, 50);
        frame.getContentPane().add(passwordFieldConfirm);
       
        JLabel sevenerror = new JLabel("Please Enter same password");
        sevenerror.setForeground(Color.RED);
        sevenerror.setBounds(700, 630, 230, 14);
        frame.getContentPane().add(sevenerror);
        sevenerror.setVisible(false);
        
        

        
        passwordFieldConfirm.addKeyListener(new KeyAdapter() {
            @Override
            public void keyTyped(KeyEvent e) {
               
                if(( passwordFieldConfirm.getText() == null)) {
              	  sevenerror.setVisible(true);
              	  flag=0;
	                }
                if((passwordField.getText().length()<=8)&&(!matcher.matches())) {
              	  sevenerror.setVisible(false);
              	  flag=1;
				}
               
            }
        	@Override
        	public void keyReleased(KeyEvent e) {
        		if(passwordField.getText().equals(passwordFieldConfirm.getText())) {
					 sevenerror.setVisible(false);
//					 valid();
	                }
        		else {
        			sevenerror.setText("password mismatch");
        			sevenerror.setVisible(true);
        		}
//        		 valid();
        	}
        	
        });
        passwordFieldConfirm.addFocusListener(new FocusAdapter() {
        	@Override
        	public void focusLost(FocusEvent e) {
        		if(!passwordField.getText().equals(passwordFieldConfirm.getText())) {

					 sevenerror.setVisible(true);
					  Border border = BorderFactory.createLineBorder(Color.RED, 1);
					  passwordFieldConfirm.setBorder(border);
					  sixtherror.setForeground(Color.red);
					 
	                }
        		if(passwordField.getText().equals(passwordFieldConfirm.getText())) {
        			sevenerror.setVisible(false);
        			Border border = BorderFactory.createLineBorder(Color.BLACK, 1);
   				 passwordFieldConfirm.setBorder(border);
        		}
        		
//			valid();
        	}
        });
      

       
        btnNewButton = new JButton("Register");
     
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton.setBounds(364, 664, 259, 74);
        frame.getContentPane().add(btnNewButton);
        
        JButton reset = new JButton("Reset");
        reset.setFont(new Font("Tahoma", Font.PLAIN, 22));
        reset.setBounds(700, 664, 236, 74);
        frame.getContentPane().add(reset);
        btnNewButton.setEnabled(true);
        
        JButton btnNewButton_1 = new JButton("Sign in");
        btnNewButton_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		frame.dispose();
        		initializeLogin();
        		
        	}
        });
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
        btnNewButton_1.setBounds(1059, 664, 220, 74);
        frame.getContentPane().add(btnNewButton_1);
       

        	
        reset.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	
        	    firstname.setText(null);
        	    lastname.setText(null);
        	    middlename.setText(null);
        	    email.setText(null);
        	     mobilenumber.setText(null);
        	   
        	     city.setText(null);
        	     pincode.setText(null);
        	    
        	     adhar.setText(null);
        	     country.setText(null);
        	     passwordField.setText(null);
        	     passwordFieldConfirm.setText(null);
        	     btnNewButton.setEnabled(false);
        
      
            }
            });

	
    
       
        
//      public void valid() {
            	
//          String firstName = firstname.getText();
//          String lastName = lastname.getText();
//          String middleName = middlename.getText();
//          String emailId = email.getText();
//          String mobileNumber = mobilenumber.getText();
//          String stat= state.getSelectedItem().toString();
//          String cityy= city.getText();
//          String pincodee = pincode.getText();
//          String g=gender.isSelected()?"Male":"Female";
//          String aadhaar=adhar.getText();
//          String pann=pan.getText();
//          String password = passwordField.getText();
//          String confirm = passwordFieldConfirm.getText();
    	
         
//          String EMAIL_REGEX = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
//          String regex = "^(?=.*[0-9])"
//                  + "(?=.*[a-z])(?=.*[A-Z])"
//                  + "(?=.*[@#$%^&+=])";
//          Pattern pattern = Pattern.compile(regex);
//          Matcher matcher = pattern.matcher(password);
          
//          String msg = "" + firstname.getText();
//          msg += " \n";
//          
          
//          if((password.length()<8)&&(!matcher.matches())) {
//          	
//          	flag=0;
//          }
//          else if(!password.equals(confirm)) {
//        	  
//              flag=0;
//           }
//          else if(!(name(firstName)==1)) {
//
//               flag=0;
//               
//            }
//          else if((lastName.length()==0) ) {
//
//               flag=0;
//               }
//         
//           else if((!emailId.matches(EMAIL_REGEX) ) ) {
//
//          		 	flag=0;
//		              
//           }
//           else if (mobileNumber.length() != 10) {
//                
//                   flag=0;
//               }
        

//            if ((adhar.getText().length() != 12)) {
//            
//               flag=0;
//           }
//           else {
//          	 flag=1;
//           }
//                if(flag==0) {
//                 	 btnNewButton.setEnabled(false);
//                }
//                if(flag==1) {
//                	 btnNewButton.setEnabled(true);
//                }
        try {
                btnNewButton.addMouseListener(new MouseAdapter() {
                	@Override
                	public void mouseClicked(MouseEvent e) {
                		  user.setFirstname(firstname.getText());
                          user.setMiddlename(middlename.getText());
                          user.setLastname(lastname.getText());
                          user.setEmailid(email.getText());
                          user.setGender(gender.isSelected()?"Male":"Female");
                          user.setMobilenumber(mobilenumber.getText());
                          
                          
                          add.setEmailid(email.getText());
                          add.setCity(city.getText());
                          add.setState(state.getSelectedItem().toString());
                          add.setPincode(pincode.getText());
                          add.setCountry(country.getText());
                          
                          valid.setEmailid(email.getText());
                          valid.setPassword(passwordField.getText());
                          valid.setConfirm( passwordFieldConfirm.getText());
                          
                          
                          
                         
                          System.out.println(user);
                          registerservice.saveData(user,add,valid);
      
                	  }
                });

      }
      catch(Exception e) {
    	  e.printStackTrace();
      }
      
                   
                
          
               
            

	
//	protected int name(String firstName2) {
//		// TODO Auto-generated method stub
//				int value=1;
//				if(firstName2.toString().length()==0)
//					value=0;
//				return value;
//				// TODO Auto-generated method stub
//				
//	}
}
	void initializeLogin() {
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
		
		passwordFieldLogin = new JPasswordField();
        passwordFieldLogin.setFont(new Font("Tahoma", Font.PLAIN, 32));
        passwordFieldLogin.setBounds(137,143 , 152, 31);
        frame.getContentPane().add(passwordFieldLogin);
        
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
        			if(registerservice.authenticate(valid)) {
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
        		frame.dispose();
        		initialize();
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
