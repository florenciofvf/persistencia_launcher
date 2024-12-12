package br.com.persist.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
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
		File fileLibs = new File("libs");
		File[] files = fileLibs.listFiles();
		List<File> lista = new ArrayList<>();
		if (files != null) {
			for (File f : files) {
				String s = f.getName().toLowerCase();
				if (s.endsWith(".jar")) {
					lista.add(f);
				}
			}
		}
		File outrasLibs = new File(fileLibs, "outras_libs");
		if (outrasLibs.isFile()) {
			try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(outrasLibs)))) {
				String linha = br.readLine();
				while (linha != null) {
					linha = linha.trim();
					if (!linha.startsWith("#") && linha.endsWith(".jar")) {
						lista.add(new File(linha));
					}
					linha = br.readLine();
				}
			} catch (Exception e) {
				//
			}
		}
		return lista.toArray(new File[lista.size()]);
	}
}