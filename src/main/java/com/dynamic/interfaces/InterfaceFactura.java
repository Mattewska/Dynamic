package com.dynamic.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dynamic.model.Factura;

@Repository
public interface InterfaceFactura extends CrudRepository<Factura, Long>{
	@Query(value="SELECT * FROM dynamic1.factura WHERE id_factura=?;", nativeQuery=true)
	public List<Factura> idFactura(Long id_factura);
}
