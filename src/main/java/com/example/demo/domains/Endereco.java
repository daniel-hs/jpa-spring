package com.example.demo.domains;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity(name = "TB_ENDERECO")
public class Endereco implements Serializable{

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "street")
	private String rua;
	
	@Column(name = "neighborhood")
	private String bairro;
	
	@Column(name = "number")
	private Integer numero;

	@ManyToOne
	@JoinColumn(name = "estado_id")
	@OnDelete(action = OnDeleteAction.CASCADE)
	private Estado estado;
	
	public Endereco() {
		
	}
	
	public Endereco(Long id, String rua, String bairro, Integer numero, Estado estado) {
		super();
		this.id = id;
		this.rua = rua;
		this.bairro = bairro;
		this.numero = numero;
		this.estado = estado;
	}


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}
	
}
