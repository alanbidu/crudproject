package com.example.crudproject.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.crudproject.Cliente;
import com.example.crudproject.service.OperacaoBDCliente;

@Named
@RequestScoped
public class Bean implements Serializable{

	private static final long serialVersionUID = 1L;
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes;
	
	private Long idCliente;

	@Inject
	private OperacaoBDCliente operacaoBDCliente;

	@PostConstruct
	public void init() {
		clientes = operacaoBDCliente.list();
	}

	public String adicionar() {
		operacaoBDCliente.create(cliente);
		clientes.add(cliente);
		cliente = new Cliente();
		return "crud.xhtml";
	}

	public String updatePage(Cliente cliente) {
		this.cliente = cliente;
		idCliente = this.cliente.getId();
		
		System.out.println("idCliente Bean.updatePage = " + idCliente);
		
		return "updatecrud.xhtml";
	}

	public String update() {
		System.out.println("idCliente Bean.update = " + idCliente);
		String crudPag = operacaoBDCliente.update(this.cliente, idCliente);
		cliente = new Cliente();
		return crudPag;
	}

	public String delete(Long id) {
		return operacaoBDCliente.delete(id);
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

}
