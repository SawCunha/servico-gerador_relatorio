package com.sawcunha.controlerelatorio.controller;

import com.sawcunha.controlerelatorio.model.dto.ConexaoServidorDTO;
import com.sawcunha.controlerelatorio.security.permission.AdminPermission;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("${server.api_name}/conexao_servidor")
public class ConexaoServidorController {

    @AdminPermission
    @GetMapping("/{id}")
    public ResponseEntity<ConexaoServidorDTO> getConexaoByID(@PathVariable Long id){
        System.out.println(id);
        return ResponseEntity.ok(new ConexaoServidorDTO());
    }
}
