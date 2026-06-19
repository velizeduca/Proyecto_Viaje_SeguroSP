package com.viajes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.viajes.entity.Bus;
import com.viajes.entity.MarcaBus;
import com.viajes.service.BusService;
import com.viajes.service.MarcaBusService;

@Controller
@RequestMapping("/gestionbus")

public class BusController {

	@Autowired
	private BusService busService;
	
	@Autowired
	private MarcaBusService serviceMB;
	
	
	@GetMapping("/lista")
	
	public String listar(Model model) {
	model.addAttribute("mensaje","Bienvenido al modulo de Bus");
	model.addAttribute("buses",busService.listar());
	model.addAttribute("marcas",serviceMB.listar());
	
	//objeto vacio para registrar
	Bus bus=new Bus();
	bus.setMarcaBus(new MarcaBus());
	model.addAttribute("bus",bus);
	
	return "bus/mantBuses";
	}

	//get-->listar, buscar, eliminar
	//post-->registrar, actualizar
	
	//metodo para registrar datos del Bus
	
	@PostMapping("/registrar")
	public String registrarBus(Bus bus, RedirectAttributes redirect) {
		busService.registrar(bus);
		redirect.addFlashAttribute("mensajeExito","Bus registrado correctamente");
		return "redirect:/gestionbus/lista";
	}
	

	//metodo para buscar bus por codigo
	@GetMapping ("/buscar/{id}")
	@ResponseBody
	public Bus buscarPorId(@PathVariable int id) {
	 return busService.buscarPorId(id);	
	}
	
	
	//metodo para actualizar los datos del Bus
@PostMapping("/actualizar")
public String actualizarBus(Bus bus, RedirectAttributes redirect) {
	busService.actualizar(bus);
    redirect.addFlashAttribute("mensajeExito","bus actualizado correctamente");
    return "redirect:/gestionbus/lista";
}

//cambiar el estado de Bus
@GetMapping("/desactivar/{id}")
public String desactivarEstado(@PathVariable int id, RedirectAttributes redirect) {
busService.desactivar(id);
redirect.addFlashAttribute("mensajeExito","bus desactivado correctamente");
return "redirect:/gestionbus/lista";
}
	
	
	
	
}
