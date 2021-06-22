package db.data.stat;
/*
-- 같은 카테고리들을 묶어서 통계(Statistics)
select category, sum(like_count) as likeCountSum, 
		avg(price) as avgPrice,
        count(id) as foodCount  
        from foods 
        group by category order by category asc; 
 */
// 통계의 측정 내용을 담는 통계 전용 데이터 클래스
public class FoodCategoryStat {
	private String category; // 기준키
	private int likeCountSum; 
	private float avgPrice;
	private int foodCount;
	
	public FoodCategoryStat() {
		// TODO Auto-generated constructor stub
	}

	public FoodCategoryStat(String category, int likeCountSum, float avgPrice, int foodCount) {
		super();
		this.category = category;
		this.likeCountSum = likeCountSum;
		this.avgPrice = avgPrice;
		this.foodCount = foodCount;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public int getLikeCountSum() {
		return likeCountSum;
	}

	public void setLikeCountSum(int likeCountSum) {
		this.likeCountSum = likeCountSum;
	}

	public float getAvgPrice() {
		return avgPrice;
	}

	public void setAvgPrice(float avgPrice) {
		this.avgPrice = avgPrice;
	}

	public int getFoodCount() {
		return foodCount;
	}

	public void setFoodCount(int foodCount) {
		this.foodCount = foodCount;
	}

	@Override
	public String toString() {
		return "FoodCategoryStat [category=" + category + ", likeCountSum=" + likeCountSum + ", avgPrice=" + avgPrice
				+ ", foodCount=" + foodCount + "]";
	}
	
	
}
