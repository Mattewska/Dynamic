package com.dynamic.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dynamic.model.Categoria;

@Repository
public interface InterfaceCategoria extends CrudRepository<Categoria, Long>{

}
