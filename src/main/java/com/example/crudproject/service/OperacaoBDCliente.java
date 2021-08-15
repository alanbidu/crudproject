package com.example.crudproject.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.crudproject.model.Cliente;

@Stateless
public class OperacaoBDCliente {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(Cliente cliente) {
		entityManager.persist(cliente);
	}

	public List<Cliente> list() {

		return entityManager.createQuery("FROM Cliente c", Cliente.class).getResultList();
	}

	public void delete(Long id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		entityManager.remove(entityManager.merge(cliente));
	}
	
	public String update(Cliente cliente) {
		
		Cliente clienteUpdate = entityManager.find(Cliente.class, cliente.getId());
//		clienteUpdate.setId(cliente.getId());
		clienteUpdate.setNome(cliente.getNome());
		clienteUpdate.setData(cliente.getData());
		clienteUpdate.setValor(cliente.getValor());
		clienteUpdate.setSexo(cliente.getSexo());
		clienteUpdate.setEstadoCivil(cliente.getEstadoCivil());
		
		return "crud.xhtml";
	}
	
}