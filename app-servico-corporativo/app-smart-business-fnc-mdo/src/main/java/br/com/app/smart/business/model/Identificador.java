package br.com.app.smart.business.model;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;
import javax.xml.bind.annotation.XmlRootElement;

import br.com.app.smart.business.dao.interfaces.Entidade;

@Entity(name = "identificador")
@XmlRootElement
@Table(name = "identificador", uniqueConstraints = @UniqueConstraint(columnNames = "valor"))
public class Identificador implements Entidade, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue
	private Long id;

	private String valor;

	private String descricao;

	@Temporal(TemporalType.DATE)
	private Date dataInclusao;

	@Temporal(TemporalType.DATE)
	private Date dataAlteracao;

	@Enumerated(EnumType.STRING)
	private TipoIdentificador tipoIdentificador;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public TipoIdentificador getTipoIdentificador() {
		return tipoIdentificador;
	}

	public void setTipoIdentificador(TipoIdentificador tipoIdentificador) {
		this.tipoIdentificador = tipoIdentificador;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Date getDataInclusao() {
		return dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public String getValor() {
		return valor;
	}

	public void setValor(String valor) {
		this.valor = valor;
	}

	@Override
	public String toString() {
		System.out.println(this.getId());
		System.out.println(this.getValor());
		System.out.println(this.getDataAlteracao());
		System.out.println(this.getDescricao());
		return super.toString();
	}

}
