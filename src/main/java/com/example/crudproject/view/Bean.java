package com.example.crudproject.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.crudproject.Cliente;
import com.example.crudproject.service.OperacaoBDCliente;

@Named
@RequestScoped
public class Bean {

	private Cliente cliente = new Cliente();

	private List<Cliente> clientes;

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
		return "updatecrud.xhtml";
	}

	public String update(Cliente cliente) {

		String crudPag = operacaoBDCliente.update(cliente);
		cliente = new Cliente();
		return crudPag;
//		return "updatecrud.xhtml?faces-redirect=true";
	}

	public String delete(Long id) {
		System.out.println("delete de Bean id = " + id);

		return operacaoBDCliente.delete(id);
//		return "crud.xhtml";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

}
