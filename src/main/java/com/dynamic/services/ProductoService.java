package com.dynamic.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dynamic.interfaceService.InterfaceProductoService;
import com.dynamic.interfaces.InterfaceProducto;
import com.dynamic.model.Producto;

@Service
public class ProductoService implements InterfaceProductoService {

	@Autowired
	private InterfaceProducto data;
	
	@Override
	public List<Producto> listar() {
		return (List<Producto>)data.findAll();
	}

	@Override
	public Optional<Producto> listarId(int id) {
		return data.findById(id);
	}

	@Override
	public int save(Producto p) {
		int res=0;
		Producto producto=data.save(p);
		if(producto.equals(null)){
			res=1;
		}
		return res;
	}

	@Override
	public void eliminar(int id) {
		data.deleteById(id);
	}

	public static List<Producto> findAll() {
		// TODO Auto-generated method stub
		return null;
	}

}