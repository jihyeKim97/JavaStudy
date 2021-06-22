package db.mgr;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.data.Food;
import db.util.OracleDBUtil;

public class FoodDBMgr_backup1 {
	Connection conn;
	public FoodDBMgr_backup1() {
		this.conn = OracleDBUtil.getConn();
	}
	
	// ����/������ Ư�� ������ �ϳ��� �߰� �� �� �ִ�.
	// ����/������ Ư�� ������ �ϳ��� id�� ��ȸ�� �� �ִ�. 
	// ����/������ Ư�� ������ �ϳ��� �̸��� ��ȸ�� �� �ִ�.
	// ����ڴ� ��ü ������ ��ȸ�� �� �ִ�.
	public ArrayList<Food> selectAllFoods() {
		if( conn != null ) {
			String sql = "select * from foods";
			ArrayList<Food> foodList = new ArrayList<>();
			try {
				Statement stmt= conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {
					Food food
					 = new Food(
					rs.getInt("id"), rs.getString("name"),
					rs.getString("category"),
					rs.getString("image_path"), 
					rs.getInt("price"),
					rs.getInt("hot_ice"),
					rs.getDate("reg_date"),
					rs.getString("like_members"),
					rs.getInt("like_count"));
					foodList.add(food);
				}
				System.out.println("��ȸ�� ���� DB���ڵ� ��: " + 
						foodList.size());
				return foodList;				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	// ����/������ Ư�� ������ �ϳ��� ���� ������ �� �ִ�.
	// Ư�� ī�װ��� ���ĵ��� ��ȸ�� �� �ִ�. 
	// ��ü ���� ������ üũ�� �� �ִ�.
	// Ư�� Ű������ �κ���ġ�ϴ� ��� ���ĵ��� �˻��� �� �ִ�. 
	// �α��� ���� ȸ���� Ư�� ���Ŀ� ���� ���ƿ�/����� �� �ִ�.  
	
	
}
