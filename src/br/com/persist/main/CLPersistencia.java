package br.com.persist.main;

import java.net.URLClassLoader;

public class CLPersistencia extends URLClassLoader {
	public CLPersistencia() {
		super(CLPersistenciaUtil.getURLs());
	}
}