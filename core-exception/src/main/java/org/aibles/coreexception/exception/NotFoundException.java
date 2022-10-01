package org.aibles.coreexception.exception;

import org.springframework.http.HttpStatus;

public class NotFoundException extends BaseException {

  public NotFoundException(String field, Object value, String type) {
    super();
    setStatus(HttpStatus.NOT_FOUND.value());
    setCode("org.aibles.coreexception.exception.NotFoundException");
    addParams("field", field);
    addParams("value", value);
    addParams("type", type);
  }
}
