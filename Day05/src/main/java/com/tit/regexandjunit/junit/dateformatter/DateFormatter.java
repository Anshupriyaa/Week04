package com.tit.regexandjunit.junit.dateformatter;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class DateFormatter {

    public static String formatDate(String inputDate) {
        if (inputDate == null || inputDate.isEmpty()) {
            throw new IllegalArgumentException("Input date cannot be null or empty");
        }

        try {
            // Parse input date (yyyy-MM-dd format)
            LocalDate date = LocalDate.parse(inputDate, DateTimeFormatter.ofPattern("yyyy-MM-dd"));

            // Format to dd-MM-yyyy
            return date.format(DateTimeFormatter.ofPattern("dd-MM-yyyy"));
        } catch (DateTimeParseException e) {
            throw new IllegalArgumentException("Invalid date format Expected yyyy-MM-dd.");
        }
    }
}
