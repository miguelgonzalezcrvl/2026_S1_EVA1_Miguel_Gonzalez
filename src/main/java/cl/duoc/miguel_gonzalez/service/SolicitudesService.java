package cl.duoc.miguel_gonzalez.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
    
    public Optional<Solicitudes> getSolicitudesById(Long id){
	return solicitudesRepository.findById(id);
    }

    public Solicitudes createProduct(Solicitudes solicitudes){
        return solicitudesRepository.save(solicitudes);
    }

    public Optional<Solicitudes> updateSolicitudes(Long id, Solicitudes solicitudes) {
        if (solicitudesRepository.existsById(id)){
            solicitudes.setId(id);
            return Optional.of(solicitudesRepository.save(solicitudes));
        }
        return Optional.empty(); 
    }

    public boolean deleteSolicitudes(Long id){
        if(solicitudesRepository.existsById(id)){
            solicitudesRepository.deleteById(id);
            return true;
        }
        return false;
    }
    
    public List<Solicitudes> filterByEstado(String estado) {
    return solicitudesRepository.findAll().stream()
            .filter(s -> s.getEstado().equalsIgnoreCase(estado))
            .collect(Collectors.toList());
}
}
