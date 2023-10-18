package lesson_35._01_oldDate;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws ParseException {
        System.out.println("================Date=================");
        Date now = new Date();
        System.out.println("now" + now);                 // время в данный момент
        System.out.println("getTime= " + now.getTime()); // время в миллисекундах

        Date now2 = new Date(123456789); //в миллисекундах
        System.out.println("before = " + now.before(now2));
        System.out.println("after = " + now.after(now2));

        System.out.println("compareTo = " + now.compareTo(now2));

        java.sql.Date sqlDate = new java.sql.Date(12345678901541l);
        System.out.println("sqlDate = " + sqlDate);

        System.out.println("================Calendar=================");
        Calendar calendar = Calendar.getInstance();
        System.out.println("День = " + calendar.get(6));
        calendar.set(Calendar.YEAR, 2024);
        System.out.println("getTime = " + calendar.getTime());

        calendar.add(Calendar.MONTH, 1); // +1 месяц
        System.out.println("добавили месяц " + calendar.getTime());
        calendar.add(Calendar.MONTH, -1); // -1 месяц
        System.out.println("удалили месяц " + calendar.getTime());

        System.out.println("=========SimpleDateFormat========");
        SimpleDateFormat format = new SimpleDateFormat();
        String formatterDate = format.format(new Date());
        System.out.println(formatterDate);

        String pattern = "dd-MMMM-y  HH:mm:ss";  //'aaa' - любой дилимитр
        SimpleDateFormat format1 = new SimpleDateFormat(pattern);
        System.out.println("format1 " + format1.format(new Date()));

        System.out.println("========parse===========");
        String someDAte = "15-06-1990";
        String pattern2 = "dd-MM-y";
        SimpleDateFormat format2 = new SimpleDateFormat(pattern2);
        Date date = format2.parse(someDAte);
        System.out.println("format2 = " + date);


    }
}
