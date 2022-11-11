package com.mueblesStgo.mueblesStgo.services;

import com.mueblesStgo.mueblesStgo.entities.AutorizacionEntity;
import com.mueblesStgo.mueblesStgo.repositories.AutorizacionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class AutorizacionService {
    @Autowired // Proporciona control de instancias
    AutorizacionRepository autorizacionRepository;

    public List<AutorizacionEntity> obtenerAutorizaciones(){
        return (List<AutorizacionEntity>) autorizacionRepository.findAll();
    }

    public AutorizacionEntity guardarAutorizacion (AutorizacionEntity autorizacion){
        return autorizacionRepository.save(autorizacion);
    }

    public LocalDate fechaFormato(String fecha){
        String[] parte = fecha.split("-");
        int dia = Integer.parseInt(parte[2]);
        int mes = Integer.parseInt(parte[1]);
        int anio = Integer.parseInt(parte[0]);
        return LocalDate.of(anio, mes, dia);
    }


    public boolean tieneAutorizacion(LocalDate fechaHorasExtra, String rutEmpleado){
        List<AutorizacionEntity> autorizacionEntityList = obtenerAutorizaciones();
        for (int i = 0; i < autorizacionEntityList.size(); i++){
            if(autorizacionEntityList.get(i).getFechaHoraExtra().equals(fechaHorasExtra) &&
                    autorizacionEntityList.get(i).getRutEmpleado().equals(rutEmpleado)){
                return true;
            }
        }
        return false;
    }

    public float horasExtra(LocalDate fechaHorasExtra, String rutEmpleado){
        List<AutorizacionEntity> autorizacionEntityList = obtenerAutorizaciones();
        for (int i = 0; i < autorizacionEntityList.size(); i++){
            if(autorizacionEntityList.get(i).getFechaHoraExtra().equals(fechaHorasExtra) &&
                    autorizacionEntityList.get(i).getRutEmpleado().equals(rutEmpleado)){
                return autorizacionEntityList.get(i).getHorasExtra();
            }
        }
        return 0;
    }
}
