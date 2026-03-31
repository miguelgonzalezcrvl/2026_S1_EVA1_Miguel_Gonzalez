package cl.duoc.miguel_gonzalez.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cl.duoc.miguel_gonzalez.model.Solicitudes;
import cl.duoc.miguel_gonzalez.repository.SolicitudesRepository;

@Service
public class SolicitudesService {

    @Autowired
    private SolicitudesRepository solicitudesRepository;

     public SolicitudesService(SolicitudesRepository solicitudesRepository){
        this.solicitudesRepository = solicitudesRepository;
    }

      public List<Solicitudes> getAllProducts(){
        return solicitudesRepository.findAll();
    }
    
}
