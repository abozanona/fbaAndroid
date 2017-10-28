package android.support.v4.p002c;

import android.util.Log;
import java.io.Writer;

public class C0039e extends Writer {
    private final String f241a;
    private StringBuilder f242b = new StringBuilder(128);

    public C0039e(String str) {
        this.f241a = str;
    }

    private void m310a() {
        if (this.f242b.length() > 0) {
            Log.d(this.f241a, this.f242b.toString());
            this.f242b.delete(0, this.f242b.length());
        }
    }

    public void close() {
        m310a();
    }

    public void flush() {
        m310a();
    }

    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m310a();
            } else {
                this.f242b.append(c);
            }
        }
    }
}
