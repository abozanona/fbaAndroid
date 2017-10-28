package com.lostnet.fw.p009d;

import android.app.Dialog;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.lostnet.fw.C0330m;
import com.lostnet.fw.FirewallApplication;

public class C0304a {
    public static void m1960a(Context context) {
        Context a = FirewallApplication.m1851a();
        if (C0310g.m1991c(context)) {
            SharedPreferences sharedPreferences = a.getSharedPreferences("apprater", 0);
            if (!sharedPreferences.getBoolean("dontshowagain", false)) {
                Editor edit = sharedPreferences.edit();
                long j = sharedPreferences.getLong("launch_count", 0) + 1;
                edit.putLong("launch_count", j);
                Long valueOf = Long.valueOf(sharedPreferences.getLong("date_firstlaunch", 0));
                if (valueOf.longValue() == 0) {
                    valueOf = Long.valueOf(System.currentTimeMillis());
                    edit.putLong("date_firstlaunch", valueOf.longValue());
                }
                if (j >= 2 && System.currentTimeMillis() >= r0.longValue() + 172800000) {
                    C0304a.m1961a(context, edit);
                }
                edit.commit();
            }
        }
    }

    public static void m1961a(Context context, Editor editor) {
        Dialog dialog = new Dialog(context);
        dialog.setTitle(context.getResources().getString(C0330m.popup_rate_title) + " " + context.getResources().getText(C0330m.app_name));
        View linearLayout = new LinearLayout(context);
        linearLayout.setOrientation(1);
        View textView = new TextView(context);
        textView.setText(context.getResources().getString(C0330m.popup_rate_content_1) + " " + context.getResources().getText(C0330m.app_name) + " " + context.getResources().getString(C0330m.popup_rate_content_2));
        textView.setWidth(240);
        textView.setPadding(4, 0, 4, 10);
        linearLayout.addView(textView);
        textView = new Button(context);
        textView.setText(context.getResources().getString(C0330m.popup_rate_action_rate));
        textView.setOnClickListener(new C0305b(context, dialog));
        linearLayout.addView(textView);
        textView = new Button(context);
        textView.setText(context.getResources().getString(C0330m.popup_rate_action_later));
        textView.setOnClickListener(new C0306c(dialog));
        linearLayout.addView(textView);
        textView = new Button(context);
        textView.setText(context.getResources().getString(C0330m.popup_rate_action_no));
        textView.setOnClickListener(new C0307d(editor, dialog));
        linearLayout.addView(textView);
        dialog.setContentView(linearLayout);
        dialog.show();
    }
}
