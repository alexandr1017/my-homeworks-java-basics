package org.example.util;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class FormatterDateTime {

    public static String fromLocalDateTimeToStr(LocalDateTime dateTime){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String myDateTimeString = dateTime.format(formatter);
        return myDateTimeString;
    }
}
