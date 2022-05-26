import java.io.*;
import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class JC20011679M {
   Connection con;

   public JC20011679M() {
	   String Driver="";
	     String url="jdbc:mysql://localhost:3306/hospital?&serverTimezone=Asia/Seoul"; 
	     String userid="hospital";
	     String pwd="hospital";

	     try { 
	       Class.forName("com.mysql.cj.jdbc.Driver");   
	       System.out.println("����̹� �ε� ����");
	     } catch(ClassNotFoundException e) {
	         e.printStackTrace();
	      }
	      
	     try { 
	       System.out.println("�����ͺ��̽� ���� �غ�...");	
	       con=DriverManager.getConnection(url, userid, pwd);
	       System.out.println("�����ͺ��̽� ���� ����");
	     } catch(SQLException e) {
	         e.printStackTrace();
	       }
   }

   public void sqlRun() {
      JFrame jframe = new JFrame();
      // jframe.setLayout(null);
      jframe.setSize(1500, 800);
      jframe.setTitle("20011679 �簡��");
      jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      jframe.setVisible(true);

      Container contentPane = jframe.getContentPane();
      
      JPanel pnWest = new JPanel();
      pnWest.setLayout(new GridLayout(6, 1));
      Button rb = new Button("�ʱ�ȭ");
      Button ib = new Button("�Է�");
      Button ba = new Button("�˻�-������̺�");
      Button b1 = new Button("�˻�1");
      Button b2 = new Button("�˻�2");
      Button b3 = new Button("�˻�3");
      pnWest.add(rb);
      pnWest.add(ib);
      pnWest.add(ba);
      pnWest.add(b1);
      pnWest.add(b2);
      pnWest.add(b3);

      JPanel pnNorth = new JPanel();
      pnNorth.setLayout(new GridLayout(5, 1));
      JPanel pnDoctors = new JPanel();
      JPanel pnNurses = new JPanel();
      JPanel pnPatients = new JPanel();
      JPanel pnTreatments = new JPanel();
      JPanel pnCharts = new JPanel();

      JTextField doc_id = new JTextField(6);
      JTextField major_treat = new JTextField(5);
      JTextField doc_name = new JTextField(4);
      JTextField doc_gen = new JTextField(2);
      JTextField doc_phone = new JTextField(8);
      JTextField doc_email = new JTextField(10);
      JTextField doc_position = new JTextField(4);
      JButton btnDoctors = new JButton("Doctors �Է�");
      pnDoctors.add(new JLabel("doc_id "));
      pnDoctors.add(doc_id);
      pnDoctors.add(new JLabel("major_treat "));
      pnDoctors.add(major_treat);
      pnDoctors.add(new JLabel("doc_name "));
      pnDoctors.add(doc_name);
      pnDoctors.add(new JLabel("doc_gen "));
      pnDoctors.add(doc_gen);
      pnDoctors.add(new JLabel("doc_phone "));
      pnDoctors.add(doc_phone);
      pnDoctors.add(new JLabel("doc_email "));
      pnDoctors.add(doc_email);
      pnDoctors.add(new JLabel("doc_position "));
      pnDoctors.add(doc_position);
      pnDoctors.add(btnDoctors);

      JTextField nur_id = new JTextField(6);
      JTextField major_job = new JTextField(5);
      JTextField nur_name = new JTextField(4);
      JTextField nur_gen = new JTextField(2);
      JTextField nur_phone = new JTextField(8);
      JTextField nur_email = new JTextField(10);
      JTextField nur_position = new JTextField(4);
      JButton btnNurses = new JButton("Nurses �Է�");
      pnNurses.add(new JLabel("nur_id "));
      pnNurses.add(nur_id);
      pnNurses.add(new JLabel("major_job "));
      pnNurses.add(major_job);
      pnNurses.add(new JLabel("nur_name "));
      pnNurses.add(nur_name);
      pnNurses.add(new JLabel("nur_gen "));
      pnNurses.add(nur_gen);
      pnNurses.add(new JLabel("nur_phone "));
      pnNurses.add(nur_phone);
      pnNurses.add(new JLabel("nur_email "));
      pnNurses.add(nur_email);
      pnNurses.add(new JLabel("nur_position "));
      pnNurses.add(nur_position);
      pnNurses.add(btnNurses);

      JTextField patients_pat_id = new JTextField(6);
      JTextField patients_nur_id = new JTextField(5);
      JTextField patients_doc_id = new JTextField(4);
      JTextField patients_pat_name = new JTextField(2);
      JTextField patients_pat_gen = new JTextField(8);
      JTextField patients_pat_jumin = new JTextField(10);
      JTextField patients_pat_addr = new JTextField(4);
      JTextField patients_pat_phone = new JTextField(4);
      JTextField patients_pat_email = new JTextField(4);
      JTextField patients_pat_job = new JTextField(4);
      JButton btnPatients = new JButton("Patients �Է�");
      pnPatients.add(new JLabel("pat_id "));
      pnPatients.add(patients_pat_id);
      pnPatients.add(new JLabel("nur_id "));
      pnPatients.add(patients_nur_id);
      pnPatients.add(new JLabel("doc_id "));
      pnPatients.add(patients_doc_id);
      pnPatients.add(new JLabel("pat_name "));
      pnPatients.add(patients_pat_name);
      pnPatients.add(new JLabel("pat_gen "));
      pnPatients.add(patients_pat_gen);
      pnPatients.add(new JLabel("pat_jumin "));
      pnPatients.add(patients_pat_jumin);
      pnPatients.add(new JLabel("pat_addr "));
      pnPatients.add(patients_pat_addr);
      pnPatients.add(new JLabel("pat_phone "));
      pnPatients.add(patients_pat_phone);
      pnPatients.add(new JLabel("pat_email "));
      pnPatients.add(patients_pat_email);
      pnPatients.add(new JLabel("pat_job "));
      pnPatients.add(patients_pat_job);
      pnPatients.add(btnPatients);

      JTextField treatments_treat_id = new JTextField(6);
      JTextField treatments_pat_id = new JTextField(5);
      JTextField treatments_doc_id = new JTextField(4);
      JTextField treatments_treat_contents = new JTextField(2);
      JTextField treatments_treat_date = new JTextField(8);
      JButton btnTreatments = new JButton("Treatments �Է�");
      pnTreatments.add(new JLabel("treat_id "));
      pnTreatments.add(treatments_treat_id);
      pnTreatments.add(new JLabel("pat_id "));
      pnTreatments.add(treatments_pat_id);
      pnTreatments.add(new JLabel("doc_id "));
      pnTreatments.add(treatments_doc_id);
      pnTreatments.add(new JLabel("treat_contents "));
      pnTreatments.add(treatments_treat_contents);
      pnTreatments.add(new JLabel("treat_date "));
      pnTreatments.add(treatments_treat_date);
      pnTreatments.add(btnTreatments);

      JTextField charts_chart_id = new JTextField(6);
      JTextField charts_treat_id = new JTextField(5);
      JTextField charts_doc_id = new JTextField(4);
      JTextField charts_pat_id = new JTextField(2);
      JTextField charts_nur_id = new JTextField(8);
      JTextField charts_chart_contents = new JTextField(8);
      JButton btnCharts = new JButton("Charts �Է�");
      pnCharts.add(new JLabel("chart_id "));
      pnCharts.add(charts_chart_id);
      pnCharts.add(new JLabel("treat_id "));
      pnCharts.add(charts_treat_id);
      pnCharts.add(new JLabel("doc_id "));
      pnCharts.add(charts_doc_id);
      pnCharts.add(new JLabel("pat_id "));
      pnCharts.add(charts_pat_id);
      pnCharts.add(new JLabel("nur_id "));
      pnCharts.add(charts_nur_id);
      pnCharts.add(new JLabel("chart_contents "));
      pnCharts.add(charts_chart_contents);
      pnCharts.add(btnCharts);

      pnNorth.add(pnDoctors);
      pnNorth.add(pnNurses);
      pnNorth.add(pnPatients);
      pnNorth.add(pnTreatments);
      pnNorth.add(pnCharts);

      JTextArea txt = new JTextArea();
      JScrollPane scrollPane = new JScrollPane(txt, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,   JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);

      contentPane.add(pnWest, "West");
      contentPane.add(pnNorth, "North");
      contentPane.add(scrollPane, "Center");

      jframe.revalidate();
      jframe.repaint();

      btnDoctors.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
           
            if (doc_id.getText().equals("") || major_treat.getText().equals("") || doc_name.getText().equals("")
                  || doc_gen.getText().equals("") || doc_phone.getText().equals("")|| doc_email.getText().equals("")
                  || doc_position.getText().equals("")) {
               JOptionPane.showMessageDialog(null, "���� ��� �Է����ּ���.");
               return;
            }

            try {
               String query = "INSERT INTO Doctors VALUES (" + Integer.parseInt(doc_id.getText()) + ",'" + major_treat.getText() + "','"
                     + doc_name.getText() + "','" + doc_gen.getText() +"','"+ doc_phone.getText() + "','"
                     + doc_email.getText() + "','" + doc_position.getText() + "');";

               Statement stmt = con.createStatement();
               stmt.executeUpdate(query);
               
               JOptionPane.showMessageDialog(null, "Ʃ�� �߰� ����.\n");
               doc_id.setText("");
               major_treat.setText("");
               doc_name.setText("");
               doc_gen.setText("");
               doc_phone.setText("");
               doc_email.setText("");
               doc_position.setText("");
            } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Ʃ�� �߰��� ����.\nError Message: " + ex);
            }
         }
      });

      btnNurses.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 if (nur_id.getText().equals("") || major_job.getText().equals("") || nur_name.getText().equals("")
                     || nur_gen.getText().equals("") || nur_phone.getText().equals("")|| nur_email.getText().equals("")
                     || nur_position.getText().equals("")) {
                  JOptionPane.showMessageDialog(null, "���� ��� �Է����ּ���.");
                  return;
               }

               try {
                  String query = "INSERT INTO Nurses VALUES (" + Integer.parseInt(nur_id.getText()) + ",'" + major_job.getText() + "','"
                        + nur_name.getText() + "','" + nur_gen.getText() +"','"+ nur_phone.getText() + "','"
                        + nur_email.getText() + "','" + nur_position.getText() + "');";

                  Statement stmt = con.createStatement();
                  stmt.executeUpdate(query);
                  
                  JOptionPane.showMessageDialog(null, "Ʃ�� �߰� ����.\n");
                  nur_id.setText("");
                  major_job.setText("");
                  nur_name.setText("");
                  nur_gen.setText("");
                  nur_phone.setText("");
                  nur_email.setText("");
                  nur_position.setText("");
               } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, "Ʃ�� �߰��� ����.\nError Message: " + ex);
               }

         }
      });
      
      btnPatients.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 if (patients_pat_id.getText().equals("") || patients_nur_id.getText().equals("") || patients_doc_id.getText().equals("")
                     || patients_pat_name.getText().equals("") || patients_pat_gen.getText().equals("")|| patients_pat_jumin.getText().equals("")
                     || patients_pat_addr.getText().equals("")|| patients_pat_phone.getText().equals("")|| patients_pat_email.getText().equals("")
                     || patients_pat_job.getText().equals("")) {
                  JOptionPane.showMessageDialog(null, "���� ��� �Է����ּ���.");
                  return;
               }

               try {
                  String query = "INSERT INTO Patients VALUES (" + Integer.parseInt(patients_pat_id.getText()) +","+Integer.parseInt(patients_nur_id.getText())+","
                		+ Integer.parseInt(patients_doc_id.getText())+ ",'" + patients_pat_name.getText() + "','"+patients_pat_gen.getText() + "','"
                        + patients_pat_jumin.getText() + "','" + patients_pat_addr.getText() +"','"+ patients_pat_phone.getText() + "','"
                        + patients_pat_email.getText() + "','" + patients_pat_job.getText() + "');";

                  Statement stmt = con.createStatement();
                  stmt.executeUpdate(query);
                  
                  JOptionPane.showMessageDialog(null, "Ʃ�� �߰� ����.\n");
                  patients_pat_id.setText("");
                  patients_nur_id.setText("");
                  patients_doc_id.setText("");
                  patients_pat_name.setText("");
                  patients_pat_gen.setText("");
                  patients_pat_jumin.setText("");
                  patients_pat_addr.setText("");
                  patients_pat_phone.setText("");
                  patients_pat_email.setText("");
                  patients_pat_job.setText("");

               } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, "Ʃ�� �߰��� ����.\nError Message: " + ex);
               }
           
         }
      });
      btnTreatments.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 if (treatments_treat_id.getText().equals("") || treatments_pat_id.getText().equals("") || treatments_doc_id.getText().equals("")
                     || treatments_treat_contents.getText().equals("") || treatments_treat_date.getText().equals("")) {
                  JOptionPane.showMessageDialog(null, "���� ��� �Է����ּ���.");
                  return;
               }

               try {
                  String query = "INSERT INTO Treatments VALUES (" + Integer.parseInt(treatments_treat_id.getText()) +","
                		+Integer.parseInt(treatments_pat_id.getText()) +","+Integer.parseInt(treatments_doc_id.getText())+ ",'" 
                        + treatments_treat_contents.getText() + "',STR_TO_DATE('" + treatments_treat_date.getText() +"','%Y-%m-%d'));";
                  
                  Statement stmt = con.createStatement();
                  stmt.executeUpdate(query);
                  
                  JOptionPane.showMessageDialog(null, "Ʃ�� �߰� ����.\n");
                  treatments_treat_id.setText("");
                  treatments_pat_id.setText("");
                  treatments_doc_id.setText("");
                  treatments_treat_contents.setText("");
                  treatments_treat_date.setText("");

               } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, "Ʃ�� �߰��� ����.\nError Message: " + ex);
               }
         }
      });
      btnCharts.addActionListener(new ActionListener() {
         public void actionPerformed(ActionEvent e) {
        	 if (charts_chart_id.getText().equals("") || charts_treat_id.getText().equals("") || charts_doc_id.getText().equals("")
                     || charts_pat_id.getText().equals("") || charts_nur_id.getText().equals("")|| charts_chart_contents.getText().equals("")) {
                  JOptionPane.showMessageDialog(null, "���� ��� �Է����ּ���.");
                  return;
               }

               try {
                  String query = "INSERT INTO Charts VALUES ('"+charts_chart_id.getText()+"'," + Integer.parseInt(charts_treat_id.getText()) +","
                		+Integer.parseInt(charts_doc_id.getText()) +","+Integer.parseInt(charts_pat_id.getText())+ "," 
                        + Integer.parseInt(charts_nur_id.getText()) + ",'" + charts_chart_contents.getText() +"');";
                  
                  Statement stmt = con.createStatement();
                  stmt.executeUpdate(query);
                  
                  JOptionPane.showMessageDialog(null, "Ʃ�� �߰� ����.\n");
                  charts_chart_id.setText("");
                  charts_treat_id.setText("");
                  charts_doc_id.setText("");
                  charts_pat_id.setText("");
                  charts_nur_id.setText("");
                  charts_chart_contents.setText("");

               } catch (SQLException ex) {
                  JOptionPane.showMessageDialog(null, "Ʃ�� �߰��� ����.\nError Message: " + ex);
               }
         }
      });
      
      ba.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
       	   txt.setText("");
       	   
       	   try { 
	                 String query="select * from Doctors;"; 
	           	  	 Statement stmt=con.createStatement();
	           	  	 ResultSet rs=stmt.executeQuery(query);
	           	  	 String st="doc_id \tmajor_treat \tdoc_name \tdoc_gen \tdoc_phone \tdoc_email \tdoc_position \n";
	         	  	 txt.append("\n"+st);
	           	  	 while(rs.next()) {
	           	  		 String str = rs.getInt(1)+ "\t"+rs.getString(2)+"\t" +rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\n";
	           	  		 txt.append(str);
	           	  	 }
	           	  	 
	           	  } catch(SQLException a) {
	           	  	   a.printStackTrace();
	           	    }
	           	 try { 
	           		 String query="select * from Nurses;"; 
	           	  	 Statement stmt=con.createStatement();
	           	  	 ResultSet rs=stmt.executeQuery(query);
	           	  String st="nur_id \tmajor_job \tnur_name \tnur_gen \tnur_phone \tnur_email \tnur_position \n";
	         	  	 txt.append("\n"+st);
	           	  	 while(rs.next()) {
	           	  	String str = rs.getInt(1)+ "\t"+rs.getString(2)+"\t" +rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\n";
	           	  		 txt.append(str);
	           	  	 }
	           	  	 
	           	  } catch(SQLException a) {
	           	  	   a.printStackTrace();
	           	    }
	           	 try { 
	                  String query="select * from Patients;"; 
	           	  	 Statement stmt=con.createStatement();
	           	  	 ResultSet rs=stmt.executeQuery(query);
	           	  String st="pat_id \tnur_id \tdoc_id \tpat_name \tpat_gen \tpat_jumin \tpat_addr \tpat_phone \tpat_email \tpat_job \n";
	         	  	 txt.append("\n"+st);
	           	  	 while(rs.next()) {
	           	  	String str = rs.getInt(1)+ "\t"+rs.getInt(2)+"\t" +rs.getInt(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\t"+rs.getString(8)+"\t"+rs.getString(9)+"\t"+rs.getString(10)+"\n";
	           	  		 txt.append(str);
	           	  	 }
	           	  	 
	           	  } catch(SQLException a) {
	           	  	   a.printStackTrace();
	           	    }
	           	try { 
	                  String query="select * from Treatments;"; 
	           	  	 Statement stmt=con.createStatement();
	           	  	 ResultSet rs=stmt.executeQuery(query);
	           	  String st="treat_id \tpat_id \tdoc_id \ttreat_contents \t\ttreat_date \n";
	         	  	 txt.append("\n"+st);
	           	  	 while(rs.next()) {
	           	  	String str = rs.getInt(1)+ "\t"+rs.getInt(2)+"\t" +rs.getInt(3)+"\t"+rs.getString(4)+"\t\t"+rs.getString(5)+"\n";
	           	  		 txt.append(str);
	           	  	 }
	           	  	 
	           	  } catch(SQLException a) {
	           	  	   a.printStackTrace();
	           	    }
	           	try { 
	                  String query="select * from Charts;"; 
	           	  	 Statement stmt=con.createStatement();
	           	  	 ResultSet rs=stmt.executeQuery(query);
	           	  	 String st="chart_id \ttreat_id \tdoc_id \tpat_id \tnur_id \tchart_contents \n";
	         	  	 txt.append("\n"+st);
	           	  	 while(rs.next()) {
	           	  		 String str = rs.getString(1)+ "\t"+rs.getInt(2)+"\t" +rs.getInt(3)+"\t"+ rs.getInt(4)+ "\t"+rs.getInt(5)+"\t"+rs.getString(6)+"\n";
	           	  		 txt.append(str);
	           	  	 }
	           	  	 
	           	  } catch(SQLException a) {
	           	  	   a.printStackTrace();
	           	    }
          }
          
      });
	   
	   b1.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
       	   txt.setText("");
       	   try { 
	           		 String query="select pat_name, pat_addr, pat_phone, treat_contents, treat_date from patients,treatments\r\n"
	           		 		+ "where patients.pat_id=treatments.pat_id and patients.doc_id in (select doc_id from doctors where doc_name='�躴��');"; 
	           	  	 Statement stmt=con.createStatement();
	           	  	 ResultSet rs=stmt.executeQuery(query);
	           	  	 String st=" pat_name \tpat_addr \tpat_phone \ttreat_contents \t\ttreat_date \n";
	         	  	 txt.append("\n"+st);
	           	  	 while(rs.next()) {
	           	  		 String str = rs.getString(1)+ "\t"+rs.getString(2)+"\t" +rs.getString(3)+"\t"+ rs.getString(4)+"\t\t"+ rs.getString(5)+"\n";
	           	  		 txt.append(str);
	           	  	 }
	           	  	 
	           	  } catch(SQLException a) {
	           	  	   a.printStackTrace();
	           	    }
          }
          
      });

	   b2.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
       	   txt.setText("");
       	   try { 
	           		 String query="select * from doctors where doc_id not in(select doc_id from patients);"; 
	           	  	 Statement stmt=con.createStatement();
	           	  	 ResultSet rs=stmt.executeQuery(query);
	           	  	 String st="doc_id \tmajor_treat \tdoc_name \tdoc_gen \tdoc_phone \tdoc_email \tdoc_position \n";
	         	  	 txt.append("\n"+st);
	           	  	 while(rs.next()) {
	           	  	String str = rs.getInt(1)+ "\t"+rs.getString(2)+"\t" +rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\n";
          	  		 txt.append(str);
	           	  	 }
	           	  	 
	           	  } catch(SQLException a) {
	           	  	   a.printStackTrace();
	           	    }
       	   }
          
      });
	   

	   b3.addActionListener(new ActionListener(){
          public void actionPerformed(ActionEvent e){
       	   txt.setText("");
       	   try { 
	           		 String query="select * from doctors where doc_id in ( select doc_id from patients	group by doc_id	\r\n"
	           		 		+ "having count(*) = (select max(c) from(select doc_id, count(*) as c from patients group by doc_id) as result));"; 
	           	  	 Statement stmt=con.createStatement();
	           	  	 ResultSet rs=stmt.executeQuery(query);
	           	  	 String st="doc_id \tmajor_treat \tdoc_name \tdoc_gen \tdoc_phone \tdoc_email \tdoc_position \n";
	         	  	 txt.append("\n"+st);
	           	  	 while(rs.next()) {
	           	  	String str = rs.getInt(1)+ "\t"+rs.getString(2)+"\t" +rs.getString(3)+"\t"+rs.getString(4)+"\t"+rs.getString(5)+"\t"+rs.getString(6)+"\t"+rs.getString(7)+"\n";
          	  		 txt.append(str);
	           	  	 }
	           	  	 
	           	  } catch(SQLException a) {
	           	  	   a.printStackTrace();
	           	    }
          }
          
      });
	   jframe.addWindowListener(new WindowAdapter() {
	       public void windowClosing(WindowEvent windowEvent) {
	    	   try {
	    	       con.close();
	    	       System.out.println("���α׷� ����");
	    	   } catch (SQLException a) {
	    	       a.printStackTrace();
	    	   }
	       }
	   });
	   rb.addActionListener(new ActionListener(){
           public void actionPerformed(ActionEvent e){
        	   txt.setText("");
           	  try { 
           	  txt.append("\n�����͸� �ʱ�ȭ�մϴ�.\n");
           	  Statement stmt=con.createStatement();
           	  stmt.execute("DROP TABLE Charts;");
              stmt.execute("DROP TABLE Treatments;");
              stmt.execute("DROP TABLE Patients;");
              stmt.execute("DROP TABLE Nurses;");
              stmt.execute("DROP TABLE Doctors;");
              stmt.execute("CREATE TABLE Doctors (  doc_id INTEGER NOT NULL,  major_treat VARCHAR(25) NOT NULL,  doc_name VARCHAR(20) NOT NULL,  doc_gen VARCHAR(1) NOT NULL,  doc_phone VARCHAR(15) NULL,  doc_email VARCHAR(50) UNIQUE,  doc_position VARCHAR(20) NOT NULL);");
              stmt.execute("ALTER TABLE Doctors  ADD CONSTRAINT doc_id_pk PRIMARY KEY (doc_id);");
              stmt.execute("CREATE TABLE Nurses (  nur_id INTEGER NOT NULL,  major_job VARCHAR(25) NOT NULL,  nur_name VARCHAR(20) NOT NULL,  nur_gen char(1) NOT NULL,  nur_phone VARCHAR(15) NULL,  nur_email VARCHAR(50) UNIQUE,  nur_position VARCHAR(20) NOT NULL);");
              stmt.execute("ALTER TABLE Nurses  ADD CONSTRAINT nur_id_pk PRIMARY KEY (nur_id);");
              stmt.execute("CREATE TABLE Patients (  pat_id INTEGER NOT NULL,  nur_id INTEGER NOT NULL,  doc_id INTEGER NOT NULL,  pat_name VARCHAR(20) NOT NULL,  pat_gen VARCHAR(1) NOT NULL,  pat_jumin VARCHAR(14) NOT NULL,  pat_addr VARCHAR(100) NOT NULL,  \r\n"
              		+ "pat_phone VARCHAR(15) NULL,  pat_email VARCHAR(50) UNIQUE,  pat_job VARCHAR(20) NOT NULL);");
              stmt.execute("ALTER TABLE Patients  ADD CONSTRAINT pat_id_pk PRIMARY KEY (pat_id);");
              stmt.execute("ALTER TABLE Patients  ADD (CONSTRAINT R_2 FOREIGN KEY (doc_id) REFERENCES Doctors (doc_id));");
              stmt.execute("ALTER TABLE Patients  ADD (CONSTRAINT R_3 FOREIGN KEY (nur_id) REFERENCES Nurses (nur_id));");
              stmt.execute("CREATE TABLE Treatments (  treat_id INTEGER NOT NULL,  pat_id INTEGER NOT NULL,  doc_id INTEGER NOT NULL,  treat_contents VARCHAR(1000) NOT NULL,  treat_date DATE NOT NULL);");
              stmt.execute("ALTER TABLE Treatments  ADD CONSTRAINT treat_pat_doc_id_pk PRIMARY KEY (treat_id, pat_id, doc_id);");
              stmt.execute("ALTER TABLE Treatments  ADD (CONSTRAINT R_5 FOREIGN KEY (pat_id) REFERENCES Patients (pat_id));");
              stmt.execute("ALTER TABLE Treatments  ADD (CONSTRAINT R_6 FOREIGN KEY (doc_id) REFERENCES Doctors (doc_id));");
              stmt.execute("CREATE TABLE Charts (  chart_id VARCHAR(20) NOT NULL,  treat_id INTEGER NOT NULL,  doc_id INTEGER NOT NULL,  pat_id INTEGER NOT NULL,  nur_id INTEGER NOT NULL,  chart_contents VARCHAR(1000) NOT NULL);");
              stmt.execute("ALTER TABLE Charts  ADD CONSTRAINT chart_treat_doc_pat_id_pk PRIMARY KEY (chart_id, treat_id, doc_id, pat_id);");
              stmt.execute("ALTER TABLE Charts  ADD (CONSTRAINT R_4 FOREIGN KEY (nur_id) REFERENCES Nurses (nur_id));");
              stmt.execute("ALTER TABLE Charts  ADD (CONSTRAINT R_7 FOREIGN KEY (treat_id, pat_id, doc_id) REFERENCES Treatments (treat_id, pat_id, doc_id));");
              stmt.execute("INSERT INTO Doctors VALUES(980312, '�Ҿư�', '������', 'M', '010-333-1340', 'ltj@hanbit.com', '����');");
              stmt.execute("INSERT INTO Doctors VALUES(000601, '����', '�ȼ���', 'M', '011-222-0987', 'ask@hanbit.com', '����');");
              stmt.execute("INSERT INTO Doctors VALUES(001208, '�ܰ�', '�����', 'M', '010-333-8743', 'kmj@hanbit.com', '����');");
              stmt.execute("INSERT INTO Doctors VALUES(020403, '�Ǻΰ�', '���¼�', 'M', '019-777-3764', 'lts@hanbit.com', '����');");
              stmt.execute("INSERT INTO Doctors VALUES(050900, '�Ҿư�', '�迬��', 'F', '010-555-3746', 'kya@hanbit.com', '������');");
              stmt.execute("INSERT INTO Doctors VALUES(050101, '����', '������', 'M', '011-222-7643', 'cth@hanbit.com', '������');");
              stmt.execute("INSERT INTO Doctors VALUES(062019, '�Ҿư�', '������', 'F', '010-999-1265', 'jjh@hanbit.com', '������');");
              stmt.execute("INSERT INTO Doctors VALUES(070576, '�Ǻΰ�', 'ȫ�浿', 'M', '016-333-7263', 'hgd@hanbit.com', '������');");
              stmt.execute("INSERT INTO Doctors VALUES(080543, '��缱��', '���缮', 'M', '010-222-1263', 'yjs@hanbit.com', '����');");
              stmt.execute("INSERT INTO Doctors VALUES(091001, '�ܰ�', '�躴��', 'M', '010-555-3542', 'kbm@hanbit.com', '������');");              
              stmt.execute("INSERT INTO Nurses VALUES(050302, '�Ҿư�', '������', 'F', '010-555-8751', 'key@hanbit.com', '����ȣ��');");
              stmt.execute("INSERT INTO Nurses VALUES(050021, '����', '������', 'F', '016-333-8745', 'ysa@hanbit.com', '����ȣ��');");
              stmt.execute("INSERT INTO Nurses VALUES(040089, '�Ǻΰ�', '������', 'M', '010-666-7646', 'sjw@hanbit.com', '����');");
              stmt.execute("INSERT INTO Nurses VALUES(070605, '��缱��', '����ȭ', 'F', '010-333-4588', 'yjh@hanbit.com', '����');");
              stmt.execute("INSERT INTO Nurses VALUES(070804, '����', '���ϳ�', 'F', '010-222-1340', 'nhn@hanbit.com', '����');");
              stmt.execute("INSERT INTO Nurses VALUES(071018, '�Ҿư�', '��ȭ��', 'F', '019-888-4116', 'khk@hanbit.com', '����');");
              stmt.execute("INSERT INTO Nurses VALUES(100356, '�Ҿư�', '�̼���', 'M', '010-777-1234', 'lsy@hanbit.com', '��ȣ��');");
              stmt.execute("INSERT INTO Nurses VALUES(104145, '�ܰ�', '����', 'M', '010-999-8520', 'kh@hanbit.com', '��ȣ��');");
              stmt.execute("INSERT INTO Nurses VALUES(120309, '�Ǻΰ�', '�ڼ���', 'M', '010-777-4996', 'psw@hanbit.com', '��ȣ��');");
              stmt.execute("INSERT INTO Nurses VALUES(130211, '�ܰ�', '�̼���', 'F', '010-222-3214', 'lsy2@hanbit.com', '��ȣ��');");
              stmt.execute("INSERT INTO Patients VALUES(2345, 050302, 980312, '�Ȼ��', 'M', 232345, '����', '010-555-7845', 'ask@ab.com', 'ȸ���');");
              stmt.execute("INSERT INTO Patients VALUES(3545, 040089, 020403, '�輺��', 'M', 543545, '����', '010-333-7812', 'ksn@bb.com', '�ڿ���');");
              stmt.execute("INSERT INTO Patients VALUES(3424, 070605, 080543, '������', 'M', 433424, '�λ�', '010-888-4859', 'ljj@ab.com', 'ȸ���');");
              stmt.execute("INSERT INTO Patients VALUES(7675, 100356, 050900, '�ֱ���', 'M', 677675, '����', '010-222-4847', 'cks@cc.com', 'ȸ���');");
              stmt.execute("INSERT INTO Patients VALUES(4533, 070804, 000601, '���Ѱ�', 'M', 744533, '����', '010-777-9630', 'jhk@ab.com', '����');");
              stmt.execute("INSERT INTO Patients VALUES(5546, 120309, 070576, '������', 'M', 765546, '�뱸', '016-777-0214', 'ywh@cc.com', '�ڿ���');");
              stmt.execute("INSERT INTO Patients VALUES(4543, 070804, 050101, '������', 'M', 454543, '�λ�', '010-555-4187', 'cjj@bb.com', 'ȸ���');");
              stmt.execute("INSERT INTO Patients VALUES(9768, 130211, 091001, '������', 'F', 119768, '����', '010-888-3675', 'ljh@ab.com', '����');");
              stmt.execute("INSERT INTO Patients VALUES(4234, 130211, 091001, '������', 'F', 234234, '����', '010-999-6541', 'onm@cc.com', '�л�');");
              stmt.execute("INSERT INTO Patients VALUES(7643, 071018, 062019, '�ۼ���', 'M', 987643, '����', '010-222-5874', 'ssm@bb.com', '�л�');");
              stmt.execute("INSERT INTO Treatments VALUES(130516023, 2345, 980312, '����, ����', STR_TO_DATE('2013-05-16','%Y-%m-%d'));");
              stmt.execute("INSERT INTO Treatments VALUES(130628100, 3545, 020403, '�Ǻ� Ʈ���� ġ��', STR_TO_DATE('2013-06-28','%Y-%m-%d'));");
              stmt.execute("INSERT INTO Treatments VALUES(131205056, 3424, 080543, '�� ��ũ�� MRI �Կ�', STR_TO_DATE('2013-12-05','%Y-%m-%d'));");
              stmt.execute("INSERT INTO Treatments VALUES(131218024, 7675, 050900, '���̿�', STR_TO_DATE('2013-12-18','%Y-%m-%d'));");
              stmt.execute("INSERT INTO Treatments VALUES(131224012, 4533, 000601, '�忰', STR_TO_DATE('2013-12-24','%Y-%m-%d'));");
              stmt.execute("INSERT INTO Treatments VALUES(140103001, 5546, 070576, '���帧 ġ��', STR_TO_DATE('2014-01-03','%Y-%m-%d'));");
              stmt.execute("INSERT INTO Treatments VALUES(140109026, 4543, 050101, '����', STR_TO_DATE('2014-01-09','%Y-%m-%d'));");
              stmt.execute("INSERT INTO Treatments VALUES(140226102, 9768, 091001, 'ȭ��ġ��', STR_TO_DATE('2014-02-26','%Y-%m-%d'));");
              stmt.execute("INSERT INTO Treatments VALUES(140303003, 4234, 091001, '������ �ܻ�ġ��', STR_TO_DATE('2014-03-03','%Y-%m-%d'));");
              stmt.execute("INSERT INTO Treatments VALUES(140308087, 7643, 062019, '�忰', STR_TO_DATE('2014-03-08','%Y-%m-%d'));");
              stmt.execute("INSERT INTO Charts VALUES('PD13572410', 130516023, 980312, 2345, 050302, '����, ����� ó��');");
              stmt.execute("INSERT INTO Charts VALUES('DM11389132', 130628100, 020403, 3545, 040089, '�Ǻξ� ó��');");
              stmt.execute("INSERT INTO Charts VALUES('RD10023842', 131205056, 080543, 3424, 070605, '�� ��ũ �ǽ�, �߰� �˻� �ʿ�');");
              stmt.execute("INSERT INTO Charts VALUES('PD13581241', 131218024, 050900, 7675, 100356, '���ݰ��� �߰� �˻� �ʿ�');");
              stmt.execute("INSERT INTO Charts VALUES('IM12557901', 131224012, 000601, 4533, 070804, '����� ó��');");
              stmt.execute("INSERT INTO Charts VALUES('DM11400021', 140103001, 070576, 5546, 120309, '���帧 ġ���� ó��');");
              stmt.execute("INSERT INTO Charts VALUES('IM12708224', 140109026, 050101, 4543, 070804, '���� �ɰ�, �߰� �˻� �� ���� ����');");
              stmt.execute("INSERT INTO Charts VALUES('GS17223681', 140226102, 091001, 9768, 130211, 'ȭ��� ó�� �� ����ġ��');");
              stmt.execute("INSERT INTO Charts VALUES('GS17264430', 140303003, 091001, 4234, 130211, '�߰� �������� �ʿ���');");
              stmt.execute("INSERT INTO Charts VALUES('PD13664611', 140308087, 062019, 7643, 071018, '�忰�� ó��');");
              txt.append("\n�����͸� �ʱ�ȭ�߽��ϴ�.\n");
           	  	 
           	  } catch(SQLException a) {
           	  	   a.printStackTrace();
           	    }
           }
       });
      
   }

   public static void main(String args[]) {
      JC20011679M so = new JC20011679M();
      so.sqlRun();
   }
}
