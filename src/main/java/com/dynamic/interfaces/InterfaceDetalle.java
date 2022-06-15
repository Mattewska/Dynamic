package com.dynamic.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dynamic.model.Detalle;

@Repository
public interface InterfaceDetalle extends CrudRepository<Detalle, Long>{

	@Query(value=" SELECT * FROM dynamic1.detalle where d_facturas=?;", nativeQuery = true)
	public List<Detalle> listarPorIdFactura(Long id_factura);
	@Query(value=" SELECT * FROM dynamic1.detalle where d_facturas=?;", nativeQuery = true)
	public List<Detalle> porIdFactura(Long id_factura);
	@Query(value=" DELETE * FROM dynamic1.detalle where d_facturas=?;", nativeQuery = true)
	public Void DeleteD(Long id_factura);
}
