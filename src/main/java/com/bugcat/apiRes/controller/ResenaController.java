package com.bugcat.apiRes.controller;

import com.bugcat.apiRes.entity.ResenaValoracion;
import com.bugcat.apiRes.service.ResenaService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/resena")
@Slf4j
public class ResenaController {

    @Autowired
    private ResenaService resenaService;

    @GetMapping("findAll")
    public ResponseEntity<List<ResenaValoracion>> findAll() {
        try {
            log.info("Reseñas obtenidas.");
            return new ResponseEntity<>(resenaService.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al obtener todas las reseñas.", e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("findByResenavalSK/{resenavalSK}")
    public ResponseEntity<ResenaValoracion> findByResenavalSK(
            @PathVariable String resenavalSK) {
        try {
            log.info("Reseña encontrada.", resenavalSK);
            return new ResponseEntity<>(resenaService.findByResenavalSK(resenavalSK), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al buscar reseña por ResenavalSK: {}.", resenavalSK, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("add")
    public ResponseEntity<ResenaValoracion> add(
            @RequestBody ResenaValoracion resenaValoracion) {
        try {
            log.info("Reseña agregada.", resenaValoracion);
            return new ResponseEntity<>(resenaService.add(resenaValoracion), HttpStatus.CREATED);
        } catch (Exception e) {
            log.error("Error al agregar nueva reseña: {}.", resenaValoracion, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("update")
    public ResponseEntity<ResenaValoracion> update(@RequestBody ResenaValoracion resenaValoracion) {
        try {
            log.info("Reseña actualizada {}.", resenaValoracion);
            return new ResponseEntity<>(resenaService.update(resenaValoracion), HttpStatus.OK);
        } catch (Exception e) {
            log.error("Error al actualizar reseña: {}.", resenaValoracion, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        try {
            log.info("Eliminando reseña con ID: {}.", id);
            resenaService.delete(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            log.error("Error al eliminar reseña con ID: {}.", id, e);
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
