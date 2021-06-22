package db.mgr.stat;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.data.stat.FoodCategoryStat;
import db.util.OracleDBUtil;

// ���ĸ޴� ���� ��� ó���߰��� Ŭ����	
public class FoodStatDBMgr {
	Connection conn;
	
	public FoodStatDBMgr() {
		this.conn = OracleDBUtil.getConn();
	}
	
	// -- ���� �޴����� ���� ī�װ����� ��� ���ƿ�/����/���� 
	// �׷� ���(Statistics) -> ������, ����? 
	public ArrayList<FoodCategoryStat> selectFoodCategoryStat() {
		if( conn != null ) {
			try {
				String sql = 
			"select category, sum(like_count) as likeCountSum, " + 
			"		avg(price) as avgPrice, " + 
			"        count(id) as foodCount " + 
			"        from foods " + 
			"        group by category order by category asc";
				ArrayList<FoodCategoryStat> stList = new ArrayList<FoodCategoryStat>();	
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				while( rs.next() ) {
					FoodCategoryStat stat 
						= new FoodCategoryStat(
							rs.getString("category"),
							rs.getInt("likeCountSum"), 
							rs.getFloat("avgPrice"),
							rs.getInt("foodCount") );
					stList.add(stat);
				}
				return stList;
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

}
