package inherit;
// 상속 개념

// 재사용성을 극대화한 방법
// 모든 자바의 클래스는 0세대가 아님 

// 0 세대 Object : 모든 클래스의 최고위 조상(항상 기본 상속 되어있음)

/*--------------// 1 세대 Object > Parent --------------*/
class Parent {
//class Parent extends Object{
   String name;

   public Parent() {
      name = "부모";
   }

   public Parent(String name) {
      super();
      this.name = name;
   }

   public void printName() {
      System.out.println("이름: " + this.name);
   }

   public void printCommon() { // 가문, 가계, 가보의 공통 출력함수 정의
      this.printName();
   }
}

/*--------------// 2 세대 Object > Parent  > Child--------------*/
// 자식, 파생, 서브클래스 - 부모, 슈퍼클래스
class Child extends Parent {
   public int age;

   public Child() {
   }

   public Child(int age) {
      this.age = age;
      this.name = "무명";
   }

   public Child(String name) {
      this.age = 18;
      this.name = name;
   }

   public Child(int age, String name) {
      this.age = age;
      this.name = name;
   }

   public void printAge() { // 자신의 고유 기능
      // super.printName(); this.printCommon();
      System.out.println("나이: " + this.age + "세");
   }

   public void printCommon() { // 부모에게 물려 받았지만 내세대에 맞게 확장시킨 common()
      // 부모꺼와 동일한 이름의 함수 이지만 내꺼에서 다시 정의가 가능하며,
      // 내꺼에 정의한 것을 먼저 찾아가고 정의되어있지않으면 부모껄로 찾아 간다
      this.printName();
      this.printAge();
   }

}

/*--------------// 3 세대 Object > Parent  > Child > moneyChild--------------*/
class MoneyChild extends Child {
   public static final int DEF_MONEY = 10000;
   private int money;

   public MoneyChild() {
      this.name = "무명";
      this.age = 18;
      this.money = DEF_MONEY;
   }

   public MoneyChild(int money) {
      this.name = "무명";
      this.age = 16;
      this.money = money;
   }

   public MoneyChild(String name, int age, int money) {
//      super(age, name); // 부모 필드 초기화
//      this.money = money; // 내 필드 초기화

      this.name = name; // 부모 의 부모 필드 초기화
      this.age = age; // 부모 필드 초기화
      this.money = money; // 내 필드 초기화
   }

   public void printMoney() {
      System.out.println("부자임" + this.money + "원");
   }

   public void printCommon() {
      this.printName();
      this.printAge();
      this.printMoney();
   }
}

/*--------------// 3 세대 Object > Parent  > Child > BookChild--------------*/
class BookChild extends Child {

   private Book book;
   private double score;

   public BookChild() {
      this.name = "무명";
      this.age = 10;
      this.score = 3.0;
      this.book = new Book("과학안에서 살아남기", "졔");

   }

   public BookChild(String name, int age, Book book, double score) {
      this.name = name;
      this.age = age;
      this.score = score;
      this.book = book;
   }

   public void printScore() {
      System.out.println("점수 : " + this.score + "점");
   }

   public void printMyBook() {
      System.out.println("내책 : ");
      this.book.printBook();
//      System.out.println("내책 : "+this.book);
//      System.out.println("내책 : "+this.book.toString());
   }

   public void printCommon() {
      this.printName();
      this.printAge();
      this.printScore();
      this.printMyBook();
   }
}

/*--------------// 3 세대 Object > Parent  > Child > FoodChild--------------*/
class FoodChild extends Child {

}




/*============================================================*/



public class InheritMain {

   public static void main(String[] args) {
/*--------------------------Parent 탄생--------------------------*/
//      ##ver1
//      Parent p1 = new Parent();
//      p1.name = "엄마";
//      p1.printName();
//      Parent p2 = new Parent("아빠");
//      p2.printName();
      
//      ##ver2
//      Parent p1 = new Parent();
//      p1.name = "엄마";
//      p1.printCommon();
//
//      Parent p2 = new Parent("아빠");
//      p2.printCommon();

//      ##ver3
      Parent p1 = new Parent();
      p1.name = "엄마";
      Parent p2 = new Parent("아빠");
/*--------------------------Child 탄생--------------------------*/
//      ##ver1
//      Child c1 = new Child();
//      c1.name = "딸";
//      c1.age = 12;
//      c1.printName();
//      c1.printAge(); 

//      ##ver2
//      Child c1 = new Child();
//      c1.name = "딸";
//      c1.age = 12;
//      // 내꺼에 정의되지 않았으면 부모껄로 가져다 쓰지만
//      // 내꺼에 정의가 되어있다면 내꺼를 사용한다
//      c1.printCommon();
//      
//      Child c2 = new Child("아들");
//      c2.printCommon();
//      
//      Child c3 = new Child("쌍둥이");
//      c3.printCommon();

//      ##ver3
      Child c1 = new Child();
      c1.name = "딸";
      c1.age = 12;
      Child c2 = new Child("아들");
      Child c3 = new Child("쌍둥이");
      
/*--------------------------MoneyChild 탄생--------------------------*/

//      ##ver1
//      MoneyChild m1 = new MoneyChild();
//      m1.printCommon();
//
//      MoneyChild m2 = new MoneyChild(50000);
//      m2.printCommon();
//
//      MoneyChild m3 = new MoneyChild("김하늘", 31, 2000000);
//      m3.printCommon();

//      ##ver2
      MoneyChild m1 = new MoneyChild();
      MoneyChild m2 = new MoneyChild(50000);
      MoneyChild m3 = new MoneyChild("김하늘", 31, 2000000);
      
/*--------------------------BookChild 탄생--------------------------*/
//      ##ver1
//      BookChild b1 = new BookChild("이솝", 17, new Book("이솝이야기", "이솝"), 5.0);
//      b1.printCommon();

//      ##ver2
      BookChild b1 = new BookChild("이솝", 17, new Book("이솝이야기", "이솝"), 5.0);
/*---------------------------상속 배열 다형성-------------------------*/
      Parent[] humans = { p1, p2, c1, c2, c3, m1, m2, m3, b1, new BookChild() };

      // 동일한 구조로 움직일 뿐 실행 구조가 바뀌지 않는다 
      for (Parent man : humans) {
         man.printCommon();// 동일실행 구조
      }

   }

}