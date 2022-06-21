package com.dynamic.jasper.service.iml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynamic.jasper.model.FacturaDTO;
import com.dynamic.jasper.service.FacturaService;
import com.dynamic.jaspercommons.JasperReportManager;
import com.dynamic.jasperenums.ReporteEnum;

import net.sf.jasperreports.engine.JRException;

@Service
public class FacturaServiceiml implements FacturaService{

	@Autowired	
	private JasperReportManager manager;
	@Autowired
	private DataSource bdconect;

	
	@Override
	public FacturaDTO factura(Map<String, Object> params) throws JRException, IOException, SQLException {
		
		String fileName = "factura";
		FacturaDTO dto = new FacturaDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(ReporteEnum.EXCEL.name()) ? ".xlsx" : ".pdf";
		dto.setFileName(fileName + extension);		
		
		
		ByteArrayOutputStream stream = manager.export(fileName, params.get("tipo").toString(), params, bdconect.getConnection());								 							
		
		
		byte []bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		
		return dto;
	}
	
}
