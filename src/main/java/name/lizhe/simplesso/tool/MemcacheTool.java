package name.lizhe.simplesso.tool;

import java.util.Date;

import com.danga.MemCached.MemCachedClient;
import com.danga.MemCached.SockIOPool; 

public class MemcacheTool {
	
	private static MemCachedClient client=getClient();
	 
	public static MemCachedClient getClient(){
		if(client==null){
			MemCachedClient cli=new MemCachedClient();  
	        String [] addr ={"172.28.128.4:11211"};  
	        Integer [] weights = {3};  
	        SockIOPool pool = SockIOPool.getInstance();  
	        pool.setServers(addr);  
	        pool.setWeights(weights);  
	        pool.setInitConn(5);  
	        pool.setMinConn(5);  
	        pool.setMaxConn(200);  
	        pool.setMaxIdle(1000*30*30);  
	        pool.setMaintSleep(30);  
	        pool.setNagle(false);  
	        pool.setSocketTO(30);  
	        pool.setSocketConnectTO(0);  
	        pool.initialize();  
	        client = cli;
		}
		return client;
	}
	
	public static void set(String key,String value,Date oos){
		client.set(key,value, oos);  
	}
	
	public static String get(String key){
		return (String)client.get(key);
	}
	
	public static void del(String key){
		client.delete(key);
	}
	

}
