package HomeWork_0503;

import java.util.ArrayList;

import HomeWork_0503.data.Product;

/*  상품 입고 처리 프로그램 (ArrayList, HashMap 테스트 과제)

문제 1. 상품 클래스를 정의
  Product
  필드   번호 number, 이름 name, 
          단가 unitPrice, 개수(수량) count
          종류 type(문자열형이 좋음..)

 => 모든 필드를 public해도 됩니다만,
 private으로 하면 더 좋음.
 getter함수, setter함수를 구현하는 것. 생성자, toString()
 
 10개 정도의 상품 클래스형 객체들을 생성.
 10개 상품 객체들을  ArrayList<Product>에 add()하며.
 prList라고 함.
 prList에 포함된 상품 객체들의 평균단가를 구하는 
 static 함수 구현 getAvgUnitPriceFromList(?) 및 테스트 출력 

-------------------------------------------
 
문제 2. 
상품 객체를 사용자 입력으로 임의로 생성하는 스태틱 함수를 구현
(Scanner 사용?) inputNewProductToList(?) 
최소 10개를 입력 받되, 반드시 최소 3개 이상의 "다른 종류(type)들"이 포함되어야 함.

상품의 종류별로 평균 단가를 표시하는 스태틱 함수 구현 및 아래처럼 출력 
getAvgUnitPricePerTypeFromList(?)

| 종류    | 상품개수  | 평균단가 | 
   옷           3        42000원  (옷종류의 평균단가)
   신발         2        12000원 
  장난감        5        76000원 
  ----------------------------------

전체 상품의 총 평균 구하기 함수 구현, 분산 구하기 함수 구현, 표준편차 구하기 함수 구현 
및 아래 처럼 출력    
  
  getAvgUnitPriceFromList(?)  총평균
  getTotalPriceVariance(?)    총분산
  getTotalPriceDeviation(?)   총표준편차 
   
   * 총          10개 상품       

     전체 가격 평균     3xxxx원
     전체 가격 분산     xxxxx원
     전체 가격 표준편차  yyyyyy원

                
문제 3. 
  위 문제2번에서 얻어진 prList 리스트를 대상으로...
  
  전체 상품 단가 중에 최고가와 그 상품을 찾는 함수 구현
  Product getHighPriceProductFromList(?)

  전체 상품 단가 중에 최저가와 그 상품을 찾는 함수 구현
  Product getLowPriceProductFromList(?)
  
  최고가 상품:   엘사2/종류 옷,  500000원
  최저가 상품:   또봇1/종류 장난감,  1000원

----------------------------------------------

문제 4. 위 3번까지의 모든 구현을 바탕으로... 
sort, compare...등 자바 제공 함수들을 절대 사용하지 말고...
최저가 중심으로 오름차순 정렬하여 출력하는 함수를 
자신의 자유 알고리즘으로 구현하고 아래처럼 출력

  void printFromLowToHighPrices(?)
  
      #1  또봇1     장난감      1000원 <최저가>
      #4  카봇2     장난감      4000원
      #2  울라프티      옷      6000원
      . . .
      #3  아이어맨마스크    장난감    2000000원
      #7  엘사2              옷      500000원 <최고가>
  
  또한, 최저가에서 최고가로 정렬이 수행되어 저장된 새로운 리스트를 
    만들어서 리턴하는 함수를 구현하고 테스트 출력 함. 
 +   ArrayList<Product> getFromLowToHighPricesReturn(?) 


문제 5. 현재 까지의 상품 리스트 혹은 문제 4에서 정렬된 위 prList를 
 대상으로 하여 각 type명을 키로 하고,  
 해당 상품객체를 밸류로 하는 HashMap을 리턴해주는 함수 구현 하고
  이를 이용하여 각 type별 리스트로 분리하여 요약하는 함수 구현 및 출력..
  (아래처럼 각 종류별 하위 리스트별로 가격 오름차순 정렬하면 더 좋음..)

 + HashMap<String,Product> getMapOfProductListForType(?) 

   *** 상품 종류별 리스트 요약 (총 10개) *** 

    타입: 옷   (3벌) 
      #2  울라프티      옷      6000원
      #7  엘사2         옷      500000원 
      #6  안나1         옷      600000원        

    타입: 신발  (2켤래)  
      #9  아디다스       신발   25000원 
      #5  나이키         신발   41000원 

    타입: 장난감 (5종)
      #1  또봇1          장난감      1000원 
      #4  카봇2          장난감      4000원
      #10 카봇2          장난감     15000원
      #8  페어리루       장난감     400000원
      #3  아이어맨마스크  장난감    2000000원
      
*/

public class ProductMain {

	public static void main(String[] args) {
		ArrayList<ArrayList<Product>> alArr = new ArrayList<>();
	}

}
