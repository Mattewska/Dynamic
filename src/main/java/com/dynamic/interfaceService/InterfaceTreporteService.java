package com.dynamic.interfaceService;

import java.util.List;
import java.util.Optional;


import com.dynamic.model.TipoReporte;


public interface InterfaceTreporteService {
public List<TipoReporte> listar();
public Optional<TipoReporte>listarid(long idr);
public int save(TipoReporte tr);
public void delete(long idr);

}
