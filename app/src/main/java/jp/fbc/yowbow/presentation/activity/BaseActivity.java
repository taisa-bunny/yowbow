package jp.fbc.yowbow.presentation.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import jp.fbc.yowbow.R;
import jp.fbc.yowbow.utilties.holder.BusHolder;

/**
 * Created by MBPU on 2016/02/14.
 */
public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(getLayoutResId());
        ButterKnife.bind(this);
//        FloatingActionButton floatingActionButton = (FloatingActionButton) findViewById(R.id.fab);
//
//        floatingActionButton.setOnClickListener(new View.OnClickListener() {
//            public void onClick(View v) {
//                Intent intent = new Intent(getApplication(), NeedPostActivity.class);
//                startActivity(intent);
//            }
//        });


    }

    abstract int getLayoutResId();

    @Override
    protected void onResume() {
        super.onResume();
        //otto bus
        BusHolder.get().register(this);
    }

    @Override
    protected void onPause() {
        //otto bus
        BusHolder.get().unregister(this);
        super.onPause();
    }

}
