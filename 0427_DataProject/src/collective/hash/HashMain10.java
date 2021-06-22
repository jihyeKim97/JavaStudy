package collective.hash;

import java.util.HashMap;

public class HashMain10 {

	public static void main(String[] args) {
		// 설정사항(Preferences)을 맵으로 표현하기
		// 설정맵은 보통 문자열키 => 문자열밸류로 적용...
		// Settings, Preferences, Configurations, 
		// system.ini 초기설정파일?   fonts.ini 파일
		
		HashMap<String,String> config
						= new HashMap<>();
		// 폰트 설정의 예... myFonts.ini 파일로 예..
//		config.put("설정이름", "설정값");
		config.put("font-family", "Arial"); // ttf	
		config.put("font-unit", "pt"); // "mm");
//		config.put("font-size", "200");
//		config.put("font-size", String.valueOf(200)); // new add
		config.put("font-size", ""+120); // old update 
		config.put("font-weight", "bold"); //thin, bold, plain..
		config.put("font-file", "c:/system/fonts/Arial.ttf");
		//
		final String TARGET_FONT_CONF = "font-size";
		int swApplyFontSize = 0;
		final int DEF_FONT_SIZE = 12; 
		if( config.containsKey(TARGET_FONT_CONF) == true ) {
			// 설정파일에 폰트크기 설정이 되어있다면...
			if( config.get(TARGET_FONT_CONF) != null &&
					!config.get(TARGET_FONT_CONF).isEmpty()	)
			swApplyFontSize = 
				Integer.parseInt(config.get(TARGET_FONT_CONF));
		} else { // 해당 설정이 없다면...  기본값을 적용...
			swApplyFontSize = DEF_FONT_SIZE; //
		}
		
		// sw에 설정 적용하기
		System.out.println("=== 사용자 폰트 설정 ===");
		System.out.println(">> 폰트설정 - size: " + swApplyFontSize);
	}

}






