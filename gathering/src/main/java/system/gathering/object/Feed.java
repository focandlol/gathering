package system.gathering.object;

public enum Feed {

    ATTITUDE("Attitude","부정적인 태도"),
    BADWORD("BadWord","욕설"),
    DISGUST("Disgust","혐오 발언"),
    NOSHOW("NoShow","노쇼");

    private String key;
    private String value;

    Feed(String key, String value) {
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
