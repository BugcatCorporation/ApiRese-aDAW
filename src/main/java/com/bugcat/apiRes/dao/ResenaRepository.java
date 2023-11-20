
package com.bugcat.apiRes.dao;

import com.bugcat.apiRes.entity.ResenaValoracion;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ResenaRepository extends JpaRepository<ResenaValoracion, Long> {
    
    ResenaValoracion findByResenavalSK(String resenavalSK);
}
