package br.com.antrata.dao;

import java.util.List;

import br.com.antrafa.entity.Cliente;
import br.com.antrafa.entity.EntityBase;

public interface DataAcessObject<E extends EntityBase,P> {

	public List<E> findAll();
	public E findById(P id);
	public void delete(E cliente);
	public E save(E cliente);
	
}