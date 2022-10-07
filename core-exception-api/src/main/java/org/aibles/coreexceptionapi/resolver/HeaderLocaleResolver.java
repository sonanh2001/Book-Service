package org.aibles.coreexceptionapi.resolver;

import static org.springframework.http.HttpHeaders.ACCEPT_LANGUAGE;

import java.util.List;
import java.util.Locale;
import java.util.Locale.LanguageRange;
import javax.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.aibles.coreexceptionapi.constants.LanguageConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Component
@Slf4j
@RequiredArgsConstructor
public class HeaderLocaleResolver extends AcceptHeaderLocaleResolver {

  @Override
  public Locale resolveLocale(HttpServletRequest request) {
    log.info("(resolveLocale)header : {}", request.getHeader(ACCEPT_LANGUAGE));
    String language = request.getHeader(ACCEPT_LANGUAGE);
    if(language == null || StringUtils.isBlank(language)) {
      return Locale.getDefault();
    }
    List<LanguageRange> languageRanges = Locale.LanguageRange.parse(language);
    return Locale.lookup(languageRanges, LanguageConstants.LOCALES);
  }
}
