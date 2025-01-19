public class Column {
    private String name;
    private String type;
    private boolean notNull;
    private String defaultValue;


    public Column(String name, String type, boolean notNull, String defaultValue) {
        this.name = name;
        this.type = type;
        this.notNull = notNull;
        this.defaultValue = defaultValue;
    }


    public String getName() {
        return name;
    }

    public String getType() {
        return type;
    }

    public boolean isNotNull() {
        return notNull;
    }

    public String getDefaultValue() {
        return defaultValue;
    }
}
