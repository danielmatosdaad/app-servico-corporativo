package br.com.app.smart.business.service;

import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Local;
import javax.ejb.Remote;
import javax.ejb.Stateless;
import br.appsmartbusiness.persistencia.service.ServiceDAO;
import br.com.app.smart.business.dao.facede.ParametroFacade;
import br.com.app.smart.business.dao.interfaces.IServicoLocalDAO;
import br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO;
import br.com.app.smart.business.exception.InfraEstruturaException;
import br.com.app.smart.business.exception.NegocioException;
import br.com.app.smart.business.model.Parametro;
import br.com.app.smart.business.parametro.dto.ParametroDTO;

@Stateless
@Remote(value = { IServicoRemoteDAO.class })
@Local(value = { IServicoLocalDAO.class })
public class ParametroServiceImp implements IServicoRemoteDAO<ParametroDTO>, IServicoLocalDAO<ParametroDTO> {


	@EJB
	ParametroFacade parametroFacede;

	@Override
	public ParametroDTO adiconar(ParametroDTO dto) throws InfraEstruturaException, NegocioException {

		try {
			return ServiceDAO.adiconar(this.parametroFacede, Parametro.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);

		}
	}

	@Override
	public List<ParametroDTO> adiconar(List<ParametroDTO> listaDto) throws InfraEstruturaException, NegocioException {

		for (ParametroDTO parametroDTO : listaDto) {
			adiconar(parametroDTO);
		}
		return listaDto;
	}

	@Override
	public ParametroDTO bustarPorID(Long id) throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarPorID(this.parametroFacede, ParametroDTO.class, id);
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

	public void remover(ParametroDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			ServiceDAO.remover(this.parametroFacede, Parametro.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	public ParametroDTO alterar(ParametroDTO dto) throws InfraEstruturaException, NegocioException {
		try {
			return ServiceDAO.alterar(this.parametroFacede, Parametro.class, dto);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}

	}

	@Override
	public List<ParametroDTO> bustarTodos() throws InfraEstruturaException, NegocioException {
		try {

			return ServiceDAO.bustarTodos(this.parametroFacede, ParametroDTO.class);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}

	@Override
	public List<ParametroDTO> bustarPorIntervaloID(int[] range) throws InfraEstruturaException, NegocioException {
		try {
			
			return ServiceDAO.bustarPorIntervaloID(this.parametroFacede, ParametroDTO.class, range);

		} catch (Exception e) {
			throw new InfraEstruturaException(e);
		}
	}
}
