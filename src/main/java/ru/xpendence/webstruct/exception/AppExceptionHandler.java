package ru.xpendence.webstruct.exception;

import org.hibernate.exception.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * Author: Vyacheslav Chernyshov
 * Date: 21.09.18
 * Time: 9:26
 * e-mail: 2262288@gmail.com
 */
@ControllerAdvice
public class AppExceptionHandler extends ResponseEntityExceptionHandler {

    @ResponseBody
    @ExceptionHandler(DatabaseException.class)
    public ResponseEntity<String> handle(DatabaseException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }

    @ResponseBody
    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<String> handle(ConstraintViolationException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.OK);
    }
}
