package org.aibles.bookservice.util;

import java.time.LocalDateTime;

public class DateUtil {
  private static final int DECIMAL_LIMIT = 10;

  private static final String ZERO_VALUE = "0";
  public static Integer convertLocalDateTimeToInteger(LocalDateTime localDateTime) {
    String year = Integer.toString(localDateTime.getYear());
    String month = Integer.toString(localDateTime.getMonthValue());
    String day = Integer.toString(localDateTime.getDayOfMonth());
    if(localDateTime.getMonthValue() < DECIMAL_LIMIT) {
      month = ZERO_VALUE + month;
    }
    if(localDateTime.getDayOfMonth() < DECIMAL_LIMIT) {
      day = ZERO_VALUE + day;
    }

    return Integer.parseInt(year + month + day);
  }
}
