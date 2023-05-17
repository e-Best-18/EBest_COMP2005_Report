package org.example;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class DateChecker {

    public static boolean dateChecker(String date1, String date2) {
        LocalDateTime startDate = LocalDateTime.parse(date1);
        LocalDateTime endDate = LocalDateTime.parse(date2);
        long daysBetween = ChronoUnit.DAYS.between(startDate, endDate);
        if (daysBetween < 3 && startDate.isAfter(endDate)){
            return true;
        } else {
            return false;
        }
    }

}
