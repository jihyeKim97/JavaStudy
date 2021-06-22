package db.mgr;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import db.data.Food;
import db.util.OracleDBUtil;

public class FoodDBMgr {
	Connection conn;
	public FoodDBMgr() {
		this.conn = OracleDBUtil.getConn();
	}
	
	// 어드민/스탭은 특정 음식을 하나를 추가 할 수 있다.
	public boolean addNewOneFood(Food fd) {
		if( conn != null && fd != null ) {
//	String sql = "INSERT INTO foods VALUES("
//	+ "FOOD_SEQ.nextval,'카라멜마키아토', '커피',"
//	+ "'./images/menu_thumb/카라멜마키아토.PNG', "
//	+ "3800, 2, sysdate,'',0,'설명...')";		
			String sql = "INSERT INTO foods VALUES("
				+ "FOOD_SEQ.nextval, ?, ?, ?, ?, ?, "
				+ "sysdate,'',0, ?)";
			try {
				PreparedStatement pstmt =
						conn.prepareStatement(sql);
				pstmt.setString(1, fd.getName());
				pstmt.setString(2, fd.getCategory());
				pstmt.setString(3, fd.getImagePath());
				pstmt.setInt(4, fd.getPrice());
				pstmt.setInt(5, fd.getHotIce());
				pstmt.setString(6, fd.getDescription());
				int r = pstmt.executeUpdate();
				if( r == 1 ) {
					System.out.println(
							fd.getName() + " 음식 레코드 추가 성공!");
					return true;
				} else {
					System.out.println(
							fd.getName() + " 음식 레코드 추가 실패..");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} // else ..
		return false;
	}
	public boolean addNewOneFood(String name, String category, 
			String imagePath, int price, int hotIce, 
			String description) {
		
		return false;
	}
	
	// 어드민/스탭은 특정 음식을 하나를 id로 조회할 수 있다. 
	// 어드민/스탭은 특정 음식을 하나를 이름로 조회할 수 있다.
	// 사용자는 전체 음식을 조회할 수 있다.
	public ArrayList<Food> selectAllFoods() {
		if( conn != null ) {
			//String sql = "select * from foods";
			String sql = "select * from foods order by id asc";
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
					rs.getInt("like_count"), 
					rs.getString("description"));// 1.1
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
	
	// *로그인 상태 회원이 특정 음식에 대해 좋아요/취소할 수 있다.
	// 특정 음식의 좋아요회원리스트 (문자열) 
	public String selectLikeMembersForFood(int fdId) {
		if( conn != null ) {
			String sql = "select like_members from "
					+ "foods where id = "+ fdId;
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {					
					return rs.getString("like_members");
				} else {
					System.out.println(fdId + " 음식이 없어요!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return null;
	}
	// 특정 음식의 좋아요회원카운트 (정수)
	public int selectLikeCountForFood(int fdId) {
		if( conn != null ) {
			String sql = "select like_count from "
					+ "foods where id = "+ fdId;
			try {
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql);
				if (rs.next()) {					
					return rs.getInt("like_count");
				} else {
					System.out.println(fdId + " 음식이 없어요!");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}			
		}
		return 0;
	}
	
	// 특정 음식의 좋아요 회원들의 리스트를 리턴하는 함수
	public static final String SEP = ",";
	public ArrayList<String>
		selectLikeMembersForFoodAsList(int fdId) {
		ArrayList<String> lkList = new ArrayList<>();
		String oldLikeMembers = selectLikeMembersForFood(fdId);
		  // null
		  // ""
		  // "4" 
		  // "3,5,10,2"  --> ["3", "5", "10", "2"] split()!
		if(oldLikeMembers != null && !oldLikeMembers.isEmpty() ) {
			// 한명이상 있네...---
			if( oldLikeMembers.contains(SEP) ) {
				// 다 수명이 좋아요.. split() 가능
				String[] temps = oldLikeMembers.split(SEP);
				for (String mbIdStr : temps) {
					lkList.add(mbIdStr);
				}
			} else {
				// 혼자서 한명 좋아요. 컴마가 없어서 split() 아님..
				lkList.add(oldLikeMembers); // "4"
			}
			return lkList;
		} else {
			return null;
		}
	}
	
	// 이미 mbId회원이 fdId 음식을 미리 사전 좋아요 체크 함수
	public boolean isAlreadyLikedFood(int fdId, int mbId) {
		ArrayList<String> lkList
			= selectLikeMembersForFoodAsList(fdId);
		if( lkList == null || lkList.isEmpty() ) {
			System.out.println("아직 아무도 좋아요 안했어요..");
			return false;
		} else { // 이미 좋아요 한 회원(들)이 있어요..
			for (String lkMbId : lkList) {
				if( lkMbId.equals(String.valueOf(mbId))) {
					System.out.println(mbId 
							+ " 회원님 이미 좋아요 하셨어요!!!!");
					return true;
				}
			}
			//
		}
		return false; 
	}
	
	// 특정 음식의 좋아요회원리스트에 로그인한 회원의 id를 추가할 수 있다.
	public boolean addLikeToFood(int fdId, int mbId) {
		// 이미 mbId회원이 fdId 음식을 미리 사전 좋아요 했을 경우?
		if( isAlreadyLikedFood(fdId, mbId) == true ) {
			System.out.println(mbId + " 회원이 이미 좋아요 했어요!");
			return false;
		}
		
		// 특정 음식의 기존 좋아요회원리스트 (문자열)
		String oldLikeMembers = selectLikeMembersForFood(fdId);
		// 특정 음식의 기존 좋아요회원카운트 (정수)
		int oldLikeCount = selectLikeCountForFood(fdId);
		
		boolean b = false;
		// 최초의 좋아요 추가일 경우...
		//if( oldLikeMembers == null || oldLikeMembers.isEmpty() )
		if( oldLikeCount == 0 ) {
			b = updateLikeMembers(fdId, ""+mbId, 1);
		} else {
			// 이미 좋아요한 다른 회원들이 1명 이상일 경우... 
			// "1" ==> "1,7"    "3,100,32" ==> "3,100,32,7" 
			String newLikeMermbers =
					oldLikeMembers + "," + mbId;
			b = updateLikeMembers(fdId, newLikeMermbers,
					oldLikeCount+1);
		}
		
		if( b ) {
			System.out.println("foods 좋아요 DB 갱신 성공!");
			return true;
		} else {
			System.out.println("foods 좋아요 DB 갱신 실패..");
			return false;
		}
	}
	
	// 특정 음식에 대해 좋아요회원리스트, 좋아요누적카운트 동시에 갱신하기
	public boolean updateLikeMembers(int fdId, 
			String likeMembers, int likeCount) {
		if( conn != null ) {
			String sql = "update foods set "
					+ " like_members = ?, "
					+ " like_count = ? "
					+ " where id = ?"; 
			try {
				PreparedStatement pstmt
					= conn.prepareStatement(sql);
				pstmt.setString(1, likeMembers);
				pstmt.setInt(2, likeCount);
				pstmt.setInt(3, fdId);
				int r = pstmt.executeUpdate();
				if( r == 1 ) {
					System.out.println("db 좋아요 회원리스트 갱신 성공!");
					return true;
				} else {
					System.out.println("db 좋아요 회원리스트 갱신 실패..");
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return false;
	}
}
