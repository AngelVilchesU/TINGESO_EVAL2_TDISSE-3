package com.mueblesStgo.mueblesStgo.controllers;

import com.mueblesStgo.mueblesStgo.entities.AutorizacionEntity;
import com.mueblesStgo.mueblesStgo.services.AutorizacionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/autorizacion")
@CrossOrigin
public class AutorizacionController {
    @Autowired
    AutorizacionService autorizacionService;

    @GetMapping()
    public List<AutorizacionEntity> obtenerAutorizaciones(){
        return autorizacionService.obtenerAutorizaciones();
    }

    @PostMapping("/ingresarAutorizacion")
    public String guardarAutorizacion(
            @RequestBody AutorizacionEntity jsonAutorizacion){
        AutorizacionEntity resultado = autorizacionService.guardarAutorizacion(jsonAutorizacion);
        return "Recibido";
    }
}
