package br.smartbusiness.metadado.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileUtil {

	public static OutputStream criarArquivo(String nomeArquivo) {

		FileOutputStream fos;
		try {
			fos = new FileOutputStream(nomeArquivo);
			System.out.println("Arquivo criado " + nomeArquivo);
			return fos;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Arquivo nao criado");
		}

		return null;
	}

	public static InputStream lerArquivo(String nomeArquivo) {

		FileInputStream fis;
		try {
			fis = new FileInputStream(nomeArquivo);
			System.out.println("Arquivo lido");
			return fis;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Arquivo nao lido");
		}

		return null;
	}

	public static StringBuffer converterStrigBuffer(InputStream in) {

		StringBuffer sb = new StringBuffer();
		int content;
		try {
			while ((content = in.read()) != -1) {

				sb.append((char) content);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;
	}

}
