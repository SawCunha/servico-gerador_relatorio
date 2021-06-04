package com.sawcunha.controlerelatorio.controller;

import com.sawcunha.controlerelatorio.model.dto.ConexaoServidorDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.security.RolesAllowed;

@CrossOrigin
@RestController
@RequestMapping("/conexao_servidor")
public class ConexaoServidorController {


    @GetMapping("/{id}")
    private ResponseEntity<ConexaoServidorDTO> getConexaoByID(@PathVariable Long id, @RequestAttribute("AAA") String aaa){
        System.out.println(aaa);
        System.out.println(id);
        return ResponseEntity.ok(new ConexaoServidorDTO());
    }



}
