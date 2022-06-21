package com.dynamic.jasper.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.dynamic.jasper.model.ReporteInventarioDTO;

import net.sf.jasperreports.engine.JRException;

public interface ReporteInventarioService {
	
	ReporteInventarioDTO inventario(Map<String, Object>params) throws JRException, IOException, SQLException;

}
