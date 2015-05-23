package ryanduvall.androidscripturereference;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import java.io.Console;


public class GetScripture extends ActionBarActivity {

    public final static String EXTRA_MESSAGE = "Favorite Scripture";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_get_scripture);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_get_scripture, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void shareScripture(View view) {
        Intent intent = new Intent(this, DisplayScripture.class);

        EditText book = (EditText) findViewById(R.id.book);
        EditText chapter = (EditText) findViewById(R.id.chapter);
        EditText verse = (EditText) findViewById(R.id.verse);

        String scripture = book.getText().toString() + " " + chapter.getText().toString() + ":" + verse.getText().toString();
        intent.putExtra(EXTRA_MESSAGE, scripture);
        startActivity(intent);
    }
}
