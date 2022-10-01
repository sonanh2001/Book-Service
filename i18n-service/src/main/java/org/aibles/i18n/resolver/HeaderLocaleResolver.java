package org.aibles.i18n.resolver;

import static org.springframework.http.HttpHeaders.ACCEPT_LANGUAGE;

import java.util.List;
import java.util.Locale;
import java.util.Locale.LanguageRange;
import javax.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aibles.i18n.constants.LanguageConstants;
import org.apache.commons.lang3.StringUtils;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;

@Slf4j
public class HeaderLocaleResolver extends AcceptHeaderLocaleResolver {
  @Override
  public Locale resolveLocale(HttpServletRequest request) {
    log.info("(resolveLocale)header : {}", request.getHeader(ACCEPT_LANGUAGE));
    if (StringUtils.isBlank(request.getHeader(ACCEPT_LANGUAGE))) {
      return Locale.getDefault();
    }
    List<LanguageRange> languageRanges =
        Locale.LanguageRange.parse(request.getHeader(ACCEPT_LANGUAGE));
    log.info("(resolveLocale)languageRanges : {}", languageRanges);
    return Locale.lookup(languageRanges, LanguageConstants.LOCALES);
  }
}
