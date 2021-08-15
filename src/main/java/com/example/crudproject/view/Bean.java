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
//		System.out.println("Construiu");
		clientes = operacaoBDCliente.list();
	}

	public String adicionar() {
		operacaoBDCliente.create(cliente);
		clientes.add(cliente);
		cliente = new Cliente();
		return "crud.xhtml";
	}

	public void atualizarClientes() {
		clientes = operacaoBDCliente.list();
//		for (int i = 0; i < clientes.size(); i++) {
//			System.out.println(clientes.get(i).getNome());
//		}
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

	public String delete(Long id) {
		String crudDel = operacaoBDCliente.delete(id);;
		clientes = operacaoBDCliente.list();
		return crudDel;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

}
