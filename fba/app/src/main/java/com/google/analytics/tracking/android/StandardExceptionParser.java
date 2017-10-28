package com.google.analytics.tracking.android;

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager.NameNotFoundException;
import com.google.analytics.midtier.proto.containertag.TypeSystem.Value.Escaping;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class StandardExceptionParser implements ExceptionParser {
	private final TreeSet<String> includedPackages;

	public StandardExceptionParser(Context context, Collection<String> additionalPackages) {
		this.includedPackages = new TreeSet();
		setIncludedPackages(context, additionalPackages);
	}

	protected StackTraceElement getBestStackTraceElement(Throwable t) {
		StackTraceElement[] elements = t.getStackTrace();
		if (elements == null || elements.length == 0) {
			return null;
		} else {
			StackTraceElement[] arr$ = elements;
			int len$ = arr$.length;
			int i$ = 0;
			while (i$ < len$) {
				StackTraceElement e = arr$[i$];
				String className = e.getClassName();
				Iterator i$_2 = this.includedPackages.iterator();
				while (i$_2.hasNext()) {
					if (className.startsWith((String) i$_2.next())) {
						return e;
					}
				}
				i$ = i$ + 1;
			}
			return elements[0];
		}
	}

	protected Throwable getCause(Throwable t) {
		Throwable result = t;
		while (result.getCause() != null) {
			result = result.getCause();
		}
		return result;
	}

	public String getDescription(String threadName, Throwable t) {
		return getDescription(getCause(t), getBestStackTraceElement(getCause(t)), threadName);
	}

	protected String getDescription(Throwable cause, StackTraceElement element, String threadName) {
		Object[] r4_Object_A;
		StringBuilder descriptionBuilder = new StringBuilder();
		descriptionBuilder.append(cause.getClass().getSimpleName());
		if (element != null) {
			String[] classNameParts = element.getClassName().split("\\.");
			String className = "unknown";
			if (classNameParts == null || classNameParts.length <= 0) {
				r4_Object_A = new Object[3];
				r4_Object_A[0] = className;
				r4_Object_A[1] = element.getMethodName();
				r4_Object_A[2] = Integer.valueOf(element.getLineNumber());
				descriptionBuilder.append(String.format(" (@%s:%s:%s)", r4_Object_A));
			} else {
				className = classNameParts[classNameParts.length - 1];
				r4_Object_A = new Object[3];
				r4_Object_A[0] = className;
				r4_Object_A[1] = element.getMethodName();
				r4_Object_A[2] = Integer.valueOf(element.getLineNumber());
				descriptionBuilder.append(String.format(" (@%s:%s:%s)", r4_Object_A));
			}
		}
		if (threadName != null) {
			r4_Object_A = new Object[1];
			r4_Object_A[0] = threadName;
			descriptionBuilder.append(String.format(" {%s}", r4_Object_A));
		}
		return descriptionBuilder.toString();
	}

	public void setIncludedPackages(Context context, Collection<String> additionalPackages) {
		this.includedPackages.clear();
		Set<String> packages = new HashSet();
		if (additionalPackages != null) {
			packages.addAll(additionalPackages);
		}
		if (context != null) {
			ActivityInfo[] ai;
			try {
				String appPackage = context.getApplicationContext().getPackageName();
				this.includedPackages.add(appPackage);
				ai = context.getApplicationContext().getPackageManager().getPackageInfo(appPackage, Escaping.NO_AUTOESCAPE_VALUE).activities;
				if (ai != null) {
					ActivityInfo[] arr$ = ai;
					int len$ = arr$.length;
					int i$ = 0;
					while (i$ < len$) {
						packages.add(arr$[i$].packageName);
						i$++;
					}
				}
			} catch (NameNotFoundException e) {
				Log.i("No package found");
			}
		}
		Iterator r5_Iterator = packages.iterator();
		while (r5_Iterator.hasNext()) {
			String packageName = (String) r5_Iterator.next();
			boolean needToAdd = true;
			Iterator i$_2 = this.includedPackages.iterator();
			while (i$_2.hasNext()) {
				String oldName = (String) i$_2.next();
				if (!packageName.startsWith(oldName)) {
					if (oldName.startsWith(packageName)) {
						this.includedPackages.remove(oldName);
					}
				} else {
					needToAdd = false;
				}
			}
			if (needToAdd) {
				this.includedPackages.add(packageName);
			}
		}
	}
}
