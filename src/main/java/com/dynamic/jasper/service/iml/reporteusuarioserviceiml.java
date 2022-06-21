/**
 * 
 */
package com.dynamic.jasper.service.iml;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynamic.jasper.model.reporteusuarioDTO;
import com.dynamic.jasper.service.reporteusuarioservice;
import com.dynamic.jaspercommons.JasperReportManager;
import com.dynamic.jasperenums.ReporteEnum;

import net.sf.jasperreports.engine.JRException;

@Service
public class reporteusuarioserviceiml implements reporteusuarioservice {

	@Autowired
	private JasperReportManager reportManager;
	@Autowired
	private DataSource data;

	@Override
	public reporteusuarioDTO obtenerusu(Map<String, Object> params) throws JRException, IOException, SQLException {

		String fileName = "empleadosactivos";
		reporteusuarioDTO dto = new reporteusuarioDTO();
		String extension = params.get("tipo").toString().equalsIgnoreCase(ReporteEnum.EXCEL.name()) ? ".xlsx" : ".pdf";
		dto.setFileName(fileName + extension);

		ByteArrayOutputStream stream = reportManager.export(fileName, params.get("tipo").toString(), params,
				data.getConnection());

		byte[] bs = stream.toByteArray();
		dto.setStream(new ByteArrayInputStream(bs));
		dto.setLength(bs.length);
		
		return dto;
	}

}
