package com.emssanar.microservicios.commons.ips.models.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Temporal;

//import com.emssanar.microservicios.commons.afiliados.models.entity.Afiliado;
import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.PrePersist;
import jakarta.persistence.Table;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name="ips")
public class Ips {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	private String nit;
	
	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String direccion;
	
	@NotEmpty
	private String telefono;
	
	
	@Email
	private String email;
	
	@Column(name="create_at")
	@jakarta.persistence.Temporal(TemporalType.TIMESTAMP)
	private Date createAt;
	
//	@OneToMany(mappedBy = "ips")
  //  private List<Afiliado> afiliados;
	
	@PrePersist
	public void prePersist() {
		this.createAt= new Date();
	}
	
	//public Ips() {
		//this.afiliados=new ArrayList<>();
	//}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}



	public String getNit() {
		return nit;
	}



	public void setNit(String nit) {
		this.nit = nit;
	}



	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getDireccion() {
		return direccion;
	}



	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}



	public String getTelefono() {
		return telefono;
	}



	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public Date getCreateAt() {
		return createAt;
	}



	public void setCreateAt(Date createAt) {
		this.createAt = createAt;
	}

	//public List<Afiliado> getAfiliados() {
		//return afiliados;
	//}

	//public void setAfiliados(List<Afiliado> afiliados) {
		//this.afiliados = afiliados;
	//}

	
		
}
