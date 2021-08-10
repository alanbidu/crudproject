package com.example.crudproject.view;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import com.example.crudproject.Cliente;
import com.example.crudproject.service.MessageService;

@Named
@RequestScoped
public class Bean {

	private Cliente cliente = new Cliente();
	private List<Cliente> clientes;

	@Inject
	private MessageService messageService;

	@PostConstruct
	public void init() {
		clientes = messageService.list();
	}

	public void add() {
		messageService.create(cliente);
		clientes.add(cliente);
		cliente = new Cliente();
		System.out.println("Saindo de add ");
	}

	public String updatePage(Long id) {
		return "updatecrud.xhtml?faces-redirect=true";
	}
	
	public String update(Long id) {
		return "crud.xhtml?faces-redirect=true";
	}
	
//	public String delete(Long id) {
//		System.out.println("delete de Bean");
//		
//		return messageService.delete(id);
//	}
	
	public Cliente getCliente() {
		return cliente;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

}
