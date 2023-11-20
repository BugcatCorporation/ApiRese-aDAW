
package com.bugcat.apiRes.service;

import com.bugcat.apiRes.entity.ResenaValoracion;
import java.util.List;

public interface ResenaService {
    List<ResenaValoracion> findAll();
    ResenaValoracion findByResenavalSK(String resenavalSK);
    ResenaValoracion add(ResenaValoracion resenavaloracion);
    ResenaValoracion update(ResenaValoracion resenavaloracion);
    public void delete(Long id);
}
