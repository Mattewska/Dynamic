package com.dynamic.interfaces;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dynamic.model.Domicilio;

@Repository
public interface InterfaceDomicilio extends CrudRepository<Domicilio, Integer>{
	@Query(value=" DELETE * FROM dynamic1.domicilio WHERE d_facturas=?;", nativeQuery = true)
	public Void DeleteDomi(Long id_factura);
	
	@Query(value="UPDATE domicilio SET e_domicilio = 2 WHERE id_domicilio =?;", nativeQuery = true)
	public Void ActualizarDomi(Integer id_domicilio);
}

