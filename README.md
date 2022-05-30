# database

  try {
			    String strDate = "20211215";
				SimpleDateFormat dtFormat = new SimpleDateFormat("yyyyMMdd");
				SimpleDateFormat newDtFormat = new SimpleDateFormat("yyyy-MM-dd-E요일");
				Date formatDate = dtFormat.parse(strDate);
				String strNewDtFormat = newDtFormat.format(formatDate);
				System.out.println("현재 날짜 : " + strNewDtFormat);
		   }
		   catch (ParseException e) {
				e.printStackTrace();
			}


import java.text.SimpleDateFormat;
import java.util.Date;
import java.text.ParseException;


			   jframe.addWindowListener(new WindowAdapter() {
			       public void windowClosing(WindowEvent windowEvent) {
			    	   try {
			    	       con.close();
			    	       System.out.println("프로그램 종료");
			    	   } catch (SQLException a) {
			    	       a.printStackTrace();
			    	   }
			       }
			   });

-새창열기
https://dinae.tistory.com/27


        btn_admin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Part1();
                
            }
        });
        
        btn_login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Part1();
                
            }
        });
