package name.ben.shepley.fsql.framework;

import java.math.BigDecimal;
import java.time.LocalDate;

public final class CastingFactory {
    /* String, Boolean, Number (BigDecimal, Long, Integer, Short, Byte, Double, Float), LocalDate, Character, Object */
    public static <T> T cast(Object from, Class<T> to) {
        if (to == String.class) {
            if (from instanceof String) {
                return (T) (String) from;
            } else if (from instanceof Boolean) {
                return (T) Boolean.toString(Boolean.valueOf((boolean) from));
            } else if (from instanceof Number) {
                return (T) from.toString();
            } else if (from instanceof LocalDate) {
                return (T) from.toString();
            } else if (from instanceof Character) {
                return (T) from.toString();
            } else if (from instanceof Object) {
                return (T) from.toString();
            }
        }  else if (to == Byte.class) {
            if (from instanceof String) {
                return (T) Byte.valueOf(Byte.parseByte((String) from));
            } else if (from instanceof Boolean) {
                return (((Boolean) from) == false)?  (T) Byte.valueOf((byte) 0) : (T) Byte.valueOf((byte) 1);
            } else if (from instanceof Number) {
                byte b = ((Number) from).byteValue();
                return (T) Byte.valueOf(b);
            } else if (from instanceof LocalDate) {
                throw new ClassCastException("I don't like you.");
            } else if (from instanceof Character) {
                throw new ClassCastException("I don't like you, either.");
            } else if (from instanceof Object) {
                throw new ClassCastException("I don't like you, more.");
            }
        } else if (to == Double.class) {
            if (from instanceof String) {
                return (T) Double.valueOf(Double.parseDouble((String) from));
            } else if (from instanceof Boolean) {
                return (((Boolean) from) == false)? (T) Double.valueOf(0) : (T) Double.valueOf(1);
            } else if (from instanceof Number) {
                double d = ((Number) from).doubleValue();
                return (T) Double.valueOf(d);
            } else if (from instanceof LocalDate) {
                throw new ClassCastException("I don't like you.");
            } else if (from instanceof Character) {
                throw new ClassCastException("I don't like you, either.");
            } else if (from instanceof Object) {
                throw new ClassCastException("I don't like you, more.");
            }
        } else if (to == Float.class) {
            if (from instanceof String) {
                return (T) Float.valueOf(Float.parseFloat((String) from));
            } else if (from instanceof Boolean) {
                return (((Boolean) from) == false)? (T) Float.valueOf(0) : (T) Float.valueOf(1);
            } else if (from instanceof Number) {
                float f = ((Number) from).floatValue();
                return (T) Float.valueOf(f);
            } else if (from instanceof LocalDate) {
                throw new ClassCastException("I don't like you.");
            } else if (from instanceof Character) {
                throw new ClassCastException("I don't like you, either.");
            } else if (from instanceof Object) {
                throw new ClassCastException("I don't like you, more.");
            }
        } else if (to == Integer.class) {
            if (from instanceof String) {
                return (T) Integer.valueOf(Integer.parseInt((String) from));
            } else if (from instanceof Boolean) {
                return (((Boolean) from) == false)? (T) Integer.valueOf(0) : (T) Integer.valueOf(1);
            } else if (from instanceof Number) {
                int i = ((Integer) from).intValue();
                return (T) Integer.valueOf(i);
            } else if (from instanceof LocalDate) {
                throw new ClassCastException("I don't like you.");
            } else if (from instanceof Character) {
                throw new ClassCastException("I don't like you, either.");
            } else if (from instanceof Object) {
                throw new ClassCastException("I don't like you, more.");
            }
        } else if (to == Short.class) {
            if (from instanceof String) {
                return (T) Short.valueOf(Short.parseShort((String) from));
            } else if (from instanceof Boolean) {
                return (((Boolean) from) == false)? (T) Short.valueOf((short) 0) : (T) Double.valueOf((short) 1);
            } else if (from instanceof Number) {
                short s = ((Number) from).shortValue();
                return (T) Short.valueOf(s);
            } else if (from instanceof LocalDate) {
                throw new ClassCastException("I don't like you.");
            } else if (from instanceof Character) {
                throw new ClassCastException("I don't like you, either.");
            } else if (from instanceof Object) {
                throw new ClassCastException("I don't like you, more.");
            }
        } else if (to == Long.class) {
            if (from instanceof String) {
                return (T) Long.valueOf(Long.parseLong((String) from));
            } else if (from instanceof Boolean) {
                return (((Boolean) from) == false)? (T) Long.valueOf(0) : (T) Long.valueOf(1);
            } else if (from instanceof Number) {
                long l = ((Number) from).longValue();
                return (T) Long.valueOf(l);
            } else if (from instanceof LocalDate) {
                throw new ClassCastException("I don't like you.");
            } else if (from instanceof Character) {
                throw new ClassCastException("I don't like you, either.");
            } else if (from instanceof Object) {
                throw new ClassCastException("I don't like you, more.");
            }
        } else if (to == Boolean.class) {

        } else if (to == BigDecimal.class) {

        } else if (to == Character.class) {

        } else if (to == Object.class) {

        }

        throw new RuntimeException("This is impossible. Prove me wrong, Children");
    }
}
