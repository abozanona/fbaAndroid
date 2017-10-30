package com.ppu.fba.ui;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.widget.ListAdapter;
import android.widget.ListView;
import com.ppu.fba.FirewallManagerService;
import com.ppu.fba.p008c.C0296a;
import com.ppu.fba.p009d.Log1;

public class cd extends Fragment implements ac {
    private long f1505P = 0;
    volatile ListView f1506R;

    public synchronized void mo751a(ListAdapter listAdapter) {
        if (!(this.f1506R == null || listAdapter == null)) {
            this.f1506R.setAdapter(listAdapter);
        }
    }

    public synchronized void m2056b(Context context) {
        long c = C0296a.m1930c();
        if (this.f1505P == 0 || c >= this.f1505P + 10000) {
            m2057c(context);
        } else {
            Log1.LogF1("FragmentUpdatable", "skipping update");
        }
    }

    public synchronized void m2057c(Context context) {
        if (this.f1506R != null) {
            ListAdapter a = mo750a(context);
            if (a != null && a.getCount() > 0) {
                this.f1505P = C0296a.m1930c();
            }
            mo751a(a);
        }
    }

    public void mo748j() {
        if (FirewallManagerService.m1852a(null) != null) {
            m2056b(this.f1506R.getContext());
        }
    }

    @Override
    public ListAdapter mo750a(Context context) {
        return null;
    }
}
