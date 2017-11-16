package com.hotmart.suggest.api.exception;

public interface ApiErrorException {

	String getCode();
	
	String getDescription();
	
	int getHttpErrorCode();
	
}
