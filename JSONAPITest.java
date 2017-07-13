package newproject.test;

import java.io.IOException;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.client.HttpClientBuilder;
import org.apache.http.util.EntityUtils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;


public class JSONAPITest {


	public static void main(String[] args) throws Throwable {

		JSONAPITest test= new JSONAPITest();
		String access_token = test.generateAccessToken();
		System.out.println("generated Access toke : "+access_token );
		test.getSPLIst(access_token);

	}

	public String generateAccessToken(){
		String URL= "http://192.168.0.122:9012/mifareservice/secure/oauth/token?grant_type=password&username=ChatakWalletUser&password=ChatakWalletPass";
		String username = "ChatakWalletBasicAuth";
		String password = "ChatakWallet@Secure";
		try{
			DefaultHttpClient httpClient = new DefaultHttpClient();
			httpClient.getCredentialsProvider().setCredentials(
					new AuthScope(AuthScope.ANY_HOST,AuthScope.ANY_PORT),
					new UsernamePasswordCredentials(username, password)
					);

			HttpPost httpPost = new HttpPost(URL);
			HttpResponse httpResponse = httpClient.execute(httpPost);
			String httpResponseData = EntityUtils.toString(httpResponse.getEntity());
			JsonObject jsonObject= new JsonObject();
			JsonParser jsonParser= new JsonParser();
			jsonObject = (JsonObject) jsonParser.parse(httpResponseData);	
			System.out.println(httpResponseData);
			String access_token = jsonObject.get("access_token").toString();
			//System.out.println(access_token.replaceAll("\"", ""));
			return access_token.replaceAll("\"", "");
		}catch(Exception e){
			e.printStackTrace();
		}
		return null;
	}

	public void getSPLIst(String token) throws ClientProtocolException, IOException{
		String URL= "http://192.168.0.122:9012/mifareservice/rest/serviceprovider/getSPList";
		CloseableHttpClient httpClient = HttpClientBuilder.create().build();

		String str="{\"walletProviderID\" :" + "\"RoyalOEM\","
				+ "\"requestID\" :" + "\"qwer-1233-tyui-9876\","
				+ "\"location\" :" + "\"\","
				+ "\"spName\" :" + "\"\","
				+ "\"pageNumber\" :" + "\"1\","
				+ "\"pageSize\" :" + "\"10\"}" ;

		System.out.println(str);

		HttpPost httpPost= new HttpPost(URL);
		httpPost.getConfig();
		httpPost.addHeader("Content-Type", "application/json");
		httpPost.addHeader("Authorization", "bearer "+token);
		StringEntity params = new StringEntity(str);
		httpPost.setEntity(params);
		CloseableHttpResponse response= httpClient.execute(httpPost);
		parseResponseData(EntityUtils.toString(response.getEntity()));
	}

	public String parseResponseData(String httpReposneData){

		JsonObject jsonObject= new JsonObject();
		JsonParser jsonParser= new JsonParser();
		jsonObject = (JsonObject) jsonParser.parse(httpReposneData);
		System.out.println("***************");
		System.out.println(httpReposneData);
		String status = jsonObject.get("status").toString(); 
		String statusMessage = jsonObject.get("statusMessage").toString();
		System.out.println("***************");
		System.out.println("status : "+status);
		System.out.println("statusMessage : "+statusMessage);
		return statusMessage;
	}
}
