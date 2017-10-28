package com.lostnet.fw.ui;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.lostnet.fw.C0328k;
import com.lostnet.fw.C0329l;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.p009d.C0318o;

public class ToolsActivity extends Activity {
    RelativeLayout f1551a;
    fn f1552b = new fn(this);

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(C0329l.activity_settings);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
        Button button = (Button) findViewById(C0328k.buttonUpgrade);
        ListView listView = (ListView) findViewById(C0328k.settingsList);
        listView.setAdapter(this.f1552b);
        this.f1551a = (RelativeLayout) getLayoutInflater().inflate(C0329l.activity_settings_text, null);
        TextView textView = (TextView) this.f1551a.findViewById(C0328k.textValue);
        ((TextView) this.f1551a.findViewById(C0328k.textLabel)).setText(C0330m.tool_sniffer_title);
        if ("com.lostnet.fw.free".equals(getResources().getString(C0330m.package_name))) {
            textView.setText(C0330m.tool_sniffer_comment);
        } else {
            button.setVisibility(8);
            textView.setText(C0330m.tool_sniffer_comment_pro);
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
        C0318o.m2030a((Activity) this);
    }

    public void onStop() {
        super.onStop();
        C0318o.m2032b(this);
    }
}
