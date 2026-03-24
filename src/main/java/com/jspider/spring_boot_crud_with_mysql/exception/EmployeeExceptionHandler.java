package com.jspider.spring_boot_crud_with_mysql.exception;

import java.util.HashMap;
import java.util.Map;
import java.util.List;

import com.jspider.spring_boot_crud_with_mysql.controller.EmployeeController;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class EmployeeExceptionHandler {

    private final EmployeeController employeeController;

    EmployeeExceptionHandler(EmployeeController employeeController) {
        this.employeeController = employeeController;
    }

	@ExceptionHandler(value = MethodArgumentNotValidException.class)
	public ResponseEntity<?> methodArgumentNotValidException(MethodArgumentNotValidException exception) {

		Map<String, String> errorMap = new HashMap<>();

//		FieldError fieldError = exception.getBindingResult().getFieldError();

		List<ObjectError> errors = exception.getAllErrors();

		for (ObjectError objectError : errors) {
			String message=objectError.getDefaultMessage();
			String fieldName=((FieldError) objectError).getField();
			errorMap.put(fieldName, message);
		}
		
//		String fieldName = fieldError.getField();
//		String message = fieldError.getDefaultMessage();
//		errorMap.put(fieldName, message);

		return ResponseEntity.badRequest().body(errorMap);
	}
	
	@ExceptionHandler(value = RuntimeException.class)
	public ResponseEntity<?> runTimeException(RuntimeException exception) {
		String message = exception.getMessage();
		exception.printStackTrace();
		return ResponseEntity.badRequest().body(message);
	}

}
