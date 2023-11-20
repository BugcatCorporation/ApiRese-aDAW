
package com.bugcat.apiRes.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.Data;

@Entity
@Data
public class ResenaValoracion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String comentario;
    private int valoracion;
    private Date fecha;
    private String titulo;
    private String resenavalSK;
}
