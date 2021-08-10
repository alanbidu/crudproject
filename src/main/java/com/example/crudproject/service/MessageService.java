package com.example.crudproject.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.example.crudproject.Cliente;

@Stateless
public class MessageService {

	@PersistenceContext
	private EntityManager entityManager;

	public void create(Cliente cliente) {
		entityManager.persist(cliente);
	}

	public List<Cliente> list() {

		return entityManager.createQuery("FROM Cliente c", Cliente.class).getResultList();
	}

	public String delete(Long id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		entityManager.remove(entityManager.merge(cliente));

		System.out.println("delete de MessageService");
		
		return "crud.xhtml?faces-redirect=true";
	}
}