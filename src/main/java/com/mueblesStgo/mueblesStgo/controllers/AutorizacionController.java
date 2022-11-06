package com.mueblesStgo.mueblesStgo.controllers;

import com.mueblesStgo.mueblesStgo.entities.AutorizacionEntity;
import com.mueblesStgo.mueblesStgo.services.AutorizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;

@RestController
@RequestMapping("/autorizacion")
@CrossOrigin
public class AutorizacionController {
    @Autowired
    AutorizacionService autorizacionService;

    @PostMapping("/ingresarAutorizacion")
    public String guardarAutorizacion(@RequestParam(name="rut") String r, @RequestParam(name="fecha") String f, @RequestParam(name="hora") String h){
        AutorizacionEntity aut = new AutorizacionEntity();
        aut.setRutEmpleado(r);
        LocalDate fechaFormato = autorizacionService.fechaFormato(f);
        aut.setFechaHoraExtra(fechaFormato);
        aut.setHorasExtra(Integer.valueOf(h));
        autorizacionService.guardarAutorizacion(aut);
        return "Recibido";
    }
}
