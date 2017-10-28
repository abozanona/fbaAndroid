package com.google.android.gms.analytics.internal;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;
import java.util.Map;

public interface IAnalyticsService extends IInterface {
	public static abstract class Stub extends Binder implements IAnalyticsService {
		private static final String DESCRIPTOR = "com.google.android.gms.analytics.internal.IAnalyticsService";
		static final int TRANSACTION_clearHits = 2;
		static final int TRANSACTION_sendHit = 1;

		private static class Proxy implements IAnalyticsService {
			private IBinder mRemote;

			Proxy(IBinder remote) {
				this.mRemote = remote;
			}

			public IBinder asBinder() {
				return this.mRemote;
			}

			public void clearHits() throws RemoteException {
				Parcel _data = Parcel.obtain();
				Parcel _reply = Parcel.obtain();
				_data.writeInterfaceToken(DESCRIPTOR);
				this.mRemote.transact(TRANSACTION_clearHits, _data, _reply, 0);
				_reply.readException();
				_reply.recycle();
				_data.recycle();
			}

			public String getInterfaceDescriptor() {
				return DESCRIPTOR;
			}

			public void sendHit(Map wireParams, long hitTimeInMilliseconds, String path, List<Command> commands) throws RemoteException {
				Parcel _data = Parcel.obtain();
				Parcel _reply = Parcel.obtain();
				_data.writeInterfaceToken(DESCRIPTOR);
				_data.writeMap(wireParams);
				_data.writeLong(hitTimeInMilliseconds);
				_data.writeString(path);
				_data.writeTypedList(commands);
				this.mRemote.transact(TRANSACTION_sendHit, _data, _reply, 0);
				_reply.readException();
				_reply.recycle();
				_data.recycle();
			}
		}


		public Stub() {
			attachInterface(this, DESCRIPTOR);
		}

		public static IAnalyticsService asInterface(IBinder obj) {
			if (obj == null) {
				return null;
			} else {
				IInterface iin = obj.queryLocalInterface(DESCRIPTOR);
				return (iin == null || !((iin instanceof IAnalyticsService))) ? new Proxy(obj) : (IAnalyticsService) iin;
			}
		}

		public IBinder asBinder() {
			return this;
		}

		public boolean onTransact(int code, Parcel data, Parcel reply, int flags) throws RemoteException {
			switch(code) {
			case TRANSACTION_sendHit:
				data.enforceInterface(DESCRIPTOR);
				sendHit(data.readHashMap(getClass().getClassLoader()), data.readLong(), data.readString(), data.createTypedArrayList(Command.CREATOR));
				reply.writeNoException();
				return true;
			case TRANSACTION_clearHits:
				data.enforceInterface(DESCRIPTOR);
				clearHits();
				reply.writeNoException();
				return true;
			case 1598968902:
				reply.writeString(DESCRIPTOR);
				return true;
			}
			return super.onTransact(code, data, reply, flags);
		}
	}


	public void clearHits() throws RemoteException;

	public void sendHit(Map r1_Map, long r2j, String r4_String, List<Command> r5_List_Command) throws RemoteException;
}
