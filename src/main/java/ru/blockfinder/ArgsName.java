package ru.blockfinder;

import java.util.HashMap;
import java.util.Map;

public class ArgsName {
    private final Map<String, String> values = new HashMap<>();

    /**
     * Method gets value from key after checking key value for format.
     *
     * @param key
     * @return value
     */
    public String get(String key) {
        if (values.get(key) == null) {
            String message = String.format("This key: '%s' is missing", key);
            throw new IllegalArgumentException(message);
        }
        return values.get(key);
    }

    /**
     * Method puts reads String[], parse it into key-value pares and puts them into values Map.
     *
     * @param args
     */
    private void parse(String[] args) {
        for (String arg : args) {
            checkArg(arg);
            String[] parseArg = arg.split("=", 2);
            String key = parseArg[0].split("-")[1];
            String value = parseArg[1];
            values.put(key, value);
        }
        validateFunction();
    }



    /**
     * Method creates new values Map by parsing String[] args after checking key value for format
     * and puts into values map.
     *
     * @param args
     * @return
     */
    public static ArgsName of(String[] args) {
        if (args.length == 0) {
            throw new IllegalArgumentException("Arguments not passed to program");
        }
        ArgsName names = new ArgsName();
        names.parse(args);
        return names;
    }

    /**
     * Method checks for proper argument format. String starts with "-", first "=" is delimiter.
     * Key and values should be present.
     *
     * @param arg
     * @return
     */
    private static boolean checkArg(String arg) {
        if (!arg.contains("=")) {
            String message = String.format("Error: This argument '%s' does not contain an equal sign", arg);
            throw new IllegalArgumentException(message);
        }
        String[] checkArg = arg.split("=");
        if (!checkArg[0].startsWith("-")) {
            String message = String.format("Error: This argument '%s' does not start with a '-' character", arg);
            throw new IllegalArgumentException(message);
        }
        if (checkArg[0].split("-").length < 2) {
            String message = String.format("Error: This argument '%s' does not contain a key", arg);
            throw new IllegalArgumentException(message);
        }
        if (checkArg.length < 2) {
            String message = String.format("Error: This argument '%s' does not contain a value", arg);
            throw new IllegalArgumentException(message);
        }
        String[] parseArg = arg.split("=", 2);
        String key = parseArg[0].split("-")[1];
        String value = parseArg[1];
        if (key.equals("f") && (!value.equals("chunk") && !value.equals("tag") && !value.equals("unique") && !value.equals("try"))) {
            String message = String.format("Error: This -f argument: '%s' can only be \"chunk\", \"tag\" or \"unique\"", arg);
            throw new IllegalArgumentException(message);
        }
        return true;
    }

    private void validateFunction() {
        var function = values.get("f");
        if (function.equals("tag") || function.equals("chunk")) {
            var searchValue = values.get("s");
            if (searchValue == null) {
                String message = "cannot find '-s' parameter";
                throw new IllegalArgumentException(message);
            }
        }
    }
}
