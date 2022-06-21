package com.dynamic.jasper.service.iml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynamic.jasper.model.ReporteInventarioDTO;
import com.dynamic.jasper.service.ReporteInventarioService;
import com.dynamic.jaspercommons.JasperReportManager;
import com.dynamic.jasperenums.ReporteEnum;

import net.sf.jasperreports.engine.JRException;

@Service
public class ReporteInventarioServiceiml implements ReporteInventarioService{
	
	@Autowired
	private JasperReportManager manager;
	@Autowired
	private DataSource con;
	
	
	@Override
	public ReporteInventarioDTO inventario(Map<String, Object> params) throws JRException, IOException, SQLException {
		
		String fileName = "reporteinventario";
		ReporteInventarioDTO dto = new ReporteInventarioDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(ReporteEnum.EXCEL.name()) ? ".xlsx" : ".pdf";
		dto.setFileName(fileName + extension);
		
		ByteArrayOutputStream stream = manager.export(fileName, params.get("tipo").toString(), params, con.getConnection());
		
	byte[] bs = stream.toByteArray();
	dto.setStream(new ByteArrayInputStream(bs));	
	dto.setLength(bs.length);		
	return dto;
	}

}
