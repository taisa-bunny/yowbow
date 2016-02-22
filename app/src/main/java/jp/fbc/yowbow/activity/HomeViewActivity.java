package jp.fbc.yowbow.activity;

import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.design.widget.FloatingActionButton;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import jp.fbc.yowbow.R;

public class HomeViewActivity extends BaseActivity {

    private String[] mPlanetTitles = null;
    private DrawerLayout leftDrawerLayout = null;
    private DrawerLayout rightDrawerLayout = null;
    private ListView leftListView = null;
    private ListView rightListView = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_view);


        // ドロワーメニューのリストの値を初期化
        mPlanetTitles = new String[]{"aaa", "bbb", "ccc", "ddd"};

        leftDrawerLayout =  (DrawerLayout) findViewById(R.id.drawer_layout);
        leftListView = (ListView) findViewById(R.id.left_drawer);
        rightListView = (ListView) findViewById(R.id.right_drawer);

        leftDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        // リストビューとデータを関連付け
        leftListView.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mPlanetTitles));

        rightListView.setAdapter(new ArrayAdapter<String>(this,
                R.layout.drawer_list_item, mPlanetTitles));


        // 選択時のイベントを登録
        leftListView.setOnItemClickListener(
                new ListView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        leftSelectItem(position);
                    }
                }
        );

        // 選択時のイベントを登録
        rightListView.setOnItemClickListener(
                new ListView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        leftSelectItem(position);
                    }
                }
        );



        Button addButton = (Button) findViewById(R.id.button1);
        Button viewButton = (Button) findViewById(R.id.button2);

        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), NeedPostActivity.class);
                startActivity(intent);
            }
        });

        addButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplication(),NeedPostActivity.class);
                startActivity(intent);
            }
        });

        viewButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Intent intent = new Intent(getApplication(),DemandViewActivity.class);
                startActivity(intent);
            }
        });

    }


    // ドロワーメニューのリスト選択処理
    private void leftSelectItem(int position) {

        leftDrawerLayout.closeDrawer(leftListView);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_top, menu);
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
