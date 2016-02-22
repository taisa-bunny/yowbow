package jp.fbc.yowbow.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import jp.fbc.yowbow.R;

public class NeedPostActivity extends BaseActivity {

    private String txtName;
    private String txtContent;

    private EditText editName;
    private EditText editContent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_need_post);
        Button backButton = (Button) findViewById(R.id.button1);
        Button submitButton = (Button) findViewById(R.id.button2);

        editName = (EditText) findViewById(R.id.edit_name);
        editContent = (EditText) findViewById(R.id.edit_content);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                txtName = editName.getText().toString();
                txtContent = editContent.getText().toString();
                Intent intent = new Intent(getApplication(), DemandResultActivity.class);
                intent.putExtra("strName", txtName);
                intent.putExtra("strContent", txtContent);
                startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), HomeViewActivity.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_demand_add, menu);
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
}
