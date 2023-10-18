package lesson_35._02_newDate;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoField;
import java.util.Date;

public class Main {
    public static void main(String[] args) {
        LocalDate newYer2023 = LocalDate.of(2023,1,1);
        System.out.println("newYer2023 = " + newYer2023);
        LocalDate newYer2024 = LocalDate.of(2024, Month.JANUARY,1);
        System.out.println("newYer2024 = " + newYer2024);
        LocalDate now = LocalDate.now();
        System.out.println("now = " + now);

        System.out.println(now.getYear());
        System.out.println(now.getMonthValue());
        System.out.println(now.getDayOfMonth());
        System.out.println(now.getMonth());
        System.out.println(now.getDayOfWeek());
        System.out.println(now.get(ChronoField.YEAR));

        System.out.println("isBefore = " + newYer2023.isBefore(newYer2024));

        LocalDate year2025 = newYer2023.withYear(2025); //исходник не изменяется
        System.out.println("withYear = " + year2025);

        LocalDate plusDays10 = newYer2023.plusDays(10);
        System.out.println("plusDays10 = " + plusDays10);

        LocalDate minus10 = newYer2023.minusDays(10);
        System.out.println("minus10 = " + minus10);

        System.out.println("===========LocalDateTime================");
        LocalDateTime now1 = LocalDateTime.now();
        System.out.println(now1.format(DateTimeFormatter.ofPattern("dd MMMM y 'Time' HH:mm:ss")));


    }
}
