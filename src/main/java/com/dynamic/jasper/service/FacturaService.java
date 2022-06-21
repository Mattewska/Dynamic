package com.dynamic.jasper.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.dynamic.jasper.model.FacturaDTO;

import net.sf.jasperreports.engine.JRException;

public interface FacturaService {
	
	FacturaDTO factura (Map<String, Object> params) throws JRException, IOException, SQLException;
	

}
