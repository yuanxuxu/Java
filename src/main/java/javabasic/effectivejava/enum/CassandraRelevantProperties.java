
public enum CassandraRelevantProperties {
    CLOCK_GLOBAL("cassandra.clock", null),
    CLOCK_MONOTONIC_APPROX("cassandra.monotonic_clock.approx", null),
    ;

    private final String key;
    private final String defaultVal;

    CassandraRelevantProperties(String key) {
        this.key = key;
        this.defaultVal = null;
    }

    public interface PropertyConverter<T> {
        T convert(String value);
    }

    private final static PropertyConverter<String> STRING_CONVERTER = value -> value;

    CassandraRelevantProperties(String key, String defaultVal) {
        this.key = key;
        this.defaultVal = defaultVal;
    }

    public String getString() {
        String value = System.getProperty(key);

        return value == null ? defaultVal : STRING_CONVERTER.convert(value);
    }
}
