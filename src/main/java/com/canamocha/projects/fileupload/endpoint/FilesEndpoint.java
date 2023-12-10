package com.canamocha.projects.fileupload.endpoint;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.commons.io.FileUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.annotation.Validated;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import com.canamocha.projects.fileupload.model.UploadFileRequest;
import com.canamocha.projects.fileupload.model.UploadFileResponse;

import jakarta.validation.Valid;

@Endpoint
@Validated
public class FilesEndpoint {

	Logger logger = LoggerFactory.getLogger(FilesEndpoint.class);

	private static final String NAMESPACE_URI_MODEL = "http://canamocha.com/projects/fileUpload/model";

	private static final String UPLOAD_PATH = "C:\\Users\\CAnaMoCha\\targetFile.tmp";

	private static final long MEGABYTE = 1024L * 1024L;

	@PayloadRoot(namespace = NAMESPACE_URI_MODEL, localPart = "uploadFileRequest")
	@ResponsePayload
	public UploadFileResponse uploadFile(@RequestPayload @Valid UploadFileRequest request) {
		logger.info("Se recibe el texto: {} y fichero con logitud: {}", request.getInputText(),
				request.getFile().length);
		File targetFile = new File(UPLOAD_PATH);
		OutputStream outStream = null;
		try {
			outStream = new FileOutputStream(targetFile);
			outStream.write(request.getFile());

			logger.info("El fichero pesa: {}MB", bytesToMeg(FileUtils.sizeOf(targetFile)));

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		UploadFileResponse response = new UploadFileResponse();
		response.setOutputText(request.getInputText());

		return response;
	}

	private long bytesToMeg(long bytes) {
		return bytes / MEGABYTE;
	}
}