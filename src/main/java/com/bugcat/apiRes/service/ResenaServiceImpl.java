
package com.bugcat.apiRes.service;

import com.bugcat.apiRes.dao.ResenaRepository;
import com.bugcat.apiRes.entity.ResenaValoracion;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ResenaServiceImpl implements ResenaService {
    
    @Autowired
    private ResenaRepository resenaRepository;

    @Override
    public List<ResenaValoracion> findAll() {
         return resenaRepository.findAll();
    }

    @Override
    public ResenaValoracion findByResenavalSK(String resenavalSK) {
      return resenaRepository.findByResenavalSK(resenavalSK);
    }

    @Override
    public ResenaValoracion add(ResenaValoracion resenavaloracion) {
      return resenaRepository.save(resenavaloracion);
    }

    @Override
    public ResenaValoracion update(ResenaValoracion resenavaloracion) {
      var resenaDB = resenaRepository.findById(resenavaloracion.getId()).get();
        resenaDB.setComentario(resenavaloracion.getComentario());
        resenaDB.setValoracion(resenavaloracion.getValoracion());
         resenaDB.setFecha(resenavaloracion.getFecha());
         resenaDB.setTitulo(resenavaloracion.getTitulo());
          resenaDB.setResenavalSK(resenavaloracion.getResenavalSK());
        return resenaRepository.save(resenaDB);
    }

    @Override
    public void delete(Long id) {
      var resenaDB = resenaRepository.findById(id).get();
        resenaRepository.delete(resenaDB);
    }
    
}
