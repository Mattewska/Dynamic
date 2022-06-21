package com.dynamic.jasper.service;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import com.dynamic.jasper.model.ReporteBodegaDTO;

import net.sf.jasperreports.engine.JRException;

public interface ReporteBodegaService {

	ReporteBodegaDTO bodega (Map<String, Object> params) throws JRException, IOException, SQLException;
	
	
	
}
