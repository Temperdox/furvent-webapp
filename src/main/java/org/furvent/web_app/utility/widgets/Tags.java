package org.furvent.web_app.utility.widgets;

public enum Tags {
    GAMING("Gaming"),
    COMMUNICATION("Communication"),
    IMAGES("Images"),
    MUSIC("Music");

    Tags(final String tag) {
        this.tag = tag;
    }

    private final String tag;

    public String getAngle() {
        return tag;
    }
}
