package br.smartbusiness.metadado.servico.implementacao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.appsmartbusiness.persistencia.conversores.Conversor;
import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.interfaces.ComponenteTelaService;
import br.com.app.smart.business.tela.componete.dto.ComponenteDTO;
import br.com.app.smart.business.tela.componete.dto.ComponenteTelaDTO;
import br.com.app.smart.business.tela.componete.dto.CompositeDTO;
import br.smartbusiness.metadado.conversor.ConversorBean;
import br.smartbusiness.metadado.servico.interfaces.ComponenteService;
import br.smartbusiness.metadado.uicomponent.bean.CompositeImp;
import br.smartbusiness.metadado.uicomponent.bean.IComposite;
import br.smartbusiness.metadado.uicomponent.bean.MetaDado;
@Stateless
@Remote(ComponenteTelaService.class)
public class ComponenteTelaServiceImp implements ComponenteTelaService {

	@EJB
	private ComponenteService componenteService;;
	

	@Override
	public List<CompositeDTO> converterArquivo(List<File> files) {

		try {

			List<CompositeDTO> compositesDTO = new ArrayList<CompositeDTO>();
			List<IComposite> listacomposites = componenteService.converterArquivo(files);
			for (IComposite iComposite : listacomposites) {

				CompositeDTO componenteDTO =ConversorBean.converterICompositeParaCompositeDTO(iComposite);
				compositesDTO.add(componenteDTO);
			}
			return compositesDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ComponenteTelaDTO> converterComposite(List<CompositeDTO> composites) {

		try {

			List<IComposite> listacomposites = new ArrayList<IComposite>();

			for (CompositeDTO compositeDTO : composites) {

				IComposite composite = ConversorBean.converterCompositeDTOParaIComposite(compositeDTO);

				listacomposites.add(composite);

			}

			List<MetaDado> metadados = componenteService.converterComposite(listacomposites);

			List<ComponenteTelaDTO> listeComponenteTelaDTO = new ArrayList<ComponenteTelaDTO>();
			for (MetaDado metaDado : metadados) {

				ComponenteTelaDTO componenteDTO = Conversor.converter(metaDado, ComponenteTelaDTO.class);
				listeComponenteTelaDTO.add(componenteDTO);
			}

			return listeComponenteTelaDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;

	}

	@Override
	public List<StringBuffer> converterComponenteUI(List<ComponenteTelaDTO> metadados) {

		try {

			List<MetaDado> listeMetaDado = new ArrayList<MetaDado>();
			for (ComponenteTelaDTO componenteDTO : metadados) {

				MetaDado MetaDado = Conversor.converter(componenteDTO, MetaDado.class);
				listeMetaDado.add(MetaDado);
			}

			return componenteService.converterComponenteUI(listeMetaDado);
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

}
