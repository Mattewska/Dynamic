package com.dynamic.interfaceService;

import java.util.List;
import java.util.Optional;

import com.dynamic.model.Domicilio;

public interface InterfaceDomicilioService {
	public List<Domicilio>Listar();
	public Optional<Domicilio>ListarID(int id_domicilio);
	public int save(Domicilio domi);
	public void delete(int id_domicilio);
	public void DeleteDomi(Long id_factura);
	public void ActualizarDomi(Integer id_domicilio);
}
