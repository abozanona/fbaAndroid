package com.ppu.fba.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.ppu.fba.free.R;
import com.ppu.fba.p009d.Log1;

public class ToolsActivity extends Activity {
    RelativeLayout f1551a;
    fn f1552b = new fn(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.activity_settings);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        Button button = (Button) findViewById(R.id.buttonUpgrade);
        ListView listView = (ListView) findViewById(R.id.settingsList);
        listView.setAdapter(this.f1552b);
        this.f1551a = (RelativeLayout) getLayoutInflater().inflate(R.activity_settings_text, null);
        TextView textView = (TextView) this.f1551a.findViewById(R.id.textValue);
        ((TextView) this.f1551a.findViewById(R.id.textLabel)).setText(R.string.tool_sniffer_title);
        if ("com.ppu.fba.free".equals(getResources().getString(R.string.package_name))) {
            textView.setText(R.string.tool_sniffer_comment);
        } else {
            button.setVisibility(8);
            textView.setText(R.string.tool_sniffer_comment_pro);
        }
        listView.setOnItemClickListener(new fl(this));
        button.setOnClickListener(new fm(this));
    }

    public boolean onOptionsItemSelected(MenuItem menuItem) {
        switch (menuItem.getItemId()) {
            case 16908332:
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(menuItem);
        }
    }

    public void onStart() {
        super.onStart();
    }

    public void onStop() {
        super.onStop();
    }
}
