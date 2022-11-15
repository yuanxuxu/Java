package javabasic.effectivejava.enums;

enum TYPE {
    CAMERA, NOTCOVERED, COVERED
}

public enum Enum {

    JAVA_HOME("java.home"),
    CASSANDRA_PID_FILE("cassandra-pidfile");

    private final String key;
    private final String defaultVal;

    Enum(String key) {
        this.key = key;
        defaultVal = null;
    }

    Enum(String key, String defaultVal) {
        this.key = key;
        this.defaultVal = defaultVal;
    }
}
