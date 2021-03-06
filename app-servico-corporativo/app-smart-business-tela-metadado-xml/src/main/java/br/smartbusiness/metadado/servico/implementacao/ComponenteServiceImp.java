package br.smartbusiness.metadado.servico.implementacao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.inject.Named;
import br.smartbusiness.metadado.conversor.ConversorBean;
import br.smartbusiness.metadado.conversor.ConversorXml;
import br.smartbusiness.metadado.conversor.ConversorXsl;
import br.smartbusiness.metadado.conversor.enums.TemplateXsl;
import br.smartbusiness.metadado.conversor.enums.TipoConversaoXML;
import br.smartbusiness.metadado.servico.interfaces.IComponenteServiceLocal;
import br.smartbusiness.metadado.uicomponent.bean.Componente;
import br.smartbusiness.metadado.uicomponent.bean.CompositeImp;
import br.smartbusiness.metadado.uicomponent.bean.CompositeImplentationImp;
import br.smartbusiness.metadado.uicomponent.bean.CompositeInterfacesImp;
import br.smartbusiness.metadado.uicomponent.bean.IComposite;
import br.smartbusiness.metadado.uicomponent.bean.ICompositeImplentation;
import br.smartbusiness.metadado.uicomponent.bean.ICompositeInterfaces;
import br.smartbusiness.metadado.uicomponent.bean.MetaDado;

@Named
@Stateless
@Local(value = { IComponenteServiceLocal.class })
public class ComponenteServiceImp implements IComponenteServiceLocal {

	@Override
	public List<IComposite> converterArquivo(List<File> files) {

		List<IComposite> composites = new ArrayList<IComposite>();
		for (File componenteEmArquivo : files) {

			ConversorXsl<StringBuffer> conversorXslAllComponente = new ConversorXsl<StringBuffer>(componenteEmArquivo,
					TemplateXsl.COMPOSITE_ALL_COMPONENTE);
			StringBuffer componenteInterfaceImplementacaoSB = conversorXslAllComponente.converter();

			ConversorXml<Componente> conversorComponenteXml = new ConversorXml<>(
					componenteInterfaceImplementacaoSB.toString(), Componente.class, TipoConversaoXML.STRING_INTANCIA);

			Componente componente = conversorComponenteXml.converter();

			ICompositeInterfaces interfaces = new CompositeInterfacesImp(componente);
			ICompositeImplentation implementacao = new CompositeImplentationImp(componente);
			IComposite composite = new CompositeImp(interfaces, implementacao);
			composites.add(composite);
		}

		return composites;

	}

	@Override
	public List<MetaDado> converterCompositeInterfaces(List<ICompositeInterfaces> compositesInterfaces) {

		List<MetaDado> metadados = new ArrayList<MetaDado>();
		for (ICompositeInterfaces compositeInterfaces : compositesInterfaces) {

			MetaDado mdo = ConversorBean.converterParaMetadado(compositeInterfaces);
			metadados.add(mdo);
		}

		return metadados;
	}

	@Override
	public List<MetaDado> converterComposite(List<IComposite> composites) {

		List<MetaDado> metadados = new ArrayList<MetaDado>();
		for (IComposite composite : composites) {

			MetaDado mdo = ConversorBean.converterParaMetadado(composite.getInterfaces());
			metadados.add(mdo);
		}

		return metadados;
	}

	@Override
	public List<StringBuffer> converterComponenteUI(List<MetaDado> metadados) {

		List<StringBuffer> metadadosConvertidos = new ArrayList<StringBuffer>();
		for (MetaDado mdo : metadados) {

			ConversorXsl<StringBuffer> conversorXslToMetadado = new ConversorXsl<StringBuffer>(mdo,
					TemplateXsl.METADADO_UI);

			StringBuffer xmlMetadado = conversorXslToMetadado.converter();
			metadadosConvertidos.add(xmlMetadado);
		}

		return metadadosConvertidos;
	}

	@Override
	public List<StringBuffer> converterEmXml(List<MetaDado> metadados) {

		List<StringBuffer> resultado = new ArrayList<StringBuffer>();
		
		for (MetaDado mdo : metadados) {
			ConversorXml<StringBuffer> conversorXml = new ConversorXml<>(mdo, MetaDado.class,
					TipoConversaoXML.INSTANCIA_STRING_BUFFER);
			
			resultado.add(conversorXml.converter());
		}
	
		return resultado;
	}
}
