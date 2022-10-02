package org.aibles.i18n.configuration;

import java.util.Locale;
import org.aibles.i18n.resolver.HeaderLocaleResolver;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class I18nConfiguration {
  @Bean
  public LocaleResolver localeResolver() {
    HeaderLocaleResolver headerLocaleResolver = new HeaderLocaleResolver();
    headerLocaleResolver.setDefaultLocale(new Locale("en"));
    return headerLocaleResolver;
  }

  @Bean
  public MessageSource messageSource() {
    ReloadableResourceBundleMessageSource messageSource =
        new ReloadableResourceBundleMessageSource();
    messageSource.setBasenames(
        "classpath:/i18n/message_validation", "classpath:/i18n/message_core_exception");
    messageSource.setDefaultEncoding("UTF-8");
    return messageSource;
  }
}
