package br.com.projeto.metadado.xhtml;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

public class MetaDadoXHTML {

	String EXTENSAO_ARQUIVO=".xhtml";
	
	public OutputStream criarArquivoXHTML(String nomeArquivo){
		
		FileOutputStream fos;
		try {
			fos = new FileOutputStream(nomeArquivo.concat(EXTENSAO_ARQUIVO));
			System.out.println("Arquivo criado "+ nomeArquivo.concat(EXTENSAO_ARQUIVO));
			return fos;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Arquivo nao criado");
		}
	
		return null;
	}
	
	public InputStream lerArquivoXHTML(String nomeArquivo){
		
		FileInputStream fis;
		try {
			fis = new FileInputStream(nomeArquivo.concat(EXTENSAO_ARQUIVO));
			System.out.println("Arquivo lido");
			return fis;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("Arquivo nao lido");
		}
	
		return null;
	}
	
	
}
