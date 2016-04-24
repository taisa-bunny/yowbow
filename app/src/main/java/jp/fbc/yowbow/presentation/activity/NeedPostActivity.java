package jp.fbc.yowbow.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;
import java.lang.reflect.Type;

import jp.fbc.yowbow.R;
import jp.fbc.yowbow.data.api.ApiConnect;
import jp.fbc.yowbow.data.helper.SampleJsonGet;
import jp.fbc.yowbow.data.model.SampleJson;

public class NeedPostActivity extends AppCompatActivity {

    private String txtName;
    private String txtContent;

    private EditText editName;
    private EditText editContent;

    private ApiConnect connect;

    private TextView textView2;
    private SampleJson sj;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_need_post);

        textView2 = (TextView) findViewById(R.id.textView2);


        // コネクタを取得する
        if(getIntent() != null) {
            connect = (ApiConnect) getIntent().getSerializableExtra("connect");
        }

        if(connect != null) {
            SampleJsonGet sampleJsonGet = new SampleJsonGet();
            sampleJsonGet.getServerJson(connect, new ApiConnect.sampleListener() {
                @Override
                public void onSuccess(String msg) {
                    Gson gson = new Gson();
                    Type listType = new TypeToken<List<SampleJson>>() {
                    }.getType();
                    List<SampleJson> sjl = gson.fromJson(msg, listType);

                    for (int i = 0; i < sjl.size(); i++) {
                        sj = sjl.get(i);
                        System.out.println(sj.getId());
                        System.out.println(sj.getName());
                        System.out.println(sj.getContent());
                    }

                    textView2.setText(sj.getName());


                }

                @Override
                public void onSuccess(SampleJson json) {

                }

                @Override
                public void onFailed(String error) {

                }
            });

        }


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
