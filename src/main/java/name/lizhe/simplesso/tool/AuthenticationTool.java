package name.lizhe.simplesso.tool;

import java.util.UUID;

public class AuthenticationTool {
	public static String getAuthenURL(String targetServerUrl,String uuid){
		targetServerUrl+="?token="+uuid.toString();
		return targetServerUrl.toString(); 
	}
	
	public static String getUUID(){
		UUID uuid=UUID.randomUUID();
		return uuid.toString();
	}
}
