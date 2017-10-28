package com.ppu.fba.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.CompressFormat;
import android.graphics.Bitmap.Config;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Paint.Align;
import android.graphics.Picture;
import android.net.Uri;
import android.view.View;
import android.view.View.OnClickListener;
import com.google.analytics.tracking.android.MapBuilder;
import com.ppu.fba.free.R;
import com.ppu.fba.p009d.C0318o;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;

class dz implements OnClickListener {
    final /* synthetic */ SectionGeoListFragment f1791a;

    dz(SectionGeoListFragment sectionGeoListFragment) {
        this.f1791a = sectionGeoListFragment;
    }

    public void onClick(View view) {
        int i = 1;
        Picture capturePicture = this.f1791a.f1511U.capturePicture();
        Bitmap createBitmap = Bitmap.createBitmap(capturePicture.getWidth(), capturePicture.getHeight(), Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        capturePicture.draw(canvas);
        Paint paint = new Paint();
        paint.setARGB(224, 128, 128, 240);
        paint.setAntiAlias(true);
        paint.setTextAlign(Align.CENTER);
        paint.setTextSize(20.0f);
        if (capturePicture.getHeight() < 0) {
            i = 6;
        }
        canvas.drawText("LostNet Firewall", (float) (capturePicture.getWidth() / 2), (float) ((i * capturePicture.getHeight()) / 8), paint);
        OutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        createBitmap.compress(CompressFormat.PNG, 100, byteArrayOutputStream);
        File file = new File(this.f1791a.m30b().getFilesDir() + File.separator + "map.png");
        try {
            file.createNewFile();
            file.setReadable(true, false);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            fileOutputStream.write(byteArrayOutputStream.toByteArray());
            fileOutputStream.close();
            ArrayList arrayList = new ArrayList();
            arrayList.add(Uri.fromFile(file));
            Intent intent = new Intent("android.intent.action.SEND");
            intent.setType("image/*");
            intent.setAction("android.intent.action.SEND_MULTIPLE");
            intent.putParcelableArrayListExtra("android.intent.extra.STREAM", arrayList);
            this.f1791a.m30b().startActivityForResult(Intent.createChooser(intent, this.f1791a.m37c().getString(R.string.popup_share_title)), 2);
        } catch (Exception e) {
        }
        createBitmap.recycle();
        C0318o.m2031a(MapBuilder.createEvent("buttons", "shareMap", "attempt", null).build());
    }
}
