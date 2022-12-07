package enums;

public enum DirectLinks {
    POSTI_SERVICE_POINTS("https://www.posti.fi/en/service-points-on-map"),
    PARCELS_AND_TRACKING("https://www.posti.fi/en/private/parcels-and-tracking");

    private final String link;

    DirectLinks(final String link) {
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
