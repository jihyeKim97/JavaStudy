package collective.hash;

import java.util.Enumeration;
import java.util.HashMap;
import java.util.Properties;

public class HashMain12 {

	public static void main(String[] args) {
		// ��������(Preferences)�� ������ ǥ���ϱ�
		// �������� ���� ���ڿ�Ű => ���ڿ������ ����...
		// Settings, Preferences, Configurations,
		// system.ini �ʱ⼳������? fonts.ini ����

//		HashMap<String,String> config
//						= new HashMap<>();
//		// ��Ʈ ������ ��... myFonts.ini ���Ϸ� ��..
////		config.put("�����̸�", "������");
//		config.put("font-family", "Arial"); // ttf	
//		config.put("font-unit", "pt"); // "mm");
////		config.put("font-size", "200");
////		config.put("font-size", String.valueOf(200)); // new add
//		config.put("font-size", ""+120); // old update 
//		config.put("font-weight", "bold"); //thin, bold, plain..
//		config.put("font-file", "c:/system/fonts/Arial.ttf");

		// HashTable�� ���� Ŭ����
		Properties config = new Properties();
//		config.
		// ���ڿ�Ű => ���ڿ������ ����...
		// setProperty(), getProperty();
		config.setProperty("font-family", "Arial"); // ttf
		config.setProperty("font-unit", "pt"); // "mm");
		config.setProperty("font-size", "" + 120); // old update
		config.setProperty("font-weight", "bold"); // thin, bold, plain..
		config.setProperty("font-file", "c:/system/fonts/Arial.ttf");
		//
		final String TARGET_FONT_CONF = "font-size";
		int swApplyFontSize = 0;
		final int DEF_FONT_SIZE = 12;
		if (config.containsKey(TARGET_FONT_CONF) == true) {
			// �������Ͽ� ��Ʈũ�� ������ �Ǿ��ִٸ�...
			if (config.get(TARGET_FONT_CONF) != null && !config.getProperty(TARGET_FONT_CONF).isEmpty())
				swApplyFontSize = Integer.parseInt(config.getProperty(TARGET_FONT_CONF));
		} else { // �ش� ������ ���ٸ�... �⺻���� ����...
			swApplyFontSize = DEF_FONT_SIZE; //
		}

		// sw�� ���� �����ϱ�
		System.out.println("=== ����� ��Ʈ ���� ===");
		System.out.println(">> ��Ʈ���� - size: " + swApplyFontSize);

		// Properties ������ ������ ������ ����.
		// iteration? Enumeration? ������
		// �÷��ǿ��� ������ ���� ��Ұ� �ִ���? üũ?
		// �ִٸ�... �� ��Ұ��� ������ ����?
		Enumeration<String> keys = (Enumeration<String>) config.propertyNames();

		while (keys.hasMoreElements() == true) {
			String key = keys.nextElement();
			String value = config.getProperty(key);
			System.out.println(key + "->" + value);
		}
		System.out.println("Ű ��� ���� ��");
	}

}
