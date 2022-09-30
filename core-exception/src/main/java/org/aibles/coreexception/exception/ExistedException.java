package org.aibles.coreexception.exception;

public class ExistedException extends BadRequestException{

  public ExistedException(String field, Object value, String type) {
    super();
    setCode("org.aibles.coreexception.exception.ExistedException");
    addParams("field", field);
    addParams("value", value);
    addParams("type", type);
  }
}
