package utils;

public enum Environment {

    POSTI_SERVICE_POINTS("https://www.posti.fi/en/service-points-on-map");

    private final String link;

    Environment(final String link) {
        this.link = link;
    }

    public String link() {
        return link;
    }

    @Override
    public String toString() {
        return this.link;
    }
}
