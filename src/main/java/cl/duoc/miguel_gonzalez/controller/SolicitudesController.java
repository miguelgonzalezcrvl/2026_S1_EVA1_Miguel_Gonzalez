package cl.duoc.miguel_gonzalez.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.duoc.miguel_gonzalez.model.Solicitudes;
import cl.duoc.miguel_gonzalez.service.SolicitudesService;
import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("/api/v1/solicitudes")
public class SolicitudesController {

    @Autowired
    private SolicitudesService solicitudesService;

    @GetMapping
    public ResponseEntity<List<Solicitudes>> getAllSolicitudes(){
        return ResponseEntity.ok(solicitudesService.getAllProducts());
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<?> getProductById(@PathVariable Long id){
        return solicitudesService.getSolicitudesById(id)
            .map(ResponseEntity::ok)
            .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<?> createProduct(@Valid @RequestBody Solicitudes solicitudes) {
        return ResponseEntity.ok(solicitudesService.createProduct(solicitudes));
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> updateProduct(@PathVariable Long id, @Valid @RequestBody Solicitudes solicitudes) {
        return solicitudesService.updateSolicitudes(id, solicitudes)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteProduct(@PathVariable Long id) {
        return solicitudesService.deleteSolicitudes(id)
                ? ResponseEntity.noContent().build()
                : ResponseEntity.notFound().build();
    }

    @GetMapping("/filtro")
    public ResponseEntity<List<Solicitudes>> filterByEstado(@RequestParam String estado) {
        return ResponseEntity.ok(solicitudesService.filterByEstado(estado));
    }
}
