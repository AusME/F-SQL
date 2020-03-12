package name.ben.shepley.fsql._framework;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.Optional;

@SuppressWarnings("unchecked")
public enum CastingFactory {
    SINGLETON;
    /* https://www.cis.upenn.edu/~bcpierce/courses/629/jdkdocs/guide/jdbc/getstart/mapping.doc.html */

    /*   String,
     *   char Character,
     *   boolean Boolean,
     *   byte[] Byte[],
     *   Number: (BigDecimal, Long, Integer, Short, Byte, Double, Float),
     *   Temporal (LocalDate, LocalTime LocalDateTime),
     *   Date (java.util.date, java.sql.date)
     */


    public static <T> Optional<T> cast(String from, Class<T> to) {
        if (from == null || to == null) {
            return Optional.empty();
        } else if (to == char.class || to == Character.class) {
            return (Optional<T>) Optional.of(from.charAt(0));
        } else if (to == boolean.class || to == Boolean.class) {
            return (Optional<T>) Optional.of(from.equalsIgnoreCase("true") || from.equalsIgnoreCase("Y") || from.equalsIgnoreCase("YES"));
        } else if (to == byte[].class || to == Byte[].class) {
            return (Optional<T>) Optional.of(from.getBytes());
        } else if (to.cast(Number.class) instanceof Number) {
            System.out.println("yay");
            return Optional.empty();
        } else {
            return Optional.empty();
        }
    }

    public static <T> Optional<T> cast(Character from, Class<T> to) {
        return Optional.empty();
    }

    public static <T> Optional<T> cast(Boolean from, Class<T> to) {
        return Optional.empty();
    }

    public static <T> Optional<T> cast(Number from, Class<T> to) {
        return Optional.empty();
    }

    public static <T> Optional<T> cast(Temporal from, Class<T> to) {
        return Optional.empty();
    }

    public static <T> Optional<T> cast(java.util.Date from, Class<T> to) {
        return Optional.empty();
    }

    public static <T> Optional<T> cast(byte[] from, Class<T> to) {
        return Optional.empty();
    }
}