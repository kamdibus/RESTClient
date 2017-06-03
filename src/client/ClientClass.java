package client;

import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriBuilder;

public class ClientClass {
	
	private Client client;
//	URI uri = UriBuilder.fromUri("http://localhost:8001/RESTApi").queryParam("idx", "12345").build();
	private URI uri;
	// URI uri = UriBuilder.fromUri("http://localhost:8080/proz")
	// .queryParam("idx", "12345").build();
	// URI uri = URI.create(http://localhost:8080/proz);

	private WebTarget webTarget;

//	webTarget = webTarget.path("student");
	public String response;
//	String plainAnswer = webTarget.request().accept(MediaType.TEXT_PLAIN).get(String.class);
//	String htmlAnswer = webTarget.request().accept(MediaType.TEXT_HTML).get(String.class);
	private String xmlAnswer;
	
	public ClientClass() {
		client = ClientBuilder.newClient();
		uri = UriBuilder.fromUri("http://localhost:8001/RESTApi/student").build();
		webTarget = client.target(uri);
		xmlAnswer = webTarget.request().accept(MediaType.APPLICATION_XML).get(String.class);
//		response = webTarget.request().accept(MediaType.TEXT_PLAIN).get(Response.class).toString();
	}

	public String getXmlAnswer() {
		return xmlAnswer;
	}

	public void setXmlAnswer(String xmlAnswer) {
		this.xmlAnswer = xmlAnswer;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
}
