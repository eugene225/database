# Database Project

### 요구사항
1. 영화에 대해서는 영화번호, 영화명, 상영시간, 상영등급, 감독명, 배우명, 장르, 영화소개 및 개봉일 정보를 저장한다. 모든 영화는 1개 이상에서 4개 이하의 상영일정을 가진다.
2. 상영일정에 대해서는 상영일정번호, 영화번호, 상영관번호, 상영시작일, 상영요일, 상영회차 및 상영시작시간 정보를 저장한다.
3. 상영관에 대해서는 상영관번호, 좌석수 및 상영관사용여부를 저장한다. 각 상영관에는 1개 이상의 상영일정을 배정한다.
4. 티켓에 대해서는 티켓번호, 상영일정번호, 상영관번호, 좌석번호, 예매번호, 발권여부, 표준가격 및 판매가격 정보를 저장한다. 각 티켓은 1개의 좌석과 연결된다.
5. 좌석에 대해서는 좌석번호, 상영관번호 및 좌석사용여부를 저장한다.
6. 회원고객에 대해서는 회원아이디, 고객명, 휴대폰번호 및 전자메일주소를 저장한다. 
7. 예매정보에 대해서는 예매번호, 결제방법, 결제상태, 결제금액, 회원아이디 및  결제일자를 저장한다.
8. 영화예매 사이트는 관리자 혹은 회원으로서 이용이 가능하다

### DBMS, 개발언어 및 개발도구
● DBMS : MySQL 8.0.15 혹은 8.0.15 이상 버전

● 개발언어 : JAVA (Oracle JAVA SE 11 이상)

● 개발도구 : Eclipse 

* * *					


-새창열기
https://dinae.tistory.com/27

`
if(btn_movie_info.isSelected()) {
					if (tf_movie_id.getText().equals("") || tf_movie_name.getText().equals("") || tf_movie_runtime.getText().equals("")
		                     || tf_movie_grade.getText().equals("") || tf_movie_director.getText().equals("") || tf_movie_actor.getText().equals("")
		                     || tf_movie_genre.getText().equals("") || tf_movie_date.getText().equals("") || tf_movie_intro.getText().equals("")) {
		                  JOptionPane.showMessageDialog(null, "값을 모두 입력해주세요.");
		                  return;
		               }

		               try {
		                  String query = "INSERT INTO movie_info VALUES (" + Integer.parseInt(tf_movie_id.getText()) +", '"
		                		+tf_movie_name.getText() +"',"+Integer.parseInt(tf_movie_runtime.getText())+ ",'" 
		                        + tf_movie_grade.getText() + "', '" + tf_movie_director.getText() + "', '" + tf_movie_actor.getText()+ "', '"
		                        + tf_movie_genre.getText() + "', STR_TO_DATE('" + tf_movie_date.getText() + "','%Y-%m-%d'), '"
		                        + tf_movie_intro.getText() + "');";
		                  
		                  Statement stmt = con.createStatement();
		                  stmt.executeUpdate(query);
		                  
		                  JOptionPane.showMessageDialog(null, "튜플 추가 성공.\n");
		                  tf_movie_id.setText("");
		                  tf_movie_name.setText("");
		                  tf_movie_runtime.setText("");
		                  tf_movie_grade.setText("");
		                  tf_movie_director.setText("");
		                  tf_movie_actor.setText("");
		                  tf_movie_genre.setText("");
		                  tf_movie_date.setText("");
		                  tf_movie_intro.setText("");

		               } catch (SQLException ex) {
		                  JOptionPane.showMessageDialog(null, "튜플 추가에 실패.\nError Message: " + ex);
		               }
				}else if(btn_room.isSelected()) {
					if (tf_room_id.getText().equals("") || tf_room_seat.getText().equals("") || tf_room_use.getText().equals("")) {
		                  JOptionPane.showMessageDialog(null, "값을 모두 입력해주세요.");
		                  return;
		            }

	               try {
	                  String query = "INSERT INTO room VALUES (" + Integer.parseInt(tf_room_id.getText()) +", "
	                		+ Integer.parseInt(tf_room_seat.getText()) + ", '" + tf_room_use.getText() + "');";
	                  
	                  Statement stmt = con.createStatement();
	                  stmt.executeUpdate(query);
	                  
	                  JOptionPane.showMessageDialog(null, "튜플 추가 성공.\n");
	                  tf_room_id.setText("");
	                  tf_room_seat.setText("");
	                  tf_room_use.setText("");

	               } catch (SQLException ex) {
	                  JOptionPane.showMessageDialog(null, "튜플 추가에 실패.\nError Message: " + ex);
	               }
				}else if(btn_customer.isSelected()) {
					if (tf_customer_id.getText().equals("") || tf_customer_name.getText().equals("") || tf_customer_phone.getText().equals("")
							|| tf_customer_mail.getText().equals("")) {
		                  JOptionPane.showMessageDialog(null, "값을 모두 입력해주세요.");
		                  return;
		            }

	               try {
	                  String query = "INSERT INTO customer VALUES ('" + tf_customer_id.getText() +"', '"
	                		+ tf_customer_name.getText() + "', '" + tf_customer_phone.getText() + "', '" + tf_customer_mail.getText() + "');";
	                  
	                  Statement stmt = con.createStatement();
	                  stmt.executeUpdate(query);
	                  
	                  JOptionPane.showMessageDialog(null, "튜플 추가 성공.\n");
	                  tf_customer_id.setText("");
	                  tf_customer_name.setText("");
	                  tf_customer_phone.setText("");
	                  tf_customer_mail.setText("");

	               } catch (SQLException ex) {
	                  JOptionPane.showMessageDialog(null, "튜플 추가에 실패.\nError Message: " + ex);
	               }
				}else if(btn_book.isSelected()) {
					if (tf_book_id.getText().equals("") || tf_book_payway.getText().equals("") || tf_book_state.getText().equals("")
							|| tf_book_total.getText().equals("") || tf_book_customer_id.getText().equals("") || tf_book_date.getText().equals("") ) {
		                  JOptionPane.showMessageDialog(null, "값을 모두 입력해주세요.");
		                  return;
		            }

	               try {
	                  String query = "INSERT INTO book VALUES (" + Integer.parseInt(tf_book_id.getText()) + ", '"
	                		+ tf_book_payway.getText() + "', '" + tf_book_state.getText() + "', " + Integer.parseInt(tf_book_total.getText())
	                		+ ", '" + tf_book_customer_id.getText() + "', STR_TO_DATE('" + tf_book_date.getText() + "','%Y-%m-%d'));";
	                  
	                  Statement stmt = con.createStatement();
	                  stmt.executeUpdate(query);
	                  
	                  JOptionPane.showMessageDialog(null, "튜플 추가 성공.\n");
	                  tf_book_id.setText("");
	                  tf_book_payway.setText("");
	                  tf_book_state.setText("");
	                  tf_book_total.setText("");
	                  tf_book_customer_id.setText("");
	                  tf_book_date.setText("");

	               } catch (SQLException ex) {
	                  JOptionPane.showMessageDialog(null, "튜플 추가에 실패.\nError Message: " + ex);
	               }
				}
				
				
https://hiworldbye.tistory.com/25



			setLayout(new GridBagLayout());
	        GridBagConstraints gbc = new GridBagConstraints();
	        gbc.fill = GridBagConstraints.BOTH;
	        gbc.weightx = 1.0;
	        gbc.weighty = 0.5;
			setSize(650,700);
	        setVisible(true);
