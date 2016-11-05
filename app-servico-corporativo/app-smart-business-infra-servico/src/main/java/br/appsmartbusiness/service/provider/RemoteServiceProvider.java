package br.appsmartbusiness.service.provider;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.spi.CreationalContext;
import javax.enterprise.inject.Default;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.Bean;
import javax.enterprise.inject.spi.BeanManager;
import javax.inject.Named;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import br.com.app.smart.business.conta.dto.AssinaturaDTO;
import br.com.app.smart.business.conta.dto.ContaDTO;
import br.com.app.smart.business.conta.dto.ContratoDTO;
import br.com.app.smart.business.dao.interfaces.IServicoLocalDAO;
import br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO;
import br.com.app.smart.business.funcionalidade.dto.FuncionalidadeDTO;
import br.com.app.smart.business.funcionalidade.dto.GrupoFuncionalidadeDTO;
import br.com.app.smart.business.funcionalidade.dto.MetaDadoDTO;
import br.com.app.smart.business.funcionalidade.dto.PerfilDTO;
import br.com.app.smart.business.parametro.dto.ParametroDTO;
import br.com.app.smart.business.usuario.dto.SenhaDTO;
import br.com.app.smart.business.usuario.dto.UsuarioDTO;

@ApplicationScoped
@Named
public class RemoteServiceProvider implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@EJB(lookup = "java:global/app-corporativo/app-smart-business-pmt/ParametroServiceImp!br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO", beanName = "ParametroServiceImp", beanInterface = IServicoRemoteDAO.class)
	private IServicoRemoteDAO<ParametroDTO> parametroService;

	@EJB(lookup = "java:global/app-corporativo/app-smart-business-cta/AssinaturaServiceImp!br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO", beanName = "AssinaturaServiceImp", beanInterface = IServicoRemoteDAO.class)
	private IServicoRemoteDAO<AssinaturaDTO> assinaturaService;

	@EJB(lookup = "java:global/app-corporativo/app-smart-business-cta/ContaServiceImp!br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO", beanName = "ContaServiceImp", beanInterface = IServicoRemoteDAO.class)
	private IServicoRemoteDAO<ContaDTO> contaService;

	@EJB(lookup = "java:global/app-corporativo/app-smart-business-cta/ContratoServiceImp!br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO", beanName = "ContratoServiceImp", beanInterface = IServicoRemoteDAO.class)
	private IServicoRemoteDAO<ContratoDTO> contratoService;

	@EJB(lookup = "java:global/app-corporativo/app-smart-business-fnc-mdo/FuncionalidadeServiceImp!br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO", beanName = "FuncionalidadeServiceImp", beanInterface = IServicoRemoteDAO.class)
	private IServicoRemoteDAO<FuncionalidadeDTO> funcionalidadeService;

	@EJB(lookup = "java:global/app-corporativo/app-smart-business-fnc-mdo/MetaDadoServiceImp!br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO", beanName = "MetaDadoServiceImp", beanInterface = IServicoRemoteDAO.class)
	private IServicoRemoteDAO<MetaDadoDTO> metaDadoService;

	@EJB(lookup = "java:global/app-corporativo/app-smart-business-fnc-mdo/GrupoFuncionalidadeServiceImp!br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO", beanName = "GrupoFuncionalidadeServiceImp", beanInterface = IServicoRemoteDAO.class)
	private IServicoRemoteDAO<GrupoFuncionalidadeDTO> grupoFuncionalidadeService;

	@EJB(lookup = "java:global/app-corporativo/app-smart-business-fnc-mdo/PerfilServiceImp!br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO", beanName = "PerfilServiceImp", beanInterface = IServicoRemoteDAO.class)
	private IServicoRemoteDAO<PerfilDTO> perfilService;

	@EJB(lookup = "java:global/app-corporativo/app-smart-business-usr/SenhaServiceImp!br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO", beanName = "SenhaServiceImp", beanInterface = IServicoRemoteDAO.class)
	private IServicoRemoteDAO<SenhaDTO> senhaService;

	@EJB(lookup = "java:global/app-corporativo/app-smart-business-usr/UsuarioServiceImp!br.com.app.smart.business.dao.interfaces.IServicoRemoteDAO", beanName = "UsuarioServiceImp", beanInterface = IServicoRemoteDAO.class)
	private IServicoRemoteDAO<UsuarioDTO> usuarioService;

	@Default
	@Produces
	public IServicoRemoteDAO<ParametroDTO> getParametroService() {
		System.out.println("Injetando Servico parametroService");
		return parametroService;
	}

	@Default
	@Produces
	public IServicoRemoteDAO<AssinaturaDTO> getAssinaturaService() {
		return assinaturaService;
	}

	@Default
	@Produces
	public IServicoRemoteDAO<ContaDTO> getContaService() {
		return contaService;
	}

	@Default
	@Produces
	public IServicoRemoteDAO<ContratoDTO> getContratoService() {
		return contratoService;
	}

	@Default
	@Produces
	public IServicoRemoteDAO<FuncionalidadeDTO> getFuncionalidadeService() {
		return funcionalidadeService;
	}

	@Default
	@Produces
	public IServicoRemoteDAO<MetaDadoDTO> getMetaDadoService() {
		return metaDadoService;
	}

	@Default
	@Produces
	public IServicoRemoteDAO<GrupoFuncionalidadeDTO> getGrupoFuncionalidadeService() {
		return grupoFuncionalidadeService;
	}

	@Default
	@Produces
	public IServicoRemoteDAO<PerfilDTO> getPerfilService() {
		return perfilService;
	}

	@Default
	@Produces
	public IServicoRemoteDAO<SenhaDTO> getSenhaService() {
		return senhaService;
	}

	@Default
	@Produces
	public IServicoRemoteDAO<UsuarioDTO> getUsuarioService() {
		return usuarioService;
	}

	/**
	 * Carrega instância da service passada como parâmetro do contexto
	 * 
	 * @param clazz
	 * @return
	 */
	private static Object carregaService(Class clazz) {
		Object service = null;
		BeanManager beanManager = getBeanManager();
		try {
			for (Bean<?> bean : beanManager.getBeans(clazz)) {
				try {
					CreationalContext contexto = beanManager.createCreationalContext(bean);
					service = bean.create(contexto);
					break;
				} catch (Exception e) {
				}
			}
		} catch (Exception e) {
		}

		return service;
	}

	/**
	 * @return
	 */
	public static final BeanManager getBeanManager() {
		try {
			InitialContext initialContext = new InitialContext();
			return (BeanManager) initialContext.lookup("java:comp/BeanManager");
		} catch (NamingException e) {
			return null;
		}
	}
}
