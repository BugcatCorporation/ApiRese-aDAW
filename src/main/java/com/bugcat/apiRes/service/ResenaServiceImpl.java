package com.bugcat.apiRes.service;

import com.bugcat.apiRes.dao.ResenaRepository;
import com.bugcat.apiRes.entity.ResenaValoracion;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ResenaServiceImpl implements ResenaService {

    @Autowired
    private ResenaRepository resenaRepository;

    @Override
    public List<ResenaValoracion> findAll() {
        log.info("Obteniendo todas las reseñas.");
        return resenaRepository.findAll();
    }

    @Override
    public ResenaValoracion findByResenavalSK(String resenavalSK) {
        log.info("Buscando reseña por ResenavalSK: {}.", resenavalSK);
        return resenaRepository.findByResenavalSK(resenavalSK);
    }

    @Override
    public ResenaValoracion add(ResenaValoracion resenavaloracion) {
        log.info("Agregando nueva reseña: {}.", resenavaloracion);
        return resenaRepository.save(resenavaloracion);
    }

    @Override
    public ResenaValoracion update(ResenaValoracion resenavaloracion) {
        try {
            log.info("Actualizando reseña: {}.", resenavaloracion);
            var resenaDB = resenaRepository.findById(resenavaloracion.getId()).get();
            resenaDB.setComentario(resenavaloracion.getComentario());
            resenaDB.setValoracion(resenavaloracion.getValoracion());
            resenaDB.setFecha(resenavaloracion.getFecha());
            resenaDB.setTitulo(resenavaloracion.getTitulo());
            resenaDB.setResenavalSK(resenavaloracion.getResenavalSK());
            return resenaRepository.save(resenaDB);
        } catch (Exception e) {
            log.error("Error al actualizar reseña.", e);
            throw e;
        }
    }

    @Override
    public void delete(Long id) {
        try {
            log.info("Eliminando reseña con ID: {}.", id);
            var resenaDB = resenaRepository.findById(id).orElse(null);
            if (resenaDB != null) {
                resenaRepository.delete(resenaDB);
            } else {
                log.warn("No se encontró ninguna reseña con ID: {}.", id);
            }
        } catch (Exception e) {
            log.error("Error al eliminar reseña.", e);
            throw e;
        }
    }
}
