 package com.dynamic.interfaceService;

import java.util.List;
import java.util.Optional;

import com.dynamic.model.Reporte;

public interface InterfaceReporteService {
	public List<Reporte>listar();
	public Optional<Reporte>listarId(int id);
	public int saveReporte(Reporte r);
	public void eliminarReporte(int id);
}
