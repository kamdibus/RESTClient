package client;

import java.io.StringWriter;
import java.net.URI;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.TransformerFactoryConfigurationError;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

/**
 * 
 * @author Kamil Bidus
 *
 */
public class ClientClass {

	private Client client;
	private URI uri;

	private WebTarget webTarget;

	private String response;
	private String plainAnswer;
	private String htmlAnswer;
	private String xmlAnswer;

	/**
	 * Default ctor sets all necessery parameters for connecting RESTApi. Then
	 * it saves the responses in appropriate strings.
	 */
	public ClientClass() {
		client = ClientBuilder.newClient();
		uri = UriBuilder.fromUri("http://localhost:8001/RESTApi/student").build();
		webTarget = client.target(uri);

		response = webTarget.request().accept(MediaType.TEXT_HTML).get(Response.class).toString();

		plainAnswer = webTarget.request().accept(MediaType.TEXT_PLAIN).get(String.class);

		htmlAnswer = webTarget.request().accept(MediaType.TEXT_HTML).get(String.class);

		try {
			DOMSource source = webTarget.request().accept(MediaType.APPLICATION_XML).get(DOMSource.class);
			Transformer transformer = TransformerFactory.newInstance().newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			StreamResult result = new StreamResult(new StringWriter());
			transformer.transform(source, result);
			xmlAnswer = result.getWriter().toString();
		} catch (TransformerFactoryConfigurationError e) {
			System.err.println(e.getMessage());
			xmlAnswer = "An error has occured during formatting xml answer";
		} catch (TransformerException e) {
			System.err.println(e.getMessage());
			xmlAnswer = "An error has occured during formatting xml answer";
		}

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

	public String getPlainAnswer() {
		return plainAnswer;
	}

	public void setPlainAnswer(String plainAnswer) {
		this.plainAnswer = plainAnswer;
	}

	public String getHtmlAnswer() {
		return htmlAnswer;
	}

	public void setHtmlAnswer(String htmlAnswer) {
		this.htmlAnswer = htmlAnswer;
	}

}
