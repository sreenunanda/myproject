package newproject.test;


import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;


public class Test {
	public static void main(String[] args) throws Throwable {

		Test test= new Test();
//		test.getSPLIst();
		test.generateAccessToken();
		
	}

	public void generateAccessToken(){
		String URL= "http://192.168.0.122:9012/mifareservice/secure/oauth/token?grant_type=password&username=ChatakWalletUser&password=ChatakWalletPass";
		String Username = "ChatakWalletBasicAuth";
		String Password = "ChatakWallet@Secure";
		HttpGet http = new HttpGet(URL);


	
	}

	
	
	public void getSPLIst() throws ClientProtocolException, IOException{
		String URL= "http://192.168.0.122:9012/mifareservice/rest/serviceprovider/getSPList";
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		String str="{\"walletProviderID \" :" + "\"RoyalOEM\","
				+ "\"requestID \" :" + "\"qwer-1233-tyui-9876\","
				+ "\"location \" :" + "\"\","
				+ "\"spName \" :" + "\"\","
				+ "\"pageNumber \" :" + "\"1\","
				+ "\"pageSize \" :" + "\"10\"}" ;

		System.out.println(str);

		HttpPost httpPost= new HttpPost(URL);
		httpPost.getConfig();
		httpPost.addHeader("Content-Type", "application/json");
		httpPost.addHeader("Authorization", "bearer 2a61f53f-2897-4195-ba2e-0c2765e4c27b");
		StringEntity params = new StringEntity(str);
		httpPost.setEntity(params);
		CloseableHttpResponse response= httpClient.execute(httpPost);
		System.out.println(response.toString());
	}
}