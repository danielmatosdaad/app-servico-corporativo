package br.smartbusiness.metadado.conversor;

import java.util.ArrayList;
import java.util.List;

import br.appsmartbusiness.persistencia.conversores.Conversor;
import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.tela.componete.dto.ComponenteDTO;
import br.com.app.smart.business.tela.componete.dto.CompositeDTO;
import br.com.app.smart.business.tela.componete.dto.CompositeImplentationDTO;
import br.com.app.smart.business.tela.componete.dto.CompositeInterfaceDTO;
import br.smartbusiness.metadado.uicomponent.bean.Componente;
import br.smartbusiness.metadado.uicomponent.bean.CompositeImp;
import br.smartbusiness.metadado.uicomponent.bean.CompositeImplentationImp;
import br.smartbusiness.metadado.uicomponent.bean.CompositeInterfacesImp;
import br.smartbusiness.metadado.uicomponent.bean.IComposite;
import br.smartbusiness.metadado.uicomponent.bean.ICompositeImplentation;
import br.smartbusiness.metadado.uicomponent.bean.ICompositeInterfaces;
import br.smartbusiness.metadado.uicomponent.bean.MetaDado;
import br.smartbusiness.metadado.uicomponent.bean.Propriedade;

public class ConversorBean {

	private static final String NS_PROJETO_COMPONENTES = "http://url.projeto/componentes";

	public static List<MetaDado> converterParaMetadado(List<ICompositeInterfaces> compositeInterfaces) {

		if (compositeInterfaces == null) {
			return null;
		}

		List<MetaDado> metadados = new ArrayList<MetaDado>();

		for (ICompositeInterfaces composite : compositeInterfaces) {

			MetaDado mdo = converterParaMetadado(composite);
			metadados.add(mdo);
		}

		return metadados;

	}

	public static MetaDado converterParaMetadado(ICompositeInterfaces compositeInterfaces) {

		if (compositeInterfaces == null) {
			return null;
		}
		MetaDado metadado = new MetaDado(new ArrayList<Componente>());
		List<Componente> cpns = compositeInterfaces.getComponente().getComponentes();
		List<Propriedade> propriedadesMetadado = new ArrayList<Propriedade>();

		for (Componente componente : cpns) {

			if (componente.getPropriedades() != null) {

				for (Propriedade p : componente.getPropriedades()) {

					Propriedade prop = new Propriedade(p.getValor(), "");
					propriedadesMetadado.add(prop);

				}

			}

		}
		Componente componentemdo = new Componente(compositeInterfaces.getNome(), NS_PROJETO_COMPONENTES,
				propriedadesMetadado);
		metadado.getComponentes().add(componentemdo);

		return metadado;

	}
	
	
	public static CompositeDTO converterICompositeParaCompositeDTO(IComposite composite) throws InfraEstruturaException{
		
		CompositeDTO componenteDTO = new CompositeDTO();
		
		ICompositeInterfaces interfaces = composite.getInterfaces();
		ICompositeImplentation implementation = composite.getImpletation();
		if(interfaces!=null && interfaces.getComponente()!=null){
			CompositeInterfaceDTO interfaceDTO =  Conversor.converter(interfaces, CompositeInterfaceDTO.class);
			componenteDTO.setInterfaces(interfaceDTO);
		}
	
		if(implementation!=null && implementation.getComponente()!=null){
			ComponenteDTO componenteImplDTO = Conversor.converter(implementation.getComponente(), ComponenteDTO.class);
			CompositeImplentationDTO impletationDTO = new CompositeImplentationDTO();
			impletationDTO.setComponente(componenteImplDTO);
			componenteDTO.setImpletation(impletationDTO);
		}
	
		return componenteDTO;
	}
	
	public static IComposite converterCompositeDTOParaIComposite(CompositeDTO compositeDTO) throws InfraEstruturaException{
		
		CompositeInterfacesImp componenteInterface =Conversor.converter(compositeDTO.getInterfaces(),CompositeInterfacesImp.class );
		CompositeImplentationImp componenteImp =  Conversor.converter(compositeDTO.getImpletation(),CompositeImplentationImp.class );
	
		CompositeImp componenteDTO = new CompositeImp(componenteInterface,componenteImp);
		
		return componenteDTO;
	}
}
