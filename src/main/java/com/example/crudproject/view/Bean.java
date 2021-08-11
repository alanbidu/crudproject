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
		System.out.println("Saindo de adicionar ");
		return "crud.xhtml?faces-redirect=true";
	}

	public String updatePage(Long id) {
		System.out.println("Entrando no updatePage");
		return "updatecrud.xhtml?faces-redirect=true";
	}

	public String update(Long id) {
		return "updatecrud.xhtml?faces-redirect=true";
	}

	public String delete(Long id) {
		System.out.println("delete de Bean id = " + id);

//		return operacaoBDCliente.delete(id);
		return "crud.xhtml?faces-redirect=true";
	}

	public Cliente getCliente() {
		return cliente;
	}

	public List<Cliente> getClientes() {
		System.out.println("Entrando getClientes");
		return clientes;
	}

}
