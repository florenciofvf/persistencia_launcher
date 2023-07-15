package br.com.persist.main;

import java.lang.reflect.Method;

public class Launcher {
	public static void main(String[] args) throws Exception {
		Thread.currentThread().setContextClassLoader(new CLPersistencia());
		ClassLoader loader = Thread.currentThread().getContextClassLoader();
		Class<?> klass = loader.loadClass("br.com.persist.main.Main");
		Method method = klass.getMethod("main", String[].class);
		method.invoke(null, params());
	}

	private static Object[] params() {
		String[] args = new String[] {};
		return new Object[] { args };
	}
}