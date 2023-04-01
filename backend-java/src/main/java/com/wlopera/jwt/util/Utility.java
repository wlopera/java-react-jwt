package com.wlopera.jwt.util;

import org.springframework.http.HttpStatus;

import com.wlopera.jwt.model.Data;
import com.wlopera.jwt.model.Response;

public class Utility {
	public static Response getResponse(Data data) {
		Response response = new Response();

		response.setCode(HttpStatus.OK);
		response.setSuccess(true);
		response.setError(null);
		response.setMessage("OK");
		response.setTraceId(java.util.UUID.randomUUID().toString());
		response.setData(data);

		return response;

	}

}
