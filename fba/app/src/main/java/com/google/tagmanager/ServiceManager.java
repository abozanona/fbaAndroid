package com.google.tagmanager;

abstract class ServiceManager {
	ServiceManager() {
	}

	abstract void dispatch();

	abstract void onRadioPowered();

	abstract void setDispatchPeriod(int r1i);

	abstract void updateConnectivityStatus(boolean r1z);
}
