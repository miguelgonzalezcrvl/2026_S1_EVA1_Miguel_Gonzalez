package cl.duoc.miguel_gonzalez.repository;

import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import cl.duoc.miguel_gonzalez.model.Solicitudes;

@Repository
public class SolicitudesRepository {

    private final Map<Long, Solicitudes> solicitudesStore = new HashMap<>();

    public List<Solicitudes> findAll(){
        return new ArrayList<>(solicitudesStore.values());
    }

    public Optional<Solicitudes> findById(Long id){
        return Optional.ofNullable(solicitudesStore.get(id));
    }

    public Solicitudes save (Solicitudes solicitudes){
        solicitudesStore.put(solicitudes.getId(), solicitudes);
        return solicitudes;
    }

    public boolean existsById(Long id){
        return solicitudesStore.containsKey(id);
    }
    
    public void deleteById(Long id){
        solicitudesStore.remove(id);
    }
}
