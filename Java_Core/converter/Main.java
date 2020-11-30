package converter;

import java.util.Date;

public class Main {

    public static void main(String[] args) {

        Date date = new Date();
        System.out.println("Date(java.util)  : " + date);
        System.out.println("LocalDate : " + ConverterDate.convertToLocalDate(date));
        System.out.println("LocalDateTime : " + ConverterDate.convertToLocalDateTime(date));
        System.out.println("LocalTime : " + ConverterDate.convertToLocalTime(date));
    }
}
