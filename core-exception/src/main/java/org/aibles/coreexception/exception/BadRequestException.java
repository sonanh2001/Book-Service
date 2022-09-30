package org.aibles.coreexception.exception;

import org.springframework.http.HttpStatus;

public class BadRequestException extends BaseException {

  public BadRequestException() {
    super();
    setStatus(HttpStatus.BAD_REQUEST.value());
    setCode("org.aibles.coreexception.exception.BadRequestException");
  }
}
