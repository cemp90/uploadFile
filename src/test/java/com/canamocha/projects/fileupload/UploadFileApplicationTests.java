package com.canamocha.projects.fileupload;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Base64;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.autoconfigure.webservices.server.WebServiceServerTest;
import org.springframework.core.io.Resource;
import org.springframework.util.ResourceUtils;
import org.springframework.ws.test.server.MockWebServiceClient;
import org.springframework.ws.test.server.RequestCreators;
import org.springframework.ws.test.server.ResponseMatchers;
import org.springframework.xml.transform.StringSource;

@WebServiceServerTest
class UploadFileApplicationTests {

	@Autowired
	private MockWebServiceClient client;

	private static InputStream fichero1;
	@Value("classpath:03793B_ES.pdf")
	private Resource fichero2;

	@BeforeAll
	public static void init() throws IOException {

		fichero1 = new FileInputStream(
				ResourceUtils.getFile("classpath:U-PJT_WASHER-AD_SimpleUX_WEB_OID39616_Spanish.pdf"));

	}

	@Test
	void uploadFile() throws IOException {
		final var request = "<mod:uploadFileRequest xmlns:mod=\"http://canamocha.com/projects/fileUpload/model\" ><mod:inputText>HOLA</mod:inputText><mod:file>"
				+ Base64.getEncoder().encodeToString(fichero2.getContentAsByteArray())
				+ "</mod:file></mod:uploadFileRequest>";

		this.client.sendRequest(RequestCreators.withPayload(new StringSource(request)))
				.andExpect(ResponseMatchers.noFault());

	}

	@Test
	void uploadFileFicheroPesado() throws IOException {
		final var request = "<mod:uploadFileRequest xmlns:mod=\"http://canamocha.com/projects/fileUpload/model\" ><mod:inputText>HOLA</mod:inputText><mod:file>"
				+ Base64.getEncoder().encodeToString(fichero1.readAllBytes()) + "</mod:file></mod:uploadFileRequest>";

		this.client.sendRequest(RequestCreators.withPayload(new StringSource(request)))
				.andExpect(ResponseMatchers.noFault());

	}

	@Test
	void uploadFileSinTexto() throws IOException {
		final var request = "<mod:uploadFileRequest xmlns:mod=\"http://canamocha.com/projects/fileUpload/model\" ><mod:file>"
				+ Base64.getEncoder().encodeToString(fichero2.getContentAsByteArray())
				+ "</mod:file></mod:uploadFileRequest>";

		this.client.sendRequest(RequestCreators.withPayload(new StringSource(request)))
				.andExpect(ResponseMatchers.noFault());

	}

	@Test
	void uploadFileSinFichero() {
		final var request = "<mod:uploadFileRequest xmlns:mod=\"http://canamocha.com/projects/fileUpload/model\" ><mod:inputText>HOLA</mod:inputText></mod:uploadFileRequest>";

		this.client.sendRequest(RequestCreators.withPayload(new StringSource(request)))
				.andExpect(ResponseMatchers.serverOrReceiverFault());

	}

	@Test
	void uploadFileSinTextoNiFichero() {
		final var request = "<mod:uploadFileRequest xmlns:mod=\"http://canamocha.com/projects/fileUpload/model\" ></mod:uploadFileRequest>";

		this.client.sendRequest(RequestCreators.withPayload(new StringSource(request)))
				.andExpect(ResponseMatchers.serverOrReceiverFault());

	}

}
