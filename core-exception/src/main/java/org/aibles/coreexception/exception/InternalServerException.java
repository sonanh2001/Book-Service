package org.aibles.coreexception.exception;

import org.springframework.http.HttpStatus;

public class InternalServerException extends BaseException {

  public InternalServerException() {
    super();
    setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    setCode("org.aibles.coreexception.exception.InternalServerException");
  }
}
