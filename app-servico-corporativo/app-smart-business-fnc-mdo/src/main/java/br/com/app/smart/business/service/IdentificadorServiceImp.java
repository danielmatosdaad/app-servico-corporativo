package br.com.app.smart.business.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import br.appsmartbusiness.persistencia.service.ServiceDAO;
import br.com.app.smart.business.dao.facede.IdentificadorFacede;
import br.com.app.smart.business.dao.interfaces.IServicoLocalDAO;
import br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO;
import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.exception.NegocioException;
import br.com.app.smart.business.funcionalidade.dto.IdentificadorDTO;
import br.com.app.smart.business.model.Identificador;

@Stateless
@Remote(value = { IServicoRemoteDAO.class })
@Local(value = { IServicoLocalDAO.class })
public class IdentificadorServiceImp implements IServicoRemoteDAO<IdentificadorDTO>, IServicoLocalDAO<IdentificadorDTO> {

	@EJB
	private IdentificadorFacede identificadorFacade;

	@Override
	public IdentificadorDTO adiconar(IdentificadorDTO dto) throws InfraEstruturaException, NegocioException {

		try {
			if (dto != null && dto.getId() == null) {
				return ServiceDAO.adiconar(this.identificadorFacade, Identificador.class, dto);
			}
		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}

		return dto;
	}

	@Override
	public List<IdentificadorDTO> adiconar(List<IdentificadorDTO> listaDto) throws InfraEstruturaException, NegocioException {

		for (IdentificadorDTO IdentificadorDTO : listaDto) {
			adiconar(IdentificadorDTO);
		}
		return listaDto;
	}

	@Override
	public IdentificadorDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarPorID(this.identificadorFacade, IdentificadorDTO.class, id);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public void removerPorId(Long id) throws InfraEstruturaException, NegocioException {
		try {
		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public void remover(IdentificadorDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			ServiceDAO.remover(identificadorFacade, Identificador.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public IdentificadorDTO alterar(IdentificadorDTO dto) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.alterar(identificadorFacade, Identificador.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}

	}

	@Override
	public List<IdentificadorDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.bustarTodos(this.identificadorFacade, IdentificadorDTO.class);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public List<IdentificadorDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorIntervaloID(this.identificadorFacade, IdentificadorDTO.class, range);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

}
