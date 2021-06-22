package membership.manage;
// ȸ������ �����ϱ� ���� �߰� Ŭ���� 

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import membership.data.Member;

// Member ��Ű��(������)�� CRUD �����ϴ� Ŭ����
// ȸ�� ����, ȸ�� ����, ȸ�� ����, ȸ�� ��ȸ
public class MemberMgr {
	public static final int MAX_MEMBERS = 5;
	
	// �����Ǵ� ȸ���� (�����; �޸�, ����, DB, Ŭ����)
	
	// 1. �� ���� ȸ������ ������ ������ �غ� (�������̽� ���̾�׷�)
//	private Member[] _members; // ���x
	protected Member[] _members; // ���o
	
	public MemberMgr() {
		this._members = new Member[MAX_MEMBERS];
		 // { null, null, null, null, null }
	}

	public MemberMgr(int size) {
//		super();
		if( size <= 0 ) size = MAX_MEMBERS;
		this._members = new Member[size];
	}
	
	public MemberMgr(Member[] store) {
		super();
		if( store != null && store.length > 0 )
			this._members = store;
		else 
			this._members = new Member[MAX_MEMBERS];
	}
	
	
	
	// 2. �� ���� ȸ������ �� �� ����� �� �ִ�. (����)
	// 
	// ��ĳ�ʷ� ������ �Է¹ٴ� ������ ȸ��(vo ��ü)�� �����ϰ�, 
	// �迭�� ����ϰ�, �� ȸ�� ��ü�� �����ϴ� �Լ�
	public Member joinNewMember(Scanner sc) {
		if( this.isMembersFull() ) {
			System.out.println(" �� �̻� �߰� ȸ�� ��� �Ұ���!!");
			return null;
		}
		if( sc == null ) sc = new Scanner(System.in);
		//
		Member mb = null;
		// ��ĳ�ʷ� ȸ����ü ������ ���� ��� �������� �Է�
		int no = ++Member.order; 
		String name = inputString(sc, ">> ȸ�� �̸�: ");
//		int age = Integer.parseInt(
//				inputString(sc, ">> ȸ�� ����: "));
		int age = iuputInteger(sc, ">> ȸ�� ����: ");
		String email = inputString(sc, ">> �̸��� �ּ�: ");
		double mileage = Member.DEF_MILE;
		String id = inputString(sc, ">> ȸ�� ���̵�: "); // �ߺ�üũ
		String password = inputString(sc, ">> ȸ�� ��ȣ: ");
		// ���� ���ڿ��� �Է� => ������ ��ü ��ȯ
		String birthStr = inputString(sc, 
				">> ȸ�� ������� [��: 2020-03-14]: "); 
		Date birthDay = null;
		SimpleDateFormat sdf = 
				new SimpleDateFormat("yyyy-MM-dd");
		try {
			//sdf.format(date)
			birthDay = sdf.parse(birthStr); // Date()
		} catch (ParseException e) {
			System.out.println("�߸��� ���� ������� �Է�!!");
			birthDay = new Date();
		}
		Date joinDay = new Date();
		
		// �������� new ȸ����ü ����
		mb = new Member(no, name, age, email, 
				mileage, id, password, birthDay, joinDay);
		
		// �迭������ �� ȸ�� ȸ�� ��ü ����
		int inputNo = checkNumberOfMembers();//0;
		_members[inputNo] = mb; // �迭�� �� �������� ä���� ���
		return mb;
	}
	
	// �� ���� ȸ���� ��ĳ�ʷ� ���������� ����ϴ� �Լ� (yes/no �߰�?����?)
	public void processJoinMembers() {
		Scanner sc = new Scanner(System.in);
		int count = 0;
		do {
			Member newMb = joinNewMember(null);
			if( newMb != null ) {
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
				System.out.println("\t " +newMb.getName() +" �� ������ ȯ���մϴ�!!");
				System.out.println("\t ���� ����:: "); 
				System.out.println(newMb);// toString()
				System.out.println("~~~~~~~~~~~~~~~~~~~~~~~");
				count++;
			}

			if( !isMembersFull() ) {
				String conti = inputString(sc, ">> �߰� ȸ�� ����? (yes/no)");
				if( conti.equalsIgnoreCase("no") || conti.equals("n")
						|| conti.equals("�ƴϿ�")) { // no No nO NO
					break;
				}
			} else {
				System.out.println("�� �̻� ��� �Ұ�!");
			}
		} while(true);
		System.out.println("\t �ű�ȸ�� "+count+"���� �߰���......");
	}
	
	public int iuputInteger(Scanner sc, String msg) {
		System.out.print(msg);
		String input = sc.next();		
		return Integer.parseInt(input);
	}
	
//	private String inputString(Scanner sc, String msg) {
	protected String inputString(Scanner sc, String msg) {
		System.out.print(msg);		
		return sc.next();
	}

	// 3. ��ϵ� ȸ������ �� ����Ʈ�� ����� �� �ִ�.
	public void printAllMembers() {
		System.out.println("=== ȸ�� ����Ʈ === (" 
				//+ checkNumberOfMembers() + "��)");
				+ checkNumberOfMembers() +
				" / " + _members.length + " ��)");
				//+ this._members.length + "��)");
		System.out.println(
		"��ȣ, �̸�, ����, �̸���, ���ϸ���, ������, ��ȣ, ����, ������");
		System.out.println("-------------------------------");
		for (Member mb : _members) {
			System.out.println( mb == null ?
					"Member ���� " : mb.toString());
		}
		System.out.println("-------------------------------");
	}
	
	// 4. ��ϵ� ��ü ȸ������ �� ����� Ȯ���� �� �ִ�. 
	public int checkNumberOfMembers() {
		// ��ϵ� ȸ�� ��� === ������� �迭����  null�ƴ� ����.
		int count = 0;
		for (int i = 0; i < _members.length; i++) {
//			Member mb = _members[i];
//			if( mb != null ) count++;			
			if( _members[i] != null ) count++;
		}
		return count;
	}
	
	// 5. ȸ�� ����Ұ� ����������? ��������� Ȯ�� �� �� �ִ�.
	public boolean isMembersFull() {
//		if(checkNumberOfMembers() == _members.length) return true;
//		else return false;
//		return checkNumberOfMembers()
//				== _members.length ? true: false;
		return checkNumberOfMembers() == _members.length;		
	}
	public boolean isMembersEmpty() {
		return checkNumberOfMembers() == 0;
	}
	
	// 6. ��ϵ� ȸ������ Ư�� ����/Ű����� �˻��� �� �ִ�.
	
	// 7. �α��� ���� ó�� �� �� �ִ�.
	
	// (8. �н����带 ��ȣȭ �� �� �ִ�.) 
}
