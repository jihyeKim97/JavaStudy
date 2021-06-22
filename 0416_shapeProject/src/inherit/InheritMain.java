package inherit;
// ��� ����

// ���뼺�� �ش�ȭ�� ���
// ��� �ڹ��� Ŭ������ 0���밡 �ƴ� 

// 0 ���� Object : ��� Ŭ������ �ְ��� ����(�׻� �⺻ ��� �Ǿ�����)

/*--------------// 1 ���� Object > Parent --------------*/
class Parent {
//class Parent extends Object{
   String name;

   public Parent() {
      name = "�θ�";
   }

   public Parent(String name) {
      super();
      this.name = name;
   }

   public void printName() {
      System.out.println("�̸�: " + this.name);
   }

   public void printCommon() { // ����, ����, ������ ���� ����Լ� ����
      this.printName();
   }
}

/*--------------// 2 ���� Object > Parent  > Child--------------*/
// �ڽ�, �Ļ�, ����Ŭ���� - �θ�, ����Ŭ����
class Child extends Parent {
   public int age;

   public Child() {
   }

   public Child(int age) {
      this.age = age;
      this.name = "����";
   }

   public Child(String name) {
      this.age = 18;
      this.name = name;
   }

   public Child(int age, String name) {
      this.age = age;
      this.name = name;
   }

   public void printAge() { // �ڽ��� ���� ���
      // super.printName(); this.printCommon();
      System.out.println("����: " + this.age + "��");
   }

   public void printCommon() { // �θ𿡰� ���� �޾����� �����뿡 �°� Ȯ���Ų common()
      // �θ𲨿� ������ �̸��� �Լ� ������ �������� �ٽ� ���ǰ� �����ϸ�,
      // ������ ������ ���� ���� ã�ư��� ���ǵǾ����������� �θ𲬷� ã�� ����
      this.printName();
      this.printAge();
   }

}

/*--------------// 3 ���� Object > Parent  > Child > moneyChild--------------*/
class MoneyChild extends Child {
   public static final int DEF_MONEY = 10000;
   private int money;

   public MoneyChild() {
      this.name = "����";
      this.age = 18;
      this.money = DEF_MONEY;
   }

   public MoneyChild(int money) {
      this.name = "����";
      this.age = 16;
      this.money = money;
   }

   public MoneyChild(String name, int age, int money) {
//      super(age, name); // �θ� �ʵ� �ʱ�ȭ
//      this.money = money; // �� �ʵ� �ʱ�ȭ

      this.name = name; // �θ� �� �θ� �ʵ� �ʱ�ȭ
      this.age = age; // �θ� �ʵ� �ʱ�ȭ
      this.money = money; // �� �ʵ� �ʱ�ȭ
   }

   public void printMoney() {
      System.out.println("������" + this.money + "��");
   }

   public void printCommon() {
      this.printName();
      this.printAge();
      this.printMoney();
   }
}

/*--------------// 3 ���� Object > Parent  > Child > BookChild--------------*/
class BookChild extends Child {

   private Book book;
   private double score;

   public BookChild() {
      this.name = "����";
      this.age = 10;
      this.score = 3.0;
      this.book = new Book("���оȿ��� ��Ƴ���", "��");

   }

   public BookChild(String name, int age, Book book, double score) {
      this.name = name;
      this.age = age;
      this.score = score;
      this.book = book;
   }

   public void printScore() {
      System.out.println("���� : " + this.score + "��");
   }

   public void printMyBook() {
      System.out.println("��å : ");
      this.book.printBook();
//      System.out.println("��å : "+this.book);
//      System.out.println("��å : "+this.book.toString());
   }

   public void printCommon() {
      this.printName();
      this.printAge();
      this.printScore();
      this.printMyBook();
   }
}

/*--------------// 3 ���� Object > Parent  > Child > FoodChild--------------*/
class FoodChild extends Child {

}




/*============================================================*/



public class InheritMain {

   public static void main(String[] args) {
/*--------------------------Parent ź��--------------------------*/
//      ##ver1
//      Parent p1 = new Parent();
//      p1.name = "����";
//      p1.printName();
//      Parent p2 = new Parent("�ƺ�");
//      p2.printName();
      
//      ##ver2
//      Parent p1 = new Parent();
//      p1.name = "����";
//      p1.printCommon();
//
//      Parent p2 = new Parent("�ƺ�");
//      p2.printCommon();

//      ##ver3
      Parent p1 = new Parent();
      p1.name = "����";
      Parent p2 = new Parent("�ƺ�");
/*--------------------------Child ź��--------------------------*/
//      ##ver1
//      Child c1 = new Child();
//      c1.name = "��";
//      c1.age = 12;
//      c1.printName();
//      c1.printAge(); 

//      ##ver2
//      Child c1 = new Child();
//      c1.name = "��";
//      c1.age = 12;
//      // ������ ���ǵ��� �ʾ����� �θ𲬷� ������ ������
//      // ������ ���ǰ� �Ǿ��ִٸ� ������ ����Ѵ�
//      c1.printCommon();
//      
//      Child c2 = new Child("�Ƶ�");
//      c2.printCommon();
//      
//      Child c3 = new Child("�ֵ���");
//      c3.printCommon();

//      ##ver3
      Child c1 = new Child();
      c1.name = "��";
      c1.age = 12;
      Child c2 = new Child("�Ƶ�");
      Child c3 = new Child("�ֵ���");
      
/*--------------------------MoneyChild ź��--------------------------*/

//      ##ver1
//      MoneyChild m1 = new MoneyChild();
//      m1.printCommon();
//
//      MoneyChild m2 = new MoneyChild(50000);
//      m2.printCommon();
//
//      MoneyChild m3 = new MoneyChild("���ϴ�", 31, 2000000);
//      m3.printCommon();

//      ##ver2
      MoneyChild m1 = new MoneyChild();
      MoneyChild m2 = new MoneyChild(50000);
      MoneyChild m3 = new MoneyChild("���ϴ�", 31, 2000000);
      
/*--------------------------BookChild ź��--------------------------*/
//      ##ver1
//      BookChild b1 = new BookChild("�̼�", 17, new Book("�̼��̾߱�", "�̼�"), 5.0);
//      b1.printCommon();

//      ##ver2
      BookChild b1 = new BookChild("�̼�", 17, new Book("�̼��̾߱�", "�̼�"), 5.0);
/*---------------------------��� �迭 ������-------------------------*/
      Parent[] humans = { p1, p2, c1, c2, c3, m1, m2, m3, b1, new BookChild() };

      // ������ ������ ������ �� ���� ������ �ٲ��� �ʴ´� 
      for (Parent man : humans) {
         man.printCommon();// ���Ͻ��� ����
      }

   }

}