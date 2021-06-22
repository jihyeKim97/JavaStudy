package db.mgr;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import db.data.Member;
import db.data.Order;
import db.util.OracleDBUtil;

public class OrderDBMgr {
	
	Connection conn;
	
	public OrderDBMgr() {
		this.conn = OracleDBUtil.getConn();
	}
	
	// 로그인한 회원액터가 신규 주문 하나를 추가할 수 있다.
	public boolean insertNewOrder(Order od) {
		if(conn != null && od != null) {
//			String sql = 
//			"INSERT INTO orders " + 
//			" VALUES(ORDER_SEQ.nextval, "
//			+ "'ON32H1uf9F', 1, 'elsa', " + 
//			" 4, '바닐라라떼2', sysdate, 2, 9000)";
			String sql = 
		 	  "INSERT INTO orders " + 
			  " VALUES(ORDER_SEQ.nextval, "
	    	+ " ?, ?, ?, ?, ?, sysdate, ?, ?)";
			try {
				PreparedStatement pstmt 
						= conn.prepareStatement(sql);
				pstmt.setString(1, od.getOrderNum());
				pstmt.setInt(2,od.getMemberId());
				pstmt.setString(3,od.getMemberLogin());
				pstmt.setInt(4,od.getFoodId());
				pstmt.setString(5,od.getFoodName());
				pstmt.setInt(6,od.getUnit());
				pstmt.setInt(7,od.getTotalPrice());
				int r = pstmt.executeUpdate();
				if( r == 1 ) {
					System.out.println("DB에 주문 record가 잘 생성!");
					return true;
				} else {
					System.out.println("DB에 주문 record 생성 실패..");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	// 관리자는 모든 주문 리스트를 조회할 수 있다.
	public ArrayList<Order> selectAllOrders() {
		if( this.conn != null ) {
			ArrayList<Order> odList = new ArrayList<>();
			String sql = 
				"select * from orders ORDER BY ordered_at desc";
			try {
				Statement stmt =  conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {
					Order od = new Order(
						rs.getInt("id"),
						rs.getString("order_num"), 
						rs.getInt("member_id"),
						rs.getString("member_login"), 
						rs.getInt("food_id"),
						rs.getString("food_name"), 
						rs.getDate("ordered_at"),
						rs.getInt("unit"),
						rs.getInt("total_price"));
					odList.add(od);
				}
				System.out.println("DBMgr: 주문 조회 건수 => "
						+ odList.size());
				return odList;
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		} else {
			System.out.println("DB 통신 에러!!");
		}
		return null;
	}
	
	// 회원은 자신이 주문한 모든 주문 리스트를 조회할 수 있다.
	
	// 특정 음식메뉴를 기준으로 모든 주문 리스트를 조회할 수 있다.
	
	// 특정 주문번호<UQ>로 하나의 주문을 상세조회 할 수 있다.
	
	// 주문 관리번호<PK>로 하나의 주문을 상세조회 할 수 있다.

	// .... 
	
	public static void main(String[] args) {
		OrderDBMgr odMgr = new OrderDBMgr();
				
		System.out.println("-- 기존 주문 리스트 --");
		ArrayList<Order> odList = odMgr.selectAllOrders();
		for (Order order : odList) {
			System.out.println(order);
		}
		Order tOd1 = new Order(
				Order.generateOrderNumber(),
				2, "anna", 
				9, "큐브라떼", 5400);
		if( odMgr.insertNewOrder(tOd1) ) 
			System.out.println("anna 주문 성공!!");
		
		System.out.println("-- 갱신된 문 리스트 --");
		odList = odMgr.selectAllOrders();
		for (Order order : odList) {
			System.out.println(order);
		}
		
		OracleDBUtil.endConnection();
	}

}


/*
DB 접속 성공! Wed May 26 11:49:47 KST 2021
-- 기존 주문 리스트 --
DBMgr: 주문 조회 건수 => 3
Order [id=4, orderNum=ONuzKEqsMz, memberId=2, memberLogin=anna, foodId=9, foodName=큐브라떼, orderedAt=2021-05-26, unit=1, totalPrice=5400]
Order [id=3, orderNum=ONChTseeLb, memberId=2, memberLogin=anna, foodId=9, foodName=큐브라떼, orderedAt=2021-05-26, unit=1, totalPrice=5400]
Order [id=1, orderNum=ON32H1uf9F, memberId=1, memberLogin=elsa, foodId=4, foodName=바닐라라떼, orderedAt=2021-05-26, unit=2, totalPrice=9000]
DB에 주문 record가 잘 생성!
anna 주문 성공!!
-- 갱신된 문 리스트 --
DBMgr: 주문 조회 건수 => 4
Order [id=5, orderNum=ONDg7IxU97, memberId=2, memberLogin=anna, foodId=9, foodName=큐브라떼, orderedAt=2021-05-26, unit=1, totalPrice=5400]
Order [id=4, orderNum=ONuzKEqsMz, memberId=2, memberLogin=anna, foodId=9, foodName=큐브라떼, orderedAt=2021-05-26, unit=1, totalPrice=5400]
Order [id=3, orderNum=ONChTseeLb, memberId=2, memberLogin=anna, foodId=9, foodName=큐브라떼, orderedAt=2021-05-26, unit=1, totalPrice=5400]
Order [id=1, orderNum=ON32H1uf9F, memberId=1, memberLogin=elsa, foodId=4, foodName=바닐라라떼, orderedAt=2021-05-26, unit=2, totalPrice=9000]
DB 종료 성공!!
*/ 
