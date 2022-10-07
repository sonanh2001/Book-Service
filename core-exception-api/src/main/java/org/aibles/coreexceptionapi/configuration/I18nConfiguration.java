package org.aibles.coreexceptionapi.configuration;

import org.aibles.coreexceptionapi.resolver.HeaderLocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class I18nConfiguration {
  @Bean
  public LocaleResolver localeResolver() {
    return new HeaderLocaleResolver();
  }

  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource =
        new ReloadableResourceBundleMessageSource();
    messageSource.setBasenames(
        "classpath:/i18n/book_api_message", "classpath:/i18n/core_exception_message");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }
}
