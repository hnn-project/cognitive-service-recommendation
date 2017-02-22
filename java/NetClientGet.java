import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class NetClientGet {

	// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) {

		try {

			URL url = new URL(
					"https://westus.api.cognitive.microsoft.com/recommendations/v4.0/models/<MODEL-ID>/recommend/item?itemIds=K4W-00033&numberOfResults=5&buildId=1611627&includeMetadata=false&minimalScore=0");
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("GET");
			//conn.setRequestProperty("Accept", "application/json");
			conn.setRequestProperty("Accept", "application/json, text/javascript, /; q=0.01");
			conn.setRequestProperty("Ocp-Apim-Subscription-Key", "<API-KEY>");
			conn.setRequestProperty("Referer", "https://recommendations-portal.azurewebsites.net/");
			conn.setRequestProperty("Accept-Language", "ko");
			conn.setRequestProperty("Origin", "https://recommendations-portal.azurewebsites.net");
			conn.setRequestProperty("Accept-Encoding", "gzip, deflate, peerdist");
			conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.79 Safari/537.36 Edge/14.14393");
			conn.setRequestProperty("Host", "westus.api.cognitive.microsoft.com");
			conn.setRequestProperty("Connection", "Keep-Alive");
			conn.setRequestProperty("X-P2P-PeerDist", "Version=1.1");
			conn.setRequestProperty("X-P2P-PeerDistEx", "MinContentInformation=1.0, MaxContentInformation=2.0");

			if (conn.getResponseCode() != 200) {
				throw new RuntimeException("Failed : HTTP error code : " + conn.getResponseCode());
			}

			BufferedReader br = new BufferedReader(new InputStreamReader((conn.getInputStream())));

			String output;
			//System.out.println("Output from Server .... \n");
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}

			conn.disconnect();

		} catch (MalformedURLException e) {

			e.printStackTrace();

		} catch (IOException e) {

			e.printStackTrace();

		}

	}

}