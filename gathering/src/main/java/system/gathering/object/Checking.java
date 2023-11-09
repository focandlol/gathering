package system.gathering.object;

public enum Checking {
    CHECKED("Checked","확인"),
    UNCHECKED("Unchecked","미확인");

    private String key;
    private String value;

    Checking(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
