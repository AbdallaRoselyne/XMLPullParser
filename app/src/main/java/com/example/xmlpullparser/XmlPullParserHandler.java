package com.example.xmlpullparser;



        import java.io.IOException;
        import java.io.InputStream;
        import java.util.ArrayList;
        import java.util.List;

        import org.xmlpull.v1.XmlPullParser;
        import org.xmlpull.v1.XmlPullParserException;
        import org.xmlpull.v1.XmlPullParserFactory;

public class XmlPullParserHandler {
    private List<Faculty> staff = new ArrayList<>();
    private Faculty faculty;
    private String text;

    public List<Faculty> parse(InputStream is) {
        try {
            XmlPullParserFactory factory = XmlPullParserFactory.newInstance();
            factory.setNamespaceAware(true);
            XmlPullParser parser = factory.newPullParser();
            parser.setInput(is, null);

            int eventType = parser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                String tagName = parser.getName();
                switch (eventType) {
                    case XmlPullParser.START_TAG:
                        if (tagName.equalsIgnoreCase("faculty")) {
                            faculty = new Faculty();
                        }
                        break;
                    case XmlPullParser.TEXT:
                        text = parser.getText();
                        break;
                    case XmlPullParser.END_TAG:
                        if (tagName.equalsIgnoreCase("faculty")) {
                            staff.add(faculty);
                        } else if (tagName.equalsIgnoreCase("id")) {
                            faculty.setId(Integer.parseInt(text));
                        } else if (tagName.equalsIgnoreCase("name")) {
                            faculty.setName(text);
                        } else if (tagName.equalsIgnoreCase("module")) {
                            faculty.setModule(text);
                        }
                        break;
                    default:
                        break;
                }
                eventType = parser.next();
            }
        } catch (XmlPullParserException | IOException e) {
            e.printStackTrace();
        } finally {
            try {
                if (is != null) {
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return staff;
    }
}

