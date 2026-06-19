package com.viajes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.viajes.service.AsientoService;
import com.viajes.service.HorarioService;

@Controller

public class AsientoController {
@Autowired
private HorarioService serviceH;
@Autowired
private AsientoService serviceA;



}
