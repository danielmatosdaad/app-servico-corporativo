package br.smartbusiness.metadado.servico.implementacao;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.appsmartbusiness.persistencia.conversores.Conversor;
import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.interfaces.IComponenteTelaService;
import br.com.app.smart.business.processoconfiguracao.dto.ResultadoConvercaoComponenteUI;
import br.com.app.smart.business.tela.componente.dto.ComponenteDTO;
import br.com.app.smart.business.tela.componente.dto.ComponenteTelaDTO;
import br.com.app.smart.business.tela.componente.dto.CompositeDTO;
import br.com.app.smart.business.tela.componente.dto.CompositeInterfaceDTO;
import br.smartbusiness.metadado.conversor.ConversorBean;
import br.smartbusiness.metadado.servico.interfaces.IComponenteServiceLocal;
import br.smartbusiness.metadado.uicomponent.bean.IComposite;
import br.smartbusiness.metadado.uicomponent.bean.ICompositeInterfaces;
import br.smartbusiness.metadado.uicomponent.bean.MetaDado;

@Stateless
@Remote(IComponenteTelaService.class)
public class ComponenteTelaServiceImp implements IComponenteTelaService {

	@EJB(beanName = "ComponenteServiceImp", beanInterface = IComponenteServiceLocal.class)
	private IComponenteServiceLocal componenteService;

	@PostConstruct
	public void init() {

		System.out.println("Injetando IComponenteServiceLocal: " + componenteService);
	}

	@Override
	public List<CompositeDTO> converterArquivo(List<File> files) {

		try {

			List<CompositeDTO> compositesDTO = new ArrayList<CompositeDTO>();
			List<IComposite> listacomposites = componenteService.converterArquivo(files);
			for (IComposite iComposite : listacomposites) {

				CompositeDTO componenteDTO = ConversorBean.converterICompositeParaCompositeDTO(iComposite);
				compositesDTO.add(componenteDTO);
			}
			return compositesDTO;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public List<ComponenteTelaDTO> converterCompositeInterfaces(List<CompositeInterfaceDTO> compositeInterfaceDTOs)
			throws InfraEstruturaException {

		if (compositeInterfaceDTOs == null) {
			return null;
		}
		List<ICompositeInterfaces> compositeInterfacesDTOS = new ArrayList<ICompositeInterfaces>();
		for (CompositeInterfaceDTO compositeInterfaceDTO : compositeInterfaceDTOs) {

			ICompositeInterfaces compositeInterfaces = ConversorBean
					.converterCompositeInterfacesDTO(compositeInterfaceDTO);
			compositeInterfacesDTOS.add(compositeInterfaces);
		}

		List<MetaDado> metadados = componenteService.converterCompositeInterfaces(compositeInterfacesDTOS);

		List<ComponenteTelaDTO> listeComponenteTelaDTO = new ArrayList<ComponenteTelaDTO>();
		int identificador = 0;
		for (MetaDado metaDado : metadados) {

			ComponenteTelaDTO componenteTelaDTO = Conversor.converter(metaDado, ComponenteTelaDTO.class);

			for (ComponenteDTO cnp : componenteTelaDTO.getComponentes()) {

				cnp.setIdentificador(++identificador);
			}

			listeComponenteTelaDTO.add(componenteTelaDTO);
		}

		return listeComponenteTelaDTO;
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
	public ResultadoConvercaoComponenteUI converterComponenteUI(List<ComponenteTelaDTO> metadados) {

		try {

			List<MetaDado> listeMetaDado = new ArrayList<MetaDado>();
			for (ComponenteTelaDTO componenteDTO : metadados) {

				MetaDado MetaDado = Conversor.converter(componenteDTO, MetaDado.class);
				listeMetaDado.add(MetaDado);
			}
			ResultadoConvercaoComponenteUI resultado = new ResultadoConvercaoComponenteUI();
			resultado.setComponeteXhtml(componenteService.converterComponenteUI(listeMetaDado));
			resultado.setComponenteXml(componenteService.converterEmXml(listeMetaDado));
			return resultado;
		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

}
