package com.google.tagmanager;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;

class SharedPreferencesUtil {
	static class AnonymousClass_1 implements Runnable {
		final /* synthetic */ Editor val$editor;

		AnonymousClass_1(Editor r1_Editor) {
			this.val$editor = r1_Editor;
		}

		public void run() {
			this.val$editor.commit();
		}
	}


	SharedPreferencesUtil() {
	}

	@SuppressLint({"CommitPrefEdits"})
	static void saveAsync(Context context, String sharedPreferencesName, String key, String value) {
		Editor editor = context.getSharedPreferences(sharedPreferencesName, 0).edit();
		editor.putString(key, value);
		saveEditorAsync(editor);
	}

	static void saveEditorAsync(Editor editor) {
		if (VERSION.SDK_INT >= 9) {
			editor.apply();
			return;
		} else {
			new Thread(new AnonymousClass_1(editor)).start();
		}
	}
}
