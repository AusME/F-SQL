package name.ben.shepley.fsql._framework;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.temporal.Temporal;
import java.util.Optional;

@SuppressWarnings("unchecked")
public final class CastingFactory {
    /* https://www.cis.upenn.edu/~bcpierce/courses/629/jdkdocs/guide/jdbc/getstart/mapping.doc.html */
    /*   String,
     *   Character,
     *   Boolean,
     *   byte[],
     *   Number (BigDecimal, Long, Integer, Short, Byte, Double, Float),
     *   Temporal (LocalDate, LocalTime LocalDateTime),
     *   Date (java.util.date, java.sql.date)
     */

    public <T> Optional<T> cast(Object from, Class<T> to) {
        /* FROM */
            /* TO */
            /* ELSE Optional.empty() */
        return Optional.empty();
    }

    private <T> T cast(String string, Class<T> to) {
        return null;
    }

    private <T> T cast(Character character, Class<T> to) {
        return null;
    }

    private <T> T cast(Boolean bool, Class<T> to) {
        return null;
    }

    private <T> T cast(Number number, Class<T> to) {
        return null;
    }

    private <T> T cast(byte[] bytes, Class<T> to) {
        return null;
    }

    private <T> T cast(Temporal temporal, Class<T> to) {
        return null;
    }

    private <T> T cast(java.util.Date date, Class<T> to) {
        return null;
    }
}
