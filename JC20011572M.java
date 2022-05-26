//가희언니바보

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class JC20011572M extends JFrame implements ActionListener {
	private JButton btn1, btn2, btn3, btn4, btn5, btn6;
	private String sql;
	
	private String[] title1 = new String[] {"doc_id","major_treat","doc_name","doc_gen","doc_phone","doc_email","doc_position"};
	private String[][] datas1 = new String[0][7];
	private DefaultTableModel model1 = new DefaultTableModel(datas1, title1);
	private JTable table1 = new JTable(model1);
	private JLabel lblCount1 = new JLabel("개수:+0");
	
	private String[] title2 = new String[] {"nur_id","major_job","nur_name","nur_gen","nur_phone","nur_email","nur_position"};
	private String[][] datas2 = new String[0][7];
	private DefaultTableModel model2 = new DefaultTableModel(datas2, title2);
	private JTable table2 = new JTable(model2);
	private JLabel lblCount2 = new JLabel("개수:+0");
	
	private String[] title3 = new String[] {"pat_id","nur_id","doc_id","pat_name","pat_gen","pat_jumin","pat_addr","pat_phone","pat_email","pat_job"};
	private String[][] datas3 = new String[0][10];
	private DefaultTableModel model3 = new DefaultTableModel(datas3, title3);
	private JTable table3 = new JTable(model3);
	private JLabel lblCount3 = new JLabel("개수:+0");
	
	private String[] title4 = new String[] {"treat_id","pat_id","doc_id","treat_contents","treat_date"};
	private String[][] datas4 = new String[0][5];
	private DefaultTableModel model4 = new DefaultTableModel(datas4, title4);
	private JTable table4 = new JTable(model4);
	private JLabel lblCount4 = new JLabel("개수:+0");
	
	private String[] title5 = new String[] {"chart_id","treat_id","doc_id","pat_id","nur_id","chart_contents"};
	private String[][] datas5 = new String[0][6];
	private DefaultTableModel model5 = new DefaultTableModel(datas5, title5);
	private JTable table5 = new JTable(model5);
	private JLabel lblCount5 = new JLabel("개수:+0");

    private Connection conn;
    private PreparedStatement pstmt;
    private ResultSet rs;

    public JC20011572M() {

        initLayout();

        accDb();

        setTitle("20011572/박유진");
        setBounds(500, 500, 700, 650);
        setVisible(true);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent arg0) {
                int re = JOptionPane.showConfirmDialog(JC20011572M.this, "종료할까요?", "종료",
                        JOptionPane.OK_CANCEL_OPTION);

                if (re == JOptionPane.OK_OPTION) {
                    System.exit(0);
                } else {
                    setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
                }
            }
        });
    }

    private void initLayout() {
    	btn1 = new JButton("초기화 버튼");
        btn2 = new JButton("입력 버튼");
        btn3 = new JButton("검색-모든테이블 버튼");
        btn4 = new JButton("검색1");
        btn5 = new JButton("검색2");
        btn6 = new JButton("검색3");
        
        btn1.addActionListener(this);
        btn2.addActionListener(this);
        btn3.addActionListener(this);
        btn4.addActionListener(this);
        btn5.addActionListener(this);
        btn6.addActionListener(this);

        JPanel panel = new JPanel();
        panel.add(btn1);
        panel.add(btn2);
        panel.add(btn3);
        panel.add(btn4);
        panel.add(btn5);
        panel.add(btn6);
        
        add("North",panel);
    }

    private void accDb() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (Exception e) {
            System.out.println("accDb : " + e);
            return;
        }
    }

    private void displayData(DefaultTableModel model, JLabel lblCount, String[] title) {
        model.setNumRows(0);
        try {
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/madang?&serverTimezone=Asia/Seoul", "hospital", "hospital");
            pstmt = conn.prepareStatement(sql);
            rs = pstmt.executeQuery();
            int count = 0;

            while (rs.next()) {
            	String[] imsi = new String[title.length];
            	for(int i=0;i<title.length;i++) {
            		imsi[i] = rs.getString(title[i]);
            	}
                model.addRow(imsi);
                count++;
            }
            lblCount.setText("개수 :" + count);
        } catch (Exception e) {
            System.out.println("에러 발생 : " + e);
        } finally {
            try {

                if (rs != null)
                    rs.close();
                if (pstmt != null)
                    pstmt.close();
                if (conn != null)
                    conn.close();
            } catch (Exception e2) {

            }
        }
    }

    @Override
    public void actionPerformed(ActionEvent arg0) {
        if(arg0.getSource() == btn2) {
            InsertForm insertForm = new InsertForm(this);
            
    }else if(arg0.getSource() == btn3 || arg0.getSource() == btn1) {
    	JPanel pn = new JPanel();
    	// 테이블의 열폭 조절
    	table1.getColumnModel().getColumn(0).setPreferredWidth(50);
        table1.getColumnModel().getColumn(1).setPreferredWidth(100);
        JScrollPane scrollPane1 = new JScrollPane(table1);
        pn.add(scrollPane1);
        pn.add(lblCount1);
		
		sql = "select * from doctors";
		displayData(model1, lblCount1, title1);
		
		table2.getColumnModel().getColumn(0).setPreferredWidth(50);
        table2.getColumnModel().getColumn(1).setPreferredWidth(100);
        JScrollPane scrollPane2 = new JScrollPane(table2);
        pn.add(scrollPane2);
        pn.add(lblCount2);
        
		sql = "select * from Nurses";
		displayData(model2, lblCount2, title2);
		
		table3.getColumnModel().getColumn(0).setPreferredWidth(50);
        table3.getColumnModel().getColumn(1).setPreferredWidth(100);
        JScrollPane scrollPane3 = new JScrollPane(table3);
        pn.add(scrollPane3);
        pn.add(lblCount3);
        
		sql = "select * from Patients";
		displayData(model3, lblCount3, title3);
		
		table4.getColumnModel().getColumn(0).setPreferredWidth(50);
        table4.getColumnModel().getColumn(1).setPreferredWidth(100);
        JScrollPane scrollPane4 = new JScrollPane(table4);
        pn.add(scrollPane4);
        pn.add(lblCount4);
        
		sql = "select * from Treatments";
		displayData(model4, lblCount4, title4);
		
		table5.getColumnModel().getColumn(0).setPreferredWidth(50);
        table5.getColumnModel().getColumn(1).setPreferredWidth(100);
        JScrollPane scrollPane5 = new JScrollPane(table5);
        pn.add(scrollPane5);
        pn.add(lblCount5);
        
		sql = "select * from Charts";
		displayData(model5, lblCount5, title5);
		

		JScrollPane scrollPane = new JScrollPane(pn);
		add("Center",scrollPane);
		setVisible(true);        
        
    }else if(arg0.getSource() == btn4) { 
    	String[] title = new String[] {"pat_name","pat_addr","pat_phone","treat_contents","treat_date"};
		String[][] datas = new String[0][5];
		DefaultTableModel model = new DefaultTableModel(datas, title);
		JTable table = new JTable(model);
		JLabel lblCount = new JLabel("개수:+0");
		

    	table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        JScrollPane scrollPane = new JScrollPane(table);
        add("Center",scrollPane);
        add("South",lblCount);
		
		sql = "SELECT pat_name,pat_addr,pat_phone,treat_contents,treat_date\r\n"
				+ "FROM patients, treatments\r\n"
				+ "WHERE patients.pat_id=treatments.pat_id\r\n"
				+ "and patients.doc_id=(SELECT doc_id from doctors where doctors.doc_name='김병만');";
		displayData(model, lblCount, title);
    }else if(arg0.getSource() == btn5) {
		String[] title = new String[] {"doc_id","major_treat","doc_name","doc_gen","doc_phone","doc_email","doc_position"};
		String[][] datas = new String[0][7];
		DefaultTableModel model = new DefaultTableModel(datas, title);
		JTable table = new JTable(model);
		JLabel lblCount = new JLabel("개수:+0");
		

    	table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        JScrollPane scrollPane = new JScrollPane(table);
        add("Center",scrollPane);
        add("South",lblCount);
		
		sql = "SELECT *\r\n"
				+ "FROM doctors\r\n"
				+ "WHERE doc_id NOT IN (SELECT doc_id\r\n"
				+ "				FROM patients);";
		displayData(model, lblCount, title);
	}
	else if(arg0.getSource() == btn6) {
		String[] title = new String[] {"doc_id","major_treat","doc_name","doc_gen","doc_phone","doc_email","doc_position"};
		String[][] datas = new String[0][7];
		DefaultTableModel model = new DefaultTableModel(datas, title);
		JTable table = new JTable(model);
		JLabel lblCount = new JLabel("개수:+0");
		
		// 테이블의 열폭 조절
    	table.getColumnModel().getColumn(0).setPreferredWidth(30);
        table.getColumnModel().getColumn(1).setPreferredWidth(100);
        JScrollPane scrollPane = new JScrollPane(table);
        add("Center",scrollPane);
        add("South",lblCount);
		
		sql = "SELECT *\r\n"
				+ "FROM doctors\r\n"
				+ "WHERE doc_id = (SELECT doc_id\r\n"
				+ "				FROM ((SELECT doc_id, MAX(tb.cnt)\r\n"
				+ "						FROM (SELECT doc_id, COUNT(*) as cnt\r\n"
				+ "								FROM patients\r\n"
				+ "							group by doc_id\r\n"
				+ "							order by cnt DESC) tb)) tb1);";
		displayData(model, lblCount, title);
	}
    }

    // 상품 추가를 위한 내부 클래스 생성
    class InsertForm extends JDialog implements ActionListener{
        JTextField name = new JTextField();
        JTextField data1 = new JTextField();
        JTextField data2 = new JTextField();
        JTextField data3 = new JTextField();
        JTextField data4 = new JTextField();
        JTextField data5 = new JTextField();
        JTextField data6 = new JTextField();
        JTextField data7 = new JTextField();
        JButton btnOk = new JButton("등록");
        JButton btnCancel = new JButton("취소");
        
        public InsertForm(JFrame frame) {
            super(frame, "데이터 추가");
            setModal(true);
        
            // 추가 화면 디자인
            JPanel pn1 = new JPanel(new GridLayout(3,2));
            pn1.add(new JLabel("table name"));
            pn1.add(name);
            pn1.add(new JLabel("id"));
            pn1.add(data1);
            pn1.add(new JLabel("major"));
            pn1.add(data2);
            pn1.add(new JLabel("name"));
            pn1.add(data3);
            pn1.add(new JLabel("gen"));
            pn1.add(data4);
            pn1.add(new JLabel("phone"));
            pn1.add(data5);
            pn1.add(new JLabel("email"));
            pn1.add(data6);
            pn1.add(new JLabel("position"));
            pn1.add(data7);
            pn1.add(btnOk);
            btnOk.addActionListener(this);
            btnCancel.addActionListener(this);
            
            add("North", new JLabel("병원데이터 입력"));
            add("Center", pn1);
            
            setBounds(500,500,400,400);
            setVisible(true);
            
            addWindowListener(new WindowAdapter() {
                @SuppressWarnings("unused")
				public void WindowClosing(WindowEvent arg0) {
                    dispose();
                }
            });
            
        }

        @Override
        public void actionPerformed(ActionEvent arg0) {
            if(arg0.getSource() == btnOk) { 
            	
            if(name.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "표제목 입력!");
                name.requestFocus();
                return;
            }
            if(data1.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "data1 입력!");
                data1.requestFocus();
                return;
            }
            if(data2.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "data2 입력!");
                data2.requestFocus();
                return;
            }
            if(data3.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "data3 입력!");
                data3.requestFocus();
                return;
            }
            if(data4.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "data4 입력!");
                data4.requestFocus();
                return;
            }
            if(data5.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "data5 입력!");
                data5.requestFocus();
                return;
            }
            if(data6.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "data6 입력!");
                data6.requestFocus();
                return;
            }
            if(data7.getText().equals("")) {
                JOptionPane.showMessageDialog(this, "data7 입력!");
                data7.requestFocus();
                return;
            }

            
            try {
                conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/hospital?&serverTimezone=Asia/Seoul", "hospital", "hospital");
                
                String sql1 = "update Nurses"+ "set nur_id=?, major_job=?, nur_name=?, nur_gen=?, nur_phone=?, nur_email=?, nur_position=?";

                if(name.getText() == "Doctors") {
                	sql1 = "update Doctors set doc_id=?, major_treat=?, doc_name=?, doc_gen=?, doc_phone=?, doc_email=?, doc_position=?";
                }
                else if(name.getText()=="Nurses") {
                	sql1 = "update Nurses"+ "set nur_id=?, major_job=?, nur_name=?, nur_gen=?, nur_phone=?, nur_email=?, nur_position=?";
                }
                pstmt = conn.prepareStatement(sql1);
                pstmt.setString(1, data1.getText().trim());
                pstmt.setString(2, data2.getText().trim());
                pstmt.setString(3, data3.getText().trim());
                pstmt.setString(4, data4.getText().trim());
                pstmt.setString(5, data5.getText().trim());
                pstmt.setString(6, data6.getText().trim());
                pstmt.setString(7, data7.getText().trim());
                if(pstmt.executeUpdate() > 0) {
                    JOptionPane.showMessageDialog(this, "등록성공");
                }else {
                    JOptionPane.showConfirmDialog(this, "data 실패");
                }                
                                
            } catch (Exception e) {
                System.out.println("data 등록 실패 : " + e);
                }finally {
                    try {
                        if (rs != null)
                            rs.close();
                        if (conn != null)
                            conn.close();
                    } catch (Exception e2) {
                        // TODO: handle exception
                    }
                }
            
            
            
            }else if(arg0.getSource() == btnCancel)    { //작업 취소
                dispose();
                        
        }
        }
    }
    
    public static void main(String[] args) {
        new JC20011572M();
    }
}
