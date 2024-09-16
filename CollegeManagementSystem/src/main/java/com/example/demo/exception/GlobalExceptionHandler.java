package com.example.demo.exception;

import org.apache.coyote.BadRequestException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.example.demo.payload.responce.MessageResponse;

public class GlobalExceptionHandler {
	 @ExceptionHandler(ResourceNotFoundException.class)
	    public ResponseEntity<String> handleResourceNotFound(ResourceNotFoundException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	    }

	    @ExceptionHandler(BadRequestException.class)
	    public ResponseEntity<String> handleBadRequest(BadRequestException ex) {
	        return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	    }
	    @ExceptionHandler(UsernameAlreadyTakenException.class)
	    public ResponseEntity<?> handleUsernameAlreadyTakenException(UsernameAlreadyTakenException ex) {
	        return ResponseEntity
	                .badRequest()
	                .body(new MessageResponse(ex.getMessage()));
	    }

	    @ExceptionHandler(EmailAlreadyInUseException.class)
	    public ResponseEntity<?> handleEmailAlreadyInUseException(EmailAlreadyInUseException ex) {
	        return ResponseEntity
	                .badRequest()
	                .body(new MessageResponse(ex.getMessage()));
	    }

	    @ExceptionHandler(AuthenticationException.class)
	    public ResponseEntity<?> handleAuthenticationException(AuthenticationException ex) {
	        return ResponseEntity
	                .badRequest()
	                .body(new MessageResponse(ex.getMessage()));
	    }

	    @ExceptionHandler(RuntimeException.class)
	    public ResponseEntity<?> handleRuntimeException(RuntimeException ex) {
	        return ResponseEntity
	                .status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body(new MessageResponse("An unexpected error occurred: " + ex.getMessage()));
	    }

}
