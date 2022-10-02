package org.aibles.coreexceptionapi.configuration;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.aibles.coreexceptionapi.controller.advice.BaseExceptionHandler;
import org.springframework.context.annotation.Import;

@Import(BaseExceptionHandler.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
public @interface EnableExceptionHandler {

}
