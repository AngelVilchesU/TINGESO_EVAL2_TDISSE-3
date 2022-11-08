package com.mueblesStgo.mueblesStgo.controllers;

import com.mueblesStgo.mueblesStgo.entities.AutorizacionEntity;
import com.mueblesStgo.mueblesStgo.services.AutorizacionService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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

    private final Logger log = LoggerFactory.getLogger(AutorizacionController.class);
    @PostMapping("/ingresarAutorizacion")
    public @ResponseBody AutorizacionEntity guardarAutorizacion(
            @RequestBody AutorizacionEntity jsonAutorizacion){
        log.info("Request to create justification: {}", jsonAutorizacion);
        System.out.println(jsonAutorizacion.getRutEmpleado() + " " + jsonAutorizacion.getFechaHoraExtra());
        AutorizacionEntity resultado = autorizacionService.guardarAutorizacion(jsonAutorizacion);
        return jsonAutorizacion;
    }
}
