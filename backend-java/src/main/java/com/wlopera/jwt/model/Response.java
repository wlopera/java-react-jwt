package com.wlopera.jwt.model;

import java.io.Serializable;

import org.springframework.http.HttpStatus;

@SuppressWarnings("serial")
public class Response implements Serializable {
	
	private Boolean success;
	private HttpStatus code;
	private String message;
	private String traceId;
	private String error;
	private Data data;

	public Boolean getSuccess() {
		return success;
	}

	public void setSuccess(Boolean success) {
		this.success = success;
	}

	public HttpStatus getCode() {
		return code;
	}

	public void setCode(HttpStatus code) {
		this.code = code;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getTraceId() {
		return traceId;
	}

	public void setTraceId(String traceId) {
		this.traceId = traceId;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public Data getData() {
		return data;
	}

	public void setData(Data data) {
		this.data = data;
	}

	@Override
	public String toString() {
		return "Response [" + (success != null ? "success=" + success + ", " : "")
				+ (code != null ? "code=" + code + ", " : "") + (message != null ? "message=" + message + ", " : "")
				+ (traceId != null ? "traceId=" + traceId + ", " : "") + (error != null ? "error=" + error + ", " : "")
				+ (data != null ? "data=" + data : "") + "]";
	}
}
