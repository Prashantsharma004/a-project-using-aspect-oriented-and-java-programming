import java.awt.*;
import java.awt.event.*;  
import javax.swing.*;
import javax.swing.table.*;
import javax.swing.Timer.*;
import java.util.*;
import java.lang.*;
import java.io.*;

public class guibank
{
	public static void main(String[] args)
	{
		//System.out.println("Main method Start safely");
		bankstart rpd1 = new bankstart();
		
		rpd1.homepage();
	
		
		//System.out.println("Main method terminated safely");
	}

}

class bankstart
{
	static int ctrforwrongpassword=0;
	static int ctrforwronglogin=0;

	static String namearray[] = new String[14];
	static String usernamearray[] = new String[14]; 
	static int userbalancearray[] = new int[14];
	static String userpasswordarray[] = new String[14];

	static int totaluser=0;
	static boolean block=false;
	static String name;
	static int n=0; 

	static int activeaccno = 0;
	
	static JFrame loginwindow = new JFrame("Welcome to Login Page");
	static JFrame firstwindow = new JFrame("RPD Bank Home Page");
	static JFrame adminloginwindow = new JFrame("Admin Login");
  
	static JTextField idbox = new JTextField();
	static JPasswordField passbox = new JPasswordField(); 
	static JTextField adminidbox = new JTextField();
	static JPasswordField adminpassbox = new JPasswordField();

 static int homepage()
	{

		totaluser=3;
   		name="Ravi";
    	usernamearray[1] = "ravi05";			  //user 1
 		usernamearray[2] = "prashant04";		  //user 2
 		usernamearray[3] = "deepak02";		  //user 3

    	namearray[1] = "Ravi Kumar";
    	namearray[2] = "Prashant Sharma";
    	namearray[3] = "Deepak Kumar";

		userpasswordarray[1] = "pass1";
		userpasswordarray[2] = "pass2";
		userpasswordarray[3] = "pass3";

		userbalancearray[1] = 1200;
		userbalancearray[2] = 800;
		userbalancearray[3] = 600;

		JLabel l1,l2;
		JButton b1,b2,b3,b4,b5;

		Image icon1 = Toolkit.getDefaultToolkit().getImage("E:\\rpdbankicon.png");  
		firstwindow.setIconImage(icon1);  
  
		firstwindow.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		firstwindow.setSize(500,500);
		firstwindow.getContentPane().setBackground(new Color(71,209,71));
	
		firstwindow.setLocationRelativeTo(null);
   		firstwindow.setLayout(new GridLayout(8,1));

       
		l1 = new JLabel("Welcome to RPD Bank",SwingConstants.CENTER);
		l1.setSize(200,200);
    	firstwindow.add(l1);
  
		
		final JLabel l5;
		l5 = new JLabel("#####",SwingConstants.CENTER);
   		l5.setVisible(false);
    	firstwindow.add(l5);  
	     
		b1 = new JButton("Go To Login Page");   
   		 firstwindow.add(b1);
        
   		 b2 = new JButton("Go Admin Login Page");  
   		 firstwindow.add(b2);
             
   		 b3 = new JButton("Find the Branches in Delhi");  
    	firstwindow.add(b3);

    	b4 = new JButton("Contact us Here");  
    	firstwindow.add(b4);

    	b5 = new JButton("EXIT");  
    	firstwindow.add(b5);

      
    	firstwindow.setVisible(true);
    	b1.addActionListener(new ActionListener()
     	 {
        	public void actionPerformed(ActionEvent e)
        	{
        		//firstwindow.setVisible(false );
        		firstwindow.setVisible(false);
        		loginwindow.setVisible(true);
        		login();
        		
        	 //	l5.setVisible(true);
        	 //	l5.setText("Button 1 is clicked");
        		//loginwindow.setVisible(true);       	 
        	}
     	 } );

    	b2.addActionListener( new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		adminlogin();
        	}
        });       
	

    	b5.addActionListener( new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		adminloginwindow.dispose();
        		loginwindow.dispose();
        		firstwindow.dispose();
        		logout();
        		System.out.println("program ends here");
        		System.exit(0);
        	}
        
        });       
		return 0;
	}

 static void adminlogin() 
 	{  
 		
 		//firstwindow.setVisible(false);
    	adminloginwindow.setSize(500,500);
    	adminloginwindow.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
        	//loginwindow.setLocation(20,200);
    	adminloginwindow.setLocationRelativeTo(null);
    	adminloginwindow.getContentPane().setBackground(new Color(255,92,51));
    	adminloginwindow.setLocationRelativeTo(null);
    	adminloginwindow.setLayout(null);
    	adminloginwindow.setResizable(false);

    	final String adminid = "admin" ;
 		final String adminpass= "password";
 		
    	JLabel l1 = new JLabel("Enter Your AdminId");
    	l1.setBounds(150,50,200,30);
    	adminloginwindow.add(l1);

      // final JTextField boxid = new JTextField(" "); 	
    	adminidbox.setText("");     		
    	adminidbox.setBounds(150,100,200,30);
    	adminloginwindow.add(adminidbox);

    	final JLabel l2 = new JLabel("AdminId is not Valid");
    	l2.setBounds(150,130,200,30);
    	l2.setVisible(false);
    	adminloginwindow.add(l2);

    	JLabel l3 = new JLabel("Enter your Password");
       		l3.setBounds(150,180,200,30);
       		adminloginwindow.add(l3);

       	//final JPasswordField boxpass = new JPasswordField(" ");	
       		adminpassbox.setText(""); 
       		adminpassbox.setBounds(150,230,200,30);
       		adminloginwindow.add(adminpassbox);

          final JLabel l4 = new JLabel("wrong password");
          l4.setBounds(150,260,200,30);
          l4.setVisible(false);
          adminloginwindow.add(l4);

       		JButton b1 = new JButton("Login");
       		b1.setBounds(150,310,200,30);
       		adminloginwindow.add(b1); 

       		Cursor cur=new Cursor(Cursor.HAND_CURSOR);
 			b1.setCursor(cur); 
    	
    		JButton closebutton = new JButton("close");
       		closebutton.setBounds(150,370,200,30);
       		adminloginwindow.add(closebutton);

       		closebutton.setCursor(cur);    
 		
       	 b1.addActionListener(new ActionListener()
       		 {
        			public void actionPerformed(ActionEvent e)
        			{       		
        				l4.setVisible(false);
        				l2.setVisible(false);

        				String tempid = adminidbox.getText();
 						String temppass = adminpassbox.getText();


        				if(tempid.equals(adminid)) 
 							{ 	
 								if(temppass.equals(adminpass))				   
 								{
 									System.out.println("You are an Authenticated person");
 									adminpage(); 
 									adminloginwindow.dispose(); //adminpage(); 		
 								
 								}
 								else l4.setVisible(true); adminpassbox.setText("");
 							}


 						else { l2.setVisible(true); System.out.println("ACCESS DENIED");}

 					}
 				
       		 });	


       		 	closebutton.addActionListener(new ActionListener()
        {
        	public void actionPerformed(ActionEvent e)
        	{
        		firstwindow.setVisible(true);

        		adminloginwindow.dispose();
        	}
        });		

 		adminloginwindow.setVisible(true);	
 	}



  static void adminpage()
 	{
 		firstwindow.setVisible(false);
 		final JFrame adminpagewindow = new  JFrame("Hello Sir, welocome to administration page");
        adminpagewindow.setSize(500,500);
       	adminpagewindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        adminpagewindow.getContentPane().setBackground(new Color(255,92,51));
        adminpagewindow.setLocationRelativeTo(null);
        adminpagewindow.setLayout(new GridLayout(8,1));
        // accountmenuwindow.setLayout(null);
        JButton b1,b2,b3,b4,b5,b6,updatebutton;

        JLabel l1,l2;

        l1 = new JLabel("first Label  : ",SwingConstants.CENTER);
        adminpagewindow.add(l1);

        l2 = new JLabel("second Label : ",SwingConstants.CENTER);
        adminpagewindow.add(l2);

        updatebutton = new JButton("Refresh");
        adminpagewindow.add(updatebutton);

        b1 = new JButton("Create A New Account");
        adminpagewindow.add(b1);
        	
        b2 = new JButton("Delete an Account");
        adminpagewindow.add(b2);

        b3 = new JButton("Show User Details");
        adminpagewindow.add(b3);

        	//b4 = new JButton("change details");
        	//adminpagewindow.add(b4);
        
        JButton closebutton = new JButton("ADMIN LOGOUT");
       	adminpagewindow.add(closebutton); 

         b1.addActionListener(new ActionListener()
        	{
        		public void actionPerformed(ActionEvent e)
        		{
        			createnewaccount();
        		}
        	});

        b2.addActionListener(new ActionListener()
        	{
        		public void actionPerformed(ActionEvent e)
        		{
        			deleteaccount();
        		}
        	}); 

        b3.addActionListener(new ActionListener()
        	{
        		public void actionPerformed(ActionEvent e)
        		{
        			showuserdetails();
        		}
        	});

        closebutton.addActionListener(new ActionListener()
        	{
        		public void actionPerformed(ActionEvent e)
        		{
        			firstwindow.setVisible(true);
        			adminpagewindow.dispose();
        		}
       	 	});
        	
        	adminpagewindow.setVisible(true);
 	}

 	static void createnewaccount()
 	{

 		final JFrame newaccwindow = new JFrame("Create a new Account"); 
    	newaccwindow.setSize(500,500);
    	//newaccwindow.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
        	//loginwindow.setLocation(20,200);
    	newaccwindow.setLocationRelativeTo(null);
    	newaccwindow.getContentPane().setBackground(new Color(255,92,51));
    	newaccwindow.setLocationRelativeTo(null);
    	newaccwindow.setLayout(null);
    	newaccwindow.setResizable(false);
    	int xaxis = 150;


    	//final String adminid = "admin" ;
 		//final String adminpass= "password";
 	
    	JLabel namelabel = new JLabel("Enter Your Name");
    	namelabel.setBounds(xaxis,50,200,30);
    	newaccwindow.add(namelabel);

    	final JTextField namebox = new JTextField("");
    	namebox.setBounds(xaxis,80,200,30);
    	newaccwindow.add(namebox);

    	final JLabel l0 = new JLabel("name is must");
    	l0.setVisible(false);
    	l0.setBounds(xaxis,110,200,30);
    	newaccwindow.add(l0);

    	final JLabel l1 = new JLabel("Create a new USERNAME");
    	l1.setBounds(xaxis,150,200,30);
    	newaccwindow.add(l1);

       final JTextField textbox1 = new JTextField(""); 	
    	textbox1.setText("");     		
    	textbox1.setBounds(xaxis,180,200,30);
    	newaccwindow.add(textbox1);

    	final JLabel l2 = new JLabel("USERNAME already exist");
    	l2.setBounds(xaxis,210,200,30);
    	l2.setVisible(false);
    	newaccwindow.add(l2);

    	final JLabel l3 = new JLabel("Create a new Password");
       		l3.setBounds(xaxis,230,200,30);
       		//l3.setVisible(false);
       		newaccwindow.add(l3);

       	final JPasswordField textbox2 = new JPasswordField("");	
       		textbox2.setText(""); 
       		//textbox2.setVisible(false);
       		textbox2.setBounds(xaxis,260,200,30);
       		newaccwindow.add(textbox2);

          final JLabel l4 = new JLabel("weak password");
          l4.setBounds(xaxis,290,200,30);
          l4.setVisible(false);
          newaccwindow.add(l4);

       		final JButton b1 = new JButton("OK");
       		b1.setBounds(xaxis,330,200,30);
       		newaccwindow.add(b1); 
    	
    		JButton closebutton = new JButton("CANCEL");
       		closebutton.setBounds(xaxis,370,200,30);
       		newaccwindow.add(closebutton);    

       		closebutton.addActionListener(new ActionListener()
        	{
        		public void actionPerformed(ActionEvent e)
        		{
        		newaccwindow.dispose();
        		}
        	});


    	

    		b1.addActionListener(new ActionListener()
    			{
    				public void actionPerformed(ActionEvent e)
    					{
    						l0.setVisible(false);
    						l2.setVisible(false);
    						l4.setVisible(false);
    						int temp = 0;
    						boolean alreadyexist = false ;
    						String enteredname = namebox.getText();
    						String enteredid = textbox1.getText();
    						String enteredpass = textbox2.getText();
    						
    						//System.out.println("Entered id length is  :"+enteredid.length());
    						if(enteredid.length()<6){l2.setText("Alteast 6 characters "); l2.setVisible(true); temp++;}
    						if(enteredpass.length()<=4){l4.setVisible(true); temp++;}
    						if(enteredname.length()<=1){l0.setVisible(true); temp++;}

    						//else if(enteredid.length()>=6)
    							//{ 
    								for(int i=1;i<=totaluser;i++)
    								{
    								if(enteredid.equals(usernamearray[i]))
    							 		{	alreadyexist=true;
    							 			l2.setText("USERNAME already exist");
    							 			l2.setVisible(true);
    							 			break;
    							 		}
    								}
    							//}		


    						if((alreadyexist==false)&&(enteredid.length()>=6)&&(temp==0))
    							{	
    								totaluser += 1 ;
    								enteredpass = textbox2.getText();
    								usernamearray[totaluser] = enteredid; 
    								userpasswordarray[totaluser] = enteredpass;
    								namearray[totaluser] = enteredname;
    								userbalancearray[totaluser] = 400;
    								
    								
    								newaccwindow.getContentPane().removeAll();
 									newaccwindow.repaint();

 									newaccwindow.add(l2);
    								l2.setText("Account created succesfully");
    								l2.setVisible(true);
    								//newaccwindow.dispose();
    							}
    					}

    			});

 	  newaccwindow.setVisible(true);	
 	}

 	static void deleteaccount()
 	{
 		final JFrame deleteaccountwindow = new JFrame("Delete account");

 		deleteaccountwindow.setSize(500,500);
 		deleteaccountwindow.getContentPane().setBackground(new Color(255,92,51));
 		deleteaccountwindow.setLocationRelativeTo(null);
 		deleteaccountwindow.setLayout(null);
 		int xaxis = 150;
 		

    	final JLabel l1 = new JLabel("Enter the USERNAME");
    	l1.setBounds(xaxis,150,200,30);
    	deleteaccountwindow.add(l1);

        final JTextField textbox1 = new JTextField(""); 	
    	textbox1.setText("");     		
    	textbox1.setBounds(xaxis,180,200,30);
    	deleteaccountwindow.add(textbox1);

    	final JLabel l2 = new JLabel();
    	l2.setBounds(xaxis,210,200,30);
    	//l2.setVisible(false);
    	deleteaccountwindow.add(l2);
   	
   		final JButton b1 = new JButton("OK");
       	b1.setBounds(xaxis,330,200,30);
       	deleteaccountwindow.add(b1); 
    	
    	JButton closebutton = new JButton("CANCEL");
       	closebutton.setBounds(xaxis,370,200,30);
       	deleteaccountwindow.add(closebutton);  

       
       	b1.addActionListener(new ActionListener()
       		{
       			public void actionPerformed(ActionEvent e)
       			{
       				
       				int temp,acnumber=0;
       				boolean exist=false;
       				String enteredid = textbox1.getText();

       				for(int i=1;i<=totaluser;i++)
    					{
    						if(enteredid.equals(usernamearray[i]))
    							{	
    								exist=true;
    							 	acnumber=i;		   							 		
   							 			break;
    							}
    					}		
    					
    					if(!exist){l2.setText("username not found");}
    					else if(exist)
    						{
    							l2.setText("account nuumber is "+acnumber);

    							totaluser--;
    							for(int i = acnumber;i<=totaluser;i++)
    								{   									
    									usernamearray[i] = usernamearray[i+1];
    									namearray[i] = namearray[i+1];
    									userpasswordarray[i] = userpasswordarray[i+1];
  										userbalancearray[i] = userbalancearray[i+1];  									
    								}
    								System.out.println("account is deleted successfully");
    						
    						}
       			}
       		});


       	closebutton.addActionListener(new ActionListener()
        	{
        		public void actionPerformed(ActionEvent e)
        		{
        			deleteaccountwindow.dispose();
        		}
        	});




 		deleteaccountwindow.setVisible(true);
 	}

 static void showuserdetails()
 	{

 		JFrame f;
 		DefaultTableModel model1;  
 		 
 		JTable table1;    
    	    
    	f=new JFrame("All User Details");
    	//String column[]={"ID","NAME","BALANCE","PASSWORD"};     
    	//String data[][]={ {"101","Amit","670000","strong"},{"102","Jai","780000","rock"},{"101","Sachin","700000","q2w13e"} };    
    	        
    	model1 = new DefaultTableModel();
    	//table1 = new JTable(data,column);

    	table1 = new JTable(model1);
    	model1.addColumn("Sr.NO.");
    	model1.addColumn("NAME");
    	model1.addColumn("USERID");
    	model1.addColumn("BALANCE");		//str = String.valueOf(n);
    	model1.addColumn("PASSWORD");
    	
    	String temp = String.valueOf(totaluser);
    	model1.addRow(new Object[]{"total","user","are :",temp});
    	//model1.addRow(new Object[]{temp,"Sachin","34550","pass786"});

    	int total = 0;
 			//System.out.println("\nTotal user : "+totaluser);
 		for(int i=1;i<=totaluser;i++)
 			{ 
 				String sn = String.valueOf(i);
 				String sbalance = String.valueOf(userbalancearray[i]);

 				//System.out.println(usernamearray[i]+" : "+userbalancearray[i]);
 															
 				model1.addRow(new Object[]{sn,namearray[i],usernamearray[i],sbalance,userpasswordarray[i]});

 				total=total+userbalancearray[i];
 			}
 														
 		//System.out.println("\nTotal money bank have now : " +total); 
 														 

    	table1.setBounds(30,40,200,300);          
    	JScrollPane sp=new JScrollPane(table1);    
    	f.add(sp);          
    	f.setSize(500,400);    
    	f.setVisible(true);    
 	}

 static void login()
    {
        	
          firstwindow.setVisible(false);
        	loginwindow.setSize(500,500);
        	loginwindow.setDefaultCloseOperation( JFrame.DO_NOTHING_ON_CLOSE );
        	//loginwindow.setLocation(20,200);
        	loginwindow.setLocationRelativeTo(null);
       		loginwindow.getContentPane().setBackground(new Color(71,209,71));
       		loginwindow.setLocationRelativeTo(null);
       		loginwindow.setLayout(null);
          loginwindow.setResizable(false);

       		JLabel l1 = new JLabel("Enter Your UserId");
       		l1.setBounds(150,50,200,30);
       		loginwindow.add(l1);

       		idbox.setText("");     		
       		idbox.setBounds(150,100,200,30);
       		loginwindow.add(idbox);

          final JLabel l2 = new JLabel("UserId is not Valid");
          l2.setBounds(150,130,200,30);
          l2.setVisible(false);
          loginwindow.add(l2);

       		JLabel l3 = new JLabel("Enter your Password");
       		l3.setBounds(150,180,200,30);
       		loginwindow.add(l3);

       		passbox.setText(""); 
       		passbox.setBounds(150,230,200,30);
       		loginwindow.add(passbox);

          final JLabel l4 = new JLabel("wrong password");
          l4.setBounds(150,260,200,30);
          l4.setVisible(false);
          loginwindow.add(l4);

       		JButton b1 = new JButton("Login");
       		b1.setBounds(150,310,200,30);
       		loginwindow.add(b1);

       		JButton closebutton = new JButton("close");
       		closebutton.setBounds(150,370,200,30);
       		loginwindow.add(closebutton); 

       		Cursor cur=new Cursor(Cursor.HAND_CURSOR);
 			b1.setCursor(cur); 
 			closebutton.setCursor(cur);     	
       		
       		b1.addActionListener(new ActionListener()
       		 {
        		public void actionPerformed(ActionEvent e)
        			{       		
        				l2.setVisible(false);
                l4.setVisible(false);
                String enteredid = idbox.getText();
        				String enteredpass = passbox.getText();

        				int temp=0;
	 	
 						for(int i=1;i<=totaluser;i++)								// verification of username is done here 
 						{
 							if(enteredid.equals(usernamearray[i])) 
 							{  	
 								temp++;
 								if(enteredpass.equals(userpasswordarray[i]))			//verification of password is done here
 									{ //balancetemp=userbalancearray[i]; 
 									 activeaccno=i;									// active account number is logged person acc number 
 									temp++; 
 									 }
 								break;
 							} 		
 						}

        				if(temp==2){ name = enteredid; loginwindow.dispose(); accountmenu();} 
                else if(temp==0) { l2.setVisible(true);}
                else if(temp==1) { l4.setVisible(true);}     		      			
        			}
       		 });			
			 
       		closebutton.addActionListener(new ActionListener()
       		{
        		public void actionPerformed(ActionEvent e)
        		{
        		firstwindow.setVisible(true);
        		loginwindow.dispose();
        		}
       		});

    }

	private static JLabel showbalance ;

	static void accountmenu()
    {
         // final JFrame accountmenuwindow = new  JFrame("Hello "+name+", Sir");
          final JFrame accountmenuwindow = new  JFrame("Account info "+namearray[activeaccno]);
        	accountmenuwindow.setSize(500,500);
        	accountmenuwindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        	accountmenuwindow.getContentPane().setBackground(new Color(71,209,71));
        	accountmenuwindow.setLocationRelativeTo(null);
        	accountmenuwindow.setLayout(new GridLayout(8,1));
         // accountmenuwindow.setLayout(null);
        	JButton b1,b2,b3,b4,b5,b6,updatebutton;

        	JLabel l1,namelabel,useridlabel;

           	namelabel = new JLabel("Name : "+namearray[activeaccno],SwingConstants.CENTER);
           	accountmenuwindow.add(namelabel);
          //l1 = new JLabel("UserId  : "+name,SwingConstants.CENTER);
        	useridlabel = new JLabel("UserId  : "+usernamearray[activeaccno],SwingConstants.CENTER);

          //l1.setBounds(150,10,300,20);
          accountmenuwindow.add(useridlabel);


          	//showbalance = new JLabel("Balance : "+balancetemp+"Rs ",SwingConstants.CENTER);
          showbalance = new JLabel("Balance : "+userbalancearray[activeaccno]+"Rs ",SwingConstants.CENTER);
          	
          	//showbalance.setText("Balance : "+balancetemp+"Rs");
          	accountmenuwindow.add(showbalance);

         
          	b1 = new JButton("Add Balance");
       	 //	b1.setBounds(150,50,300,40);
        	accountmenuwindow.add(b1);
        	
        	b2 = new JButton("Withdraw Money");
         // b2.setBounds(150,100,300,40);
        	accountmenuwindow.add(b2);

        	//b3 = new JButton("Transfer to Other Person Account");
        	//	b3.setBounds(150,150,300,40);
        	//accountmenuwindow.add(b3);

        	b4 = new JButton("LOGOUT");
        	//b4.setBounds(150,200,300,40);
        	accountmenuwindow.add(b4);       	
	

	        b1.addActionListener(new ActionListener()
	        		{
	        			public void actionPerformed(ActionEvent b1)
	        			{
	        				addbalance();
	        				//l2.setText("Balance : "+balancetemp+"Rs");
	        			}
	        		});

	    	b2.addActionListener(new ActionListener()
        		{
        			public void actionPerformed(ActionEvent b1)
        			{
        				minusbalance();
        			}
        		});



       		b4.addActionListener( new ActionListener()
        	{
        	public void actionPerformed(ActionEvent e)
        	{
        	 logout();	
            firstwindow.setVisible(true);        		
            accountmenuwindow.dispose();
        	}
       		});
        	
        	accountmenuwindow.setVisible(true);
    }

    public static void addbalance()
    {  
    	final JFrame addbalancewindow = new JFrame("ADD BALANCE");

        addbalancewindow.setSize(500,500);
        //addbalancewindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        addbalancewindow.getContentPane().setBackground(new Color(71,209,71));
        addbalancewindow.setLocationRelativeTo(null);
        addbalancewindow.setLayout(new GridLayout(7,1));

        JLabel l1 = new JLabel("ENTER THE AMOUNT YOU WANT TO ADD (IN RUPEES)",SwingConstants.CENTER); addbalancewindow.add(l1);
       final JLabel l2 = new JLabel("",SwingConstants.CENTER); addbalancewindow.add(l2); l2.setVisible(false);
       final JTextField amountfield = new JTextField(""); addbalancewindow.add(amountfield);
       final JButton okbutton = new JButton("OK");      addbalancewindow.add(okbutton);
        JButton closebutton = new JButton("Close");  addbalancewindow.add(closebutton);

    	
    	okbutton.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			String s1 = amountfield.getText();
        		int temp = 0 ;
        				
        				try{temp = Integer.parseInt(s1); 
        				}catch(Exception g){System.out.println("Error while parsing"); 
        									l2.setText("Please enter numbers only");
        									l2.setVisible(true);}

        				if(temp>0){ 	userbalancearray[activeaccno] += temp;
        							//balancetemp+= temp; 
        							//showbalance.setText("Balance : "+balancetemp+"Rs");
        							showbalance.setText("Balance : "+userbalancearray[activeaccno]+"Rs");

        							    				
        							addbalancewindow.dispose();
        						}
    		}

    	});

    	closebutton.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			addbalancewindow.dispose();
    		}

    	});

		addbalancewindow.setVisible(true);
	}
	
	

    public static void minusbalance()
    {
    	

    	final JFrame minusbalancewindow = new JFrame("Withdraw Money");

        minusbalancewindow.setSize(500,500);
        //minusbalancewindow.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        minusbalancewindow.getContentPane().setBackground(new Color(255,26,26));
        minusbalancewindow.setLocationRelativeTo(null);
        minusbalancewindow.setLayout(new GridLayout(7,1));

        JLabel l1 = new JLabel("ENTER THE AMOUNT YOU WANT TO WITHDRAW (IN RUPEES)",SwingConstants.CENTER); minusbalancewindow.add(l1);
       final JLabel l2 = new JLabel("",SwingConstants.CENTER); minusbalancewindow.add(l2); l2.setVisible(false);
       final JTextField amountfield = new JTextField(""); minusbalancewindow.add(amountfield);
       final JButton okbutton = new JButton("OK");      minusbalancewindow.add(okbutton);
        JButton closebutton = new JButton("Close");  minusbalancewindow.add(closebutton);

    	
    	okbutton.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			String s1 = amountfield.getText();
        		int temp = 0 ;
        				
        				try{temp = Integer.parseInt(s1); 
        				}catch(Exception g){System.out.println("Error while parsing"); 
        									l2.setText("Please enter numbers only");
        									l2.setVisible(true);}

        				if(temp<userbalancearray[activeaccno]){ userbalancearray[activeaccno] -= temp ; 
	       							showbalance.setText("Balance : "+userbalancearray[activeaccno]+"Rs");	       								
        							minusbalancewindow.dispose();

    								}
    		}

    	});

    	closebutton.addActionListener(new ActionListener()
    	{
    		public void actionPerformed(ActionEvent e)
    		{
    			minusbalancewindow.dispose();
    		}

    	});

		minusbalancewindow.setVisible(true);

    }
 


    public static void logout()       
 	{
 		
	 	activeaccno=0;
 		//System.out.println("\nYou have Successfully Logout");
 	}


	static aspect accountchoice
		{

			pointcut security() : call(* bankstart.login(..)) ;

			before() : security()
				{
					loginwindow.setVisible(false);
					final JFrame secure = new JFrame("Security CheckPoint by AOP"); 
					secure.setSize(500,500);
					secure.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
					//secure.setLocation(100,100);
					secure.setLocationRelativeTo(null);
					secure.getContentPane().setBackground(new Color(81,220,236));
					
					Random rand = new Random();		
					int n2 =rand.nextInt(9000) + 1000 ;
					
					
					String str = "ok";
 					n =  n2;
 			
 			try{	
 					FileWriter fw=new FileWriter("new otp.txt"); 				
					str = String.valueOf(n);

	   				 for (int i = 0; i < str.length(); i++) 
           			 fw.write(str.charAt(i));
           
       				 fw.close();
       			 //System.out.println("OTP is sent to file ");
       			}catch(Exception e){ System.out.println("file not found");}

       			//System.out.println("\n\nOTP IS : "+n);
       			
       			JLabel l1 = new JLabel("Enter the OTP sent to your registered mobile number",SwingConstants.CENTER);
       			//l1.setBounds(150,50,300,40);
       			secure.add(l1);			
       			
       			final JTextField text = new JTextField();
       			text.setText("");    		
       			//text.setBounds(150,100,200,40);
       			secure.add(text);

       			final JLabel l2 = new JLabel("OTP is not valid");
       			l2.setVisible(false);
       			secure.add(l2); 

       			JButton okbutton = new JButton("CHECK");
       			//okbutton.setBounds(150,200,100,40);
       			secure.add(okbutton); 

       			JButton closebutton = new JButton("Close");
       			//closebutton.setBounds(150,250,100,40);
       			secure.add(closebutton);      			

       			 okbutton.addActionListener(new ActionListener()
					{
        			public void actionPerformed(ActionEvent e)
        			{       		
        				l2.setVisible(false);
        				String s1 = text.getText();
        				int enterednumber = 0 ;
        				
        				try{enterednumber = Integer.parseInt(s1);}catch(Exception g){System.out.println("Error while parsing"); }
        				
 						 if(enterednumber == 0){System.out.println("Please enter the OTP "); }
 						
 						 if(enterednumber == n)
 						 	{   //System.out.println("OTP is correct");                 
 						 		loginwindow.setVisible(true); 					 	
                				secure.dispose();
 						 	}
 						 else { /*System.out.println("WRONG OTP");*/ l2.setVisible(true); secure.setVisible(true); loginwindow.setVisible(false); }  
 						 	      			
        			}
					});

       			 closebutton.addActionListener(new ActionListener()
       			 	{
       			 		public void actionPerformed(ActionEvent e)
       			 		{
       			 			firstwindow.setVisible(true);
       			 			secure.dispose();
       			 		}
       			 	});
       		
					
					secure.setLayout(new GridLayout(7,1));
					//secure.setLayout(new FlowLayout(SwingConstants.CENTER));
					//secure.setLayout(new BoxLayout(secure.getContentPane(),BoxLayout.PAGE_AXIS));
					secure.setVisible(true);
				}
		}



}