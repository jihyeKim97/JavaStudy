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
	
	// �α����� ȸ�����Ͱ� �ű� �ֹ� �ϳ��� �߰��� �� �ִ�.
	public boolean insertNewOrder(Order od) {
		if(conn != null && od != null) {
//			String sql = 
//			"INSERT INTO orders " + 
//			" VALUES(ORDER_SEQ.nextval, "
//			+ "'ON32H1uf9F', 1, 'elsa', " + 
//			" 4, '�ٴҶ��2', sysdate, 2, 9000)";
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
					System.out.println("DB�� �ֹ� record�� �� ����!");
					return true;
				} else {
					System.out.println("DB�� �ֹ� record ���� ����..");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
	
	// �����ڴ� ��� �ֹ� ����Ʈ�� ��ȸ�� �� �ִ�.
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
				System.out.println("DBMgr: �ֹ� ��ȸ �Ǽ� => "
						+ odList.size());
				return odList;
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		} else {
			System.out.println("DB ��� ����!!");
		}
		return null;
	}
	
	// ȸ���� �ڽ��� �ֹ��� ��� �ֹ� ����Ʈ�� ��ȸ�� �� �ִ�.
	
	// Ư�� ���ĸ޴��� �������� ��� �ֹ� ����Ʈ�� ��ȸ�� �� �ִ�.
	
	// Ư�� �ֹ���ȣ<UQ>�� �ϳ��� �ֹ��� ����ȸ �� �� �ִ�.
	
	// �ֹ� ������ȣ<PK>�� �ϳ��� �ֹ��� ����ȸ �� �� �ִ�.

	// .... 
	
	public static void main(String[] args) {
		OrderDBMgr odMgr = new OrderDBMgr();
				
		System.out.println("-- ���� �ֹ� ����Ʈ --");
		ArrayList<Order> odList = odMgr.selectAllOrders();
		for (Order order : odList) {
			System.out.println(order);
		}
		Order tOd1 = new Order(
				Order.generateOrderNumber(),
				2, "anna", 
				9, "ť���", 5400);
		if( odMgr.insertNewOrder(tOd1) ) 
			System.out.println("anna �ֹ� ����!!");
		
		System.out.println("-- ���ŵ� �� ����Ʈ --");
		odList = odMgr.selectAllOrders();
		for (Order order : odList) {
			System.out.println(order);
		}
		
		OracleDBUtil.endConnection();
	}

}


/*
DB ���� ����! Wed May 26 11:49:47 KST 2021
-- ���� �ֹ� ����Ʈ --
DBMgr: �ֹ� ��ȸ �Ǽ� => 3
Order [id=4, orderNum=ONuzKEqsMz, memberId=2, memberLogin=anna, foodId=9, foodName=ť���, orderedAt=2021-05-26, unit=1, totalPrice=5400]
Order [id=3, orderNum=ONChTseeLb, memberId=2, memberLogin=anna, foodId=9, foodName=ť���, orderedAt=2021-05-26, unit=1, totalPrice=5400]
Order [id=1, orderNum=ON32H1uf9F, memberId=1, memberLogin=elsa, foodId=4, foodName=�ٴҶ��, orderedAt=2021-05-26, unit=2, totalPrice=9000]
DB�� �ֹ� record�� �� ����!
anna �ֹ� ����!!
-- ���ŵ� �� ����Ʈ --
DBMgr: �ֹ� ��ȸ �Ǽ� => 4
Order [id=5, orderNum=ONDg7IxU97, memberId=2, memberLogin=anna, foodId=9, foodName=ť���, orderedAt=2021-05-26, unit=1, totalPrice=5400]
Order [id=4, orderNum=ONuzKEqsMz, memberId=2, memberLogin=anna, foodId=9, foodName=ť���, orderedAt=2021-05-26, unit=1, totalPrice=5400]
Order [id=3, orderNum=ONChTseeLb, memberId=2, memberLogin=anna, foodId=9, foodName=ť���, orderedAt=2021-05-26, unit=1, totalPrice=5400]
Order [id=1, orderNum=ON32H1uf9F, memberId=1, memberLogin=elsa, foodId=4, foodName=�ٴҶ��, orderedAt=2021-05-26, unit=2, totalPrice=9000]
DB ���� ����!!
*/ 
