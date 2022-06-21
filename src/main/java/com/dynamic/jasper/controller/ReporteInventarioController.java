package com.dynamic.jasper.controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dynamic.jasper.model.ReporteInventarioDTO;
import com.dynamic.jasper.service.ReporteInventarioService;
import com.dynamic.jasperenums.ReporteEnum;

import net.sf.jasperreports.engine.JRException;

@RestController
@RequestMapping("/report")
public class ReporteInventarioController {

	@Autowired
	ReporteInventarioService ReporteInventarioService;

	@GetMapping(path = "inventario/download")
	public ResponseEntity<Resource> invdownload(@RequestParam Map<String, Object> params)
			throws JRException, IOException, SQLException {

		ReporteInventarioDTO dto = ReporteInventarioService.inventario(params);

		InputStreamResource streamResource = new InputStreamResource(dto.getStream());
		MediaType mediaType = null;

		if (params.get("tipo").toString().equalsIgnoreCase(ReporteEnum.EXCEL.name())) {
			mediaType = MediaType.APPLICATION_OCTET_STREAM;

		} else {

			mediaType = MediaType.APPLICATION_PDF;
		}

		return ResponseEntity.ok().header("Content-Disposition", "inline; filename=\"" + dto.getFileName() + "\"")
				.contentLength(dto.getLength()).contentType(mediaType).body(streamResource);

	}

}
