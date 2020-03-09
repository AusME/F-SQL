package name.ben.shepley.fsql.util;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Stream;

public enum StringCaseUtil {
    CAMEL {
        @Override
        public String transform(StringCaseUtil from, String string) {
            String[] words = from.parse(string);
            for (int i = 0; i < words.length; i ++) {
                words[i] = words[i].toLowerCase();
                if (i != 0) {
                    char[] letters = words[i].toCharArray();
                    letters[0] = Character.toUpperCase(letters[0]);
                    words[i] = new String(letters);
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            Stream.of(words).forEach(stringBuilder::append);
            return stringBuilder.toString();
        }

        @Override
        public String[] parse(String string) {
            if (!this.is(string)) {
                throw new StringFormatException("String does not appear to be camelCase.");
            }

            char[] letters = string.toCharArray();
            List<String> words = new LinkedList<>();
            StringBuilder wordBuilder = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {
                if (Character.isLowerCase(letters[i])) {
                    wordBuilder.append(letters[i]);
                } else if (Character.isUpperCase(letters[i])) {
                    words.add(wordBuilder.toString());
                    wordBuilder = new StringBuilder();
                    wordBuilder.append(letters[i]);
                }
            }
            words.add(wordBuilder.toString());

            return words.toArray(new String[0]);
        }

        @Override
        public boolean is(String string) {
            return string != null && !string.isEmpty() && string.matches("^[a-z]+([A-Z][a-z]+)+$");
        }

        @Override
        public String append(String string, String snippet) {
            if (!this.is(string)) {
                throw new StringFormatException("String does not appear to be camelCase.");
            }

            char[] letters = snippet.toLowerCase().toCharArray();
            letters[0] = Character.toUpperCase(letters[0]);
            return string + new String(letters);
        }

        @Override
        public String prepend(String snippet, String string) {
            if (!this.is(string)) {
                throw new StringFormatException("String does not appear to be camelCase.");
            }

            snippet = snippet.toLowerCase();
            char[] letters = string.toCharArray();
            letters[0] = Character.toUpperCase(letters[0]);
            return snippet + new String(letters);
        }

    },
    PASCAL {
        @Override
        public String transform(StringCaseUtil from, String string) {
            String[] words = from.parse(string);

            for (int i = 0; i < words.length; i ++) {
                words[i] = words[i].toLowerCase();
                char[] letters = words[i].toCharArray();
                letters[0] = Character.toUpperCase(letters[0]);
                words[i] = new String(letters);
            }

            StringBuilder stringBuilder = new StringBuilder();
            Stream.of(words).forEach(stringBuilder::append);
            return stringBuilder.toString();
        }

        @Override
        public String[] parse(String string) {
            if (!this.is(string)) {
                throw new StringFormatException("String does not appear to be PascalCase.");
            }

            char[] letters = string.toCharArray();
            List<String> words = new LinkedList<>();
            StringBuilder wordBuilder = new StringBuilder();

            wordBuilder.append(letters[0]);
            for (int i = 1; i < string.length(); i++) {
                if (Character.isLowerCase(letters[i])) {
                    wordBuilder.append(letters[i]);
                } else if (Character.isUpperCase(letters[i])) {
                    words.add(wordBuilder.toString());
                    wordBuilder = new StringBuilder();
                    wordBuilder.append(letters[i]);
                }
            }
            words.add(wordBuilder.toString());

            return words.toArray(new String[0]);
        }

        @Override
        public boolean is(String string) {
            return string != null && !string.isEmpty() && string.matches("^([A-Z][a-z]+)+$");
        }

        @Override
        public String append(String string, String snippet) {
            if (!this.is(string)) {
                throw new StringFormatException("String does not appear to be PascalCase.");
            }

            char[] letters = snippet.toLowerCase().toCharArray();
            letters[0] = Character.toUpperCase(letters[0]);
            return string + new String(letters);
        }

        @Override
        public String prepend(String snippet, String string) {
            if (!this.is(string)) {
                throw new StringFormatException("String does not appear to be PascalCase.");
            }

            snippet = snippet.toLowerCase();
            char[] letters = snippet.toCharArray();
            letters[0] = Character.toUpperCase(letters[0]);
            return new String(letters) + string;
        }

    },
    SNAKE {
        @Override
        public String transform(StringCaseUtil from, String string) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : from.parse(string)) {
                s = s.toLowerCase();
                stringBuilder.append(s).append("_");
            }
            return stringBuilder.substring(0, stringBuilder.length() -1);
        }

        @Override
        public String[] parse(String string) {
            if (!this.is(string)) {
                throw new StringFormatException("String does not appear to be snake_case.");
            }
            return string.split("_");
        }

        @Override
        public boolean is(String string) {
            return string != null && !string.isEmpty() && string.matches("^([A-Za-z]+_)+[A-Za-z]+$");
        }

        @Override
        public String append(String string, String snippet) {
            if (!this.is(string)) {
                throw new StringFormatException("String does not appear to be snake_case.");
            }
            return string + "_" + snippet.toLowerCase();
        }

        @Override
        public String prepend(String snippet, String string) {
            if (!this.is(string)) {
                throw new StringFormatException("String does not appear to be snake_case.");
            }
            return snippet.toLowerCase() + "_" + string;
        }

    },
    KEBAB {
        @Override
        public String transform(StringCaseUtil from, String string) {
            StringBuilder stringBuilder = new StringBuilder();
            for (String s : from.parse(string)) {
                s = s.toLowerCase();
                stringBuilder.append(s).append("-");
            }
            return stringBuilder.substring(0, stringBuilder.length() -1);
        }

        @Override
        public String[] parse(String string) {
            if (!this.is(string)) {
                throw new StringFormatException("String does not appear to be kebab-case.");
            }
            return string.split("-");
        }

        @Override
        public boolean is(String string) {
            return string != null && !string.isEmpty() && string.matches("^([A-Za-z]+-)+[A-Za-z]+$");
        }

        @Override
        public String append(String string, String snippet) {
            if (!this.is(string)) {
                throw new StringFormatException("String does not appear to be kebab-case.");
            }
            return string + "-" + snippet.toLowerCase();
        }

        @Override
        public String prepend(String snippet, String string) {
            if (!this.is(string)) {
                throw new StringFormatException("String does not appear to be kebab-case.");
            }
            return snippet.toLowerCase() + "-" + string;
        }
    };

    public abstract String transform(StringCaseUtil from, String string);
    public abstract String[] parse(String string);
    public abstract boolean is(String string);
    public abstract String append(String string, String snippet);
    public abstract String prepend(String snippet, String string);

    public static class StringFormatException extends RuntimeException {
        public StringFormatException(String message) {
            super(message);
        }
    }

    public static StringCaseUtil which(String string) {
        for (StringCaseUtil stringCase : values()) {
            if (stringCase.is(string)) {
                return stringCase;
            }
        }
        throw new StringFormatException("String format not understood.");
    }

    public static String convert(StringCaseUtil to, String string) {
        return to.transform(StringCaseUtil.which(string), string);
    }
}
