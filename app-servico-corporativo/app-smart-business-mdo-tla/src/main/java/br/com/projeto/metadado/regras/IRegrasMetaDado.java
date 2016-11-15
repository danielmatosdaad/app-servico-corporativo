package br.com.projeto.metadado.regras;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.Serializable;
import java.util.List;

import javax.xml.bind.JAXBException;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;

import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.exception.NegocioException;
import br.com.projeto.facelet.bean.Facelet;
import br.com.projeto.metadado.bean.MetaDado;
import br.com.projeto.metadado.infra.comum.MetadadoUI;
import br.com.projeto.metadado.infra.comum.StringBufferOutputStream;

public interface IRegrasMetaDado extends Serializable{

	public MetadadoUI converterMetadadoUI(MetaDado metadado);

	public MetaDado buscarMetadado(int numeroTela, int funcionalidade) throws InfraEstruturaException, NegocioException;

	public MetadadoUI atualizarTela(long idMetaDado) throws InfraEstruturaException, NegocioException;

	public StringBuffer transformaParaXml(MetaDado metaDado);

	public StringBuffer transformaMetaDadoParaFacelet(MetaDado metaDado);

	public List<MetadadoUI> converterFaceletMetadadoUI(List<Facelet> lista)
			throws TransformerConfigurationException, TransformerException;

	public List<Facelet> transformarEmFacelets(List<File> lista);

	public StringBufferOutputStream transformarMetadado(MetaDado metadado)
			throws TransformerException, JAXBException, FileNotFoundException;
	
	public MetaDado converterFaceletMetaDado(List<Facelet> faceletes);
}
