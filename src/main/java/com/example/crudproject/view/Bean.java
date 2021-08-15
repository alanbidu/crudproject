package com.example.crudproject.view;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.crudproject.model.Cliente;
import com.example.crudproject.service.OperacaoBDCliente;

@Named
@SessionScoped
public class Bean implements Serializable {

	private static final long serialVersionUID = 1L;
	private Cliente cliente = new Cliente();
	private List<Cliente> clientes;

	@Inject
	private OperacaoBDCliente operacaoBDCliente;

	@PostConstruct
	public void init() {
		clientes = operacaoBDCliente.list();
	}

	public void adicionar() {
		operacaoBDCliente.create(cliente);
		clientes.add(cliente);
		cliente = new Cliente();
	}

	public String updatePage(Cliente cliente) {
		this.cliente = cliente;

		return "updatecrud.xhtml";
	}

	public String update() {
		String crudPag = operacaoBDCliente.update(this.cliente);
		cliente = new Cliente();
		return crudPag;
	}

	public void delete(Long id) {
		operacaoBDCliente.delete(id);
		clientes = operacaoBDCliente.list();
	}

	public Cliente getCliente() {
		return cliente;
	}
	
	public List<Cliente> getClientes() {
		return clientes;
	}

}
