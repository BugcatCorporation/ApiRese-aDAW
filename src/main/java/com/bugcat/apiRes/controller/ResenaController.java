
package com.bugcat.apiRes.controller;

import com.bugcat.apiRes.entity.ResenaValoracion;
import com.bugcat.apiRes.service.ResenaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/resena")


public class ResenaController {
    @Autowired
    private ResenaService resenaService;
    @GetMapping("findAll")
    public ResponseEntity<List<ResenaValoracion>> findAll(){
        return new ResponseEntity<>(resenaService
                .findAll(),
                HttpStatus.OK);
    }
    
    @GetMapping("findByResenavalSK/{resenavalSK}")
    public ResponseEntity<ResenaValoracion> findByResenavalSK(
            @PathVariable String resenavalSK){
        return new ResponseEntity<>(resenaService
                .findByResenavalSK(resenavalSK),
                HttpStatus.OK);
    }
    
    @PostMapping("add")
    public ResponseEntity<ResenaValoracion> add(
            @RequestBody ResenaValoracion resenaValoracion){
        return new ResponseEntity<>(resenaService
                .add(resenaValoracion),
                HttpStatus.CREATED);
    }
    
    
    @PutMapping("update")
    public ResponseEntity<ResenaValoracion> update(@RequestBody ResenaValoracion resenaValoracion) {
        return new ResponseEntity<>(resenaService.update(resenaValoracion), HttpStatus.OK);
    }

     @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable Long id){
        resenaService.delete(id);
    }
    
    
}
