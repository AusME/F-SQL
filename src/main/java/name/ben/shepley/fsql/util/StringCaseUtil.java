package name.ben.shepley.fsql.util;

import java.util.LinkedList;
import java.util.List;

public enum StringCaseUtil {
    CAMEL {
        @Override
        public String convert(StringCaseUtil from, String string) {
            String[] words = from.parse(string);
            for (int i = 0; i < words.length; i ++) {
                if (i == 0) {
                    words[i] = words[i].toLowerCase();
                } else {
                    words[i] = words[i].toLowerCase();
                    char[] letters = words[i].toCharArray();
                    letters[0] = Character.toUpperCase(letters[0]);
                    words[i] = new String(letters);
                }
            }

            StringBuilder stringBuilder = new StringBuilder();
            for (String s : words) {
                stringBuilder.append(s);
            }

            return stringBuilder.toString();
        }

        @Override
        public String[] parse(String string) {
            if (string == null || string.isEmpty()) {
                return new String[0];
            } else if (!this.is(string)) {
                return new String[0];
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
            if (string == null || string.isEmpty()) {
                return false;
            }

            char[] letters = string.toCharArray();

            if (!Character.isLowerCase(letters[0])) {
                return false;
            }

            for (int i = 1; i < string.length(); i++) {
                if (!Character.isLowerCase(letters[i]) && !Character.isUpperCase(letters[i])) {
                    return false;
                }
            }

            return true;
        }

    },
    PASCAL {
        @Override
        public String convert(StringCaseUtil from, String string) {

            return null;
        }

        @Override
        public String[] parse(String string) {
            if (string == null || string.isEmpty()) {
                return new String[0];
            } else if (!this.is(string)) {
                return new String[0];
            }

            char[] letters = string.toCharArray();
            List<String> words = new LinkedList<>();
            StringBuilder wordBuilder = new StringBuilder();
            for (int i = 0; i < string.length(); i++) {

            }

            return words.toArray(new String[0]);
        }

        @Override
        public boolean is(String string) {
            return false;
        }

    },
    SNAKE {
        @Override
        public String convert(StringCaseUtil from, String string) {
            return null;
        }

        @Override
        public String[] parse(String string) {
            if (string == null || string.isEmpty()) {
                return new String[0];
            } else if (!this.is(string)) {
                return new String[0];
            } else {
                return string.split("_");
            }
        }

        @Override
        public boolean is(String string) {
            return false;
        }
    },
    KEBAB {
        @Override
        public String convert(StringCaseUtil from, String string) {
            return null;
        }

        @Override
        public String[] parse(String string) {
            if (string == null || string.isEmpty()) {
                return new String[0];
            } else if (!this.is(string)) {
                return new String[0];
            } else {
                return string.split("-");
            }
        }

        @Override
        public boolean is(String string) {
            return false;
        }
    };

    public abstract String convert(StringCaseUtil from, String string);
    public abstract String[] parse(String string);
    public abstract boolean is(String string);
}
