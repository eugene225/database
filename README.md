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
