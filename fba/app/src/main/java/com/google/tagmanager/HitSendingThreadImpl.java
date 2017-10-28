package com.google.tagmanager;

import android.content.Context;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.util.concurrent.LinkedBlockingQueue;

class HitSendingThreadImpl extends Thread implements HitSendingThread {
	private static HitSendingThreadImpl sInstance;
	private volatile boolean mClosed;
	private final Context mContext;
	private volatile boolean mDisabled;
	private volatile HitStore mUrlStore;
	private final LinkedBlockingQueue<Runnable> queue;

	class AnonymousClass_1 implements Runnable {
		final /* synthetic */ long val$hitTime;
		final /* synthetic */ HitSendingThread val$thread;
		final /* synthetic */ String val$url;

		AnonymousClass_1(HitSendingThread r2_HitSendingThread, long r3j, String r5_String) {
			this.val$thread = r2_HitSendingThread;
			this.val$hitTime = r3j;
			this.val$url = r5_String;
		}

		public void run() {
			if (mUrlStore == null) {
				ServiceManagerImpl instance = ServiceManagerImpl.getInstance();
				instance.initialize(mContext, this.val$thread);
				mUrlStore = instance.getStore();
			}
			mUrlStore.putHit(this.val$hitTime, this.val$url);
		}
	}


	private HitSendingThreadImpl(Context ctx) {
		super("GAThread");
		this.queue = new LinkedBlockingQueue();
		this.mDisabled = false;
		this.mClosed = false;
		if (ctx != null) {
			this.mContext = ctx.getApplicationContext();
		} else {
			this.mContext = ctx;
		}
		start();
	}

	@VisibleForTesting
	HitSendingThreadImpl(Context ctx, HitStore store) {
		super("GAThread");
		this.queue = new LinkedBlockingQueue();
		this.mDisabled = false;
		this.mClosed = false;
		if (ctx != null) {
			this.mContext = ctx.getApplicationContext();
		} else {
			this.mContext = ctx;
		}
		this.mUrlStore = store;
		start();
	}

	static HitSendingThreadImpl getInstance(Context ctx) {
		if (sInstance == null) {
			sInstance = new HitSendingThreadImpl(ctx);
		}
		return sInstance;
	}

	private String printStackTrace(Throwable t) {
		OutputStream baos = new ByteArrayOutputStream();
		PrintStream stream = new PrintStream(baos);
		t.printStackTrace(stream);
		stream.flush();
		return new String(baos.toByteArray());
	}

	@VisibleForTesting
	void close() {
		this.mClosed = true;
		interrupt();
	}

	@VisibleForTesting
	int getQueueSize() {
		return this.queue.size();
	}

	@VisibleForTesting
	HitStore getStore() {
		return this.mUrlStore;
	}

	@VisibleForTesting
	boolean isDisabled() {
		return this.mDisabled;
	}

	public void queueToThread(Runnable r) {
		this.queue.add(r);
	}

	public void run() {
		while (!(this.mClosed)) {
			Runnable r;
			try {
				r = (Runnable) this.queue.take();
				if (!(this.mDisabled)) {
					r.run();
				}
			} catch (InterruptedException e) {
				Log.i(e.toString());
			}
		}
	}

	public void sendHit(String url) {
		sendHit(url, System.currentTimeMillis());
	}

	@VisibleForTesting
	void sendHit(String url, long hitTime) {
		queueToThread(new AnonymousClass_1(this, hitTime, url));
	}
}
