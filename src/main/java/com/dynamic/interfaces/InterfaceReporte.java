package com.dynamic.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dynamic.model.Reporte;

@Repository
public interface InterfaceReporte extends CrudRepository<Reporte, Integer>{

}
