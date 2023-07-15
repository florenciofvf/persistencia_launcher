package br.com.persist.main;

import java.io.File;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class CLPersistenciaUtil {
	private CLPersistenciaUtil() {
	}

	public static URL[] getURLs() {
		try {
			File[] files = getFiles();
			URL[] urls = new URL[files.length];
			for (int i = 0; i < files.length; i++) {
				URI uri = files[i].toURI();
				urls[i] = uri.toURL();
			}
			return urls;
		} catch (Exception e) {
			throw new IllegalStateException();
		}
	}

	public static File[] getFiles() {
		File[] files = new File("libs").listFiles();
		List<File> lista = new ArrayList<>();
		if (files != null) {
			for (File f : files) {
				String s = f.getName().toLowerCase();
				if (s.endsWith(".jar")) {
					lista.add(f);
				}
			}
		}
		return lista.toArray(new File[lista.size()]);
	}
}