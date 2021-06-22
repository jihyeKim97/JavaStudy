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
	
	// 어드민/스탭은 특정 음식을 하나를 추가 할 수 있다.
	// 어드민/스탭은 특정 음식을 하나를 id로 조회할 수 있다. 
	// 어드민/스탭은 특정 음식을 하나를 이름로 조회할 수 있다.
	// 사용자는 전체 음식을 조회할 수 있다.
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
				System.out.println("조회된 음식 DB레코드 수: " + 
						foodList.size());
				return foodList;				
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	// 어드민/스탭은 특정 음식을 하나를 내용 갱신할 수 있다.
	// 특정 카테고리의 음식들을 조회할 수 있다. 
	// 전체 음식 개수를 체크할 수 있다.
	// 특정 키워드의 부분일치하는 모든 음식들을 검색할 수 있다. 
	// 로그인 상태 회원이 특정 음식에 대해 좋아요/취소할 수 있다.  
	
	
}
