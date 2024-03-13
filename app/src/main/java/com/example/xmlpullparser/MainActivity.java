package com.example.xmlpullparser;


        import android.app.Activity;
        import android.os.Bundle;
        import android.view.Menu;
        import android.widget.ArrayAdapter;
        import android.widget.ListView;

        import java.io.IOException;
        import java.io.InputStream;
        import java.util.List;

public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById(R.id.facultyView);
        List<Faculty> staff = null;
        try {
            XmlPullParserHandler parser = new XmlPullParserHandler();
            InputStream is = getAssets().open("staff.xml");
            staff = parser.parse(is);
            ArrayAdapter<Faculty> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, staff);
            listView.setAdapter(adapter);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }
}
