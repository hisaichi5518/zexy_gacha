package com.yoshitaka_yuriko.zexygacha;

import android.app.Activity;
import android.content.res.Resources;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.GridLayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button gachaButton = (Button)findViewById(R.id.gacha_button);
        gachaButton.setOnClickListener(new GachaButtonOnClickListener(this));
    }

    private class GachaButtonOnClickListener implements View.OnClickListener {
        private Activity mContext;
        private ZexyList mZexyList;

        private final int GACHA_AMOUNT = 10;

        GachaButtonOnClickListener(Activity context) {
            Resources r = getResources();
            mContext  = context;
            mZexyList = new ZexyList(r.getStringArray(R.array.zexies));
        }

        @Override
        public void onClick(View v) {
            List<String> result = mZexyList.gacha(GACHA_AMOUNT);
            ListView listView = (ListView) mContext.findViewById(R.id.gacha_result);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(
                    mContext,
                    android.R.layout.simple_list_item_1,
                    result
            );
            listView.setAdapter(adapter);

        }
    }
}
