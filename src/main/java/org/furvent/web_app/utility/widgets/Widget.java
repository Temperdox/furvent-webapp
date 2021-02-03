package org.furvent.web_app.utility.widgets;

import lombok.Getter;
import lombok.Builder;

import java.util.ArrayList;

@Getter
@Builder
public class Widget {
    String name = null;

    Long id = null;

    ArrayList<Tags> WidgetTags = null;

    ArrayList<String> Invites = null;




}
