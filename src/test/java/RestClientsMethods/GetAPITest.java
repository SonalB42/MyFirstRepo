package RestClientsMethods;

import java.io.IOException;
import java.util.HashMap;

import org.apache.http.Header;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.qa.FreeCRM.TestBase.TestBaseAPI;

public class GetAPITest extends TestBaseAPI
{
	String serviceURL;
	String apiURL;
	String URL;
	RestClient restClient;
	CloseableHttpResponse closeableHttpResponse;
	
	public GetAPITest()
	{
		super();
		
	}
	
	@BeforeMethod
	public void setUp()
	{
		serviceURL=prop.getProperty("ServiceURL");
		apiURL=prop.getProperty("ApiURL");
		URL=serviceURL + apiURL;
		
	}
	
	@Test
	public void getAPITest() throws ClientProtocolException, IOException, JSONException
	{
		restClient=new RestClient();
		closeableHttpResponse=restClient.get(URL);
		
		//a. Status Code
				int statusCode=closeableHttpResponse.getStatusLine().getStatusCode();
				System.out.println("Status Code--->"+statusCode);
				Assert.assertEquals(statusCode,Resonse_Status_Code_200,"Status code is not 200");
			
				//b. JSON String
				String responseString=EntityUtils.toString(closeableHttpResponse.getEntity(),"UTF-8");
				JSONObject responseJSON=new JSONObject(responseString);
				System.out.println("Response JSON from API--->"+responseJSON);
				/*JSONObject getSth=responseJSON.getJSONObject("get");
				Object level=getSth.get("3");
				System.out.println("Level--->"+level);*/
				
				//c. All Headers
				Header[] headersArray=closeableHttpResponse.getAllHeaders();
				
				HashMap<String,String> allHeaders=new HashMap<String,String>();
				
				for(Header header:headersArray)
				{
					allHeaders.put(header.getName(), header.getValue());
					
				}
				System.out.println("Header Array--->"+allHeaders);

		
	}
	
	
}
