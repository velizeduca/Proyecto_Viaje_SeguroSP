package com.viajes.service;

import java.util.List;
import com.viajes.entity.Bus;

public interface BusService {

//crear metodos para el crud de la tabla tb_bus
	List<Bus>listar();
	void registrar(Bus obj);
	Bus buscarPorId(int id);
	void actualizar(Bus obj);
	void desactivar(int id); 
}


