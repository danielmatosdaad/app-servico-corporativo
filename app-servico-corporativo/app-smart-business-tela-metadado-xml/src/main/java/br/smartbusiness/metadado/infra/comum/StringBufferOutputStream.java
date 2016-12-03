package br.smartbusiness.metadado.infra.comum;

import java.io.IOException;
import java.io.OutputStream;

public class StringBufferOutputStream extends OutputStream {

	private StringBuffer buffer;

	public StringBufferOutputStream() {
		buffer = new StringBuffer();
	}

	public StringBufferOutputStream(StringBuffer out) {
		buffer = out;
	}

	@Override
	public void write(int b) throws IOException {

		buffer.append((char) b);

	}

	public StringBuffer getBuffer() {
		return buffer;
	}

	public StringBuffer getStringBufferDefaultHmtl() {
		StringBuffer sb = new StringBuffer();
		sb.append("<html>");
		sb.append("<entradadados xmlns=\"http://url.projeto/componentes\" idNegocialLabel=\"idLabelUsuario\" valorLabel=\"Nome Usuario\" visivel=\"true\" idNegocialTexto=\"idLogin\" valorText=\"#{componenteMB.parametros['idLogin']}\">");
		sb.append("</entradadados>");
		sb.append("<entradadados xmlns=\"http://url.projeto/componentes\" idNegocialLabel=\"idLabelSenha\" valorLabel=\"Senha\" visivel=\"true\" idNegocialTexto=\"idSenha\" valorText=\"#{componenteMB.parametros['idSenha']}\">");
		sb.append("</entradadados>");
		sb.append("</html>");

		return sb;
	}

}
