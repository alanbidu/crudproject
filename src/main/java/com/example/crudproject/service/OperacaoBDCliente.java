package com.example.crudproject.service;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.example.crudproject.Cliente;

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

	public String delete(Long id) {
		Cliente cliente = new Cliente();
		cliente.setId(id);
		entityManager.remove(entityManager.merge(cliente));
		
		return "crud.xhtml?faces-redirect=true";
	}
	
	public String update(Cliente cliente) {
		Query queryObj = entityManager.createQuery("UPDATE Cliente c SET c.nome=:name,"
				+ " c.data=:data, c.valor=:valor, c.sexo=:sexo, c.estadoCivil=:estadoCivil"
				+ " WHERE c.id = :id");
		queryObj.setParameter("id", cliente.getId());
		queryObj.setParameter("name", cliente.getNome());
		queryObj.setParameter("data", cliente.getData());
		queryObj.setParameter("valor", cliente.getValor());
		queryObj.setParameter("sexo", cliente.getSexo());
		queryObj.setParameter("estadoCivil", cliente.getEstadoCivil());
		int isAtuaizou =  queryObj.executeUpdate();
		System.out.println("Atualizou? " + isAtuaizou);
		showTables();
		return "crud.xhtml?faces-redirect=true";
	}
	
	private void showTables() {
		Query queryObj = entityManager.createQuery("SELECT FIELD FROM (SHOW COLUMNS FROM Cliente)");
		List<String> tabelas = (List<String>) queryObj.getResultList();
		tabelas.forEach(System.out::println);
	}
	
}