/**
 * 
 */
package com.resturantservice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * 
 */
public class ResponseController {

	public  ResponseEntity<Object> handleError(Exception ex) {
		HttpStatus httStatusCode = HttpStatus.NOT_FOUND;
		if(ex.getMessage().contains(ErrorCode.NOT_FOUND)) {
			httStatusCode = HttpStatus.NOT_FOUND;
		}
		else if(ex.getMessage().contains(ErrorCode.INTERNAL_SERVER_ERROR)) {
			httStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
		}
		else if(ex.getMessage().contains(ErrorCode.NO_CONTENT)) {
			httStatusCode = HttpStatus.NO_CONTENT;
		}
		else if(ex.getMessage().contains(ErrorCode.BAD_REQUEST)) {
			httStatusCode = HttpStatus.BAD_REQUEST;
		}
		else if(ex.getMessage().contains(ErrorCode.FORBIDDEN)) {
			httStatusCode = HttpStatus.FORBIDDEN;
		}
		return ResponseEntity.status(httStatusCode).build();
	}
	
	public ResponseEntity<Object> handleResponse(Object object){
		return ResponseEntity.ok(object);
	}
}
