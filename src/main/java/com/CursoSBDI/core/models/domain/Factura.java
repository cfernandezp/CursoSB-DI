package com.CursoSBDI.core.models.domain;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;


@Component
@RequestScope // bean va a durar lo que dura una peticcion hhtp de Usuario. Factura Distinta y propia.
//@SessionScope
//@ApplicationScope // Singleton que se guarda en servlet Context
public class Factura implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@Value("${factura.descripcion}")
	private String descripcion;

	@Autowired
	private Cliente cliente;
	
	@Autowired
	//@Qualifier("itemsFacturaOficina")	
	private List<ItemFactura> items;
	
	@PostConstruct // evento se ejecuta despues de crear el objeto y se alla realizado la DI
	public void inicializar() {
		cliente.setNombre(cliente.getNombre().concat(" ").concat("José"));
		descripcion = descripcion.concat(" del cliente ").concat(cliente.getNombre());
	}
	
	
	@PreDestroy // evento se ejecuta antes de destruir el objeto 
	public void destruir() {
		System.out.println("Factura destruida: ".concat(descripcion));
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public List<ItemFactura> getItems() {
		return items;
	}

	public void setItems(List<ItemFactura> items) {
		this.items = items;
	}



}
