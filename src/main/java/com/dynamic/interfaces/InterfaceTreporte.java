package com.dynamic.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dynamic.model.TipoReporte;

@Repository
public interface InterfaceTreporte extends JpaRepository<TipoReporte, Long> {

}