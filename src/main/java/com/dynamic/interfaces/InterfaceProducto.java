package com.dynamic.interfaces;


import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import com.dynamic.model.Producto;

@Repository
public interface InterfaceProducto extends CrudRepository<Producto, Integer>{

	

}