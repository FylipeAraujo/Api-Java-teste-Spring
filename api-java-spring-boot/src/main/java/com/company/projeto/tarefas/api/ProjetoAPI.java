package com.company.projeto.tarefas.api;

import com.company.projeto.tarefas.dto.ProjetoDTO;
import com.company.projeto.tarefas.service.ProjetoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping(value = "/projetos",produces = MediaType.APPLICATION_JSON_VALUE)
public class ProjetoAPI {

    @Autowired
    private ProjetoService projetoService;
    
    @PostMapping
    @ResponseBody
    public ProjetoDTO criar(@RequestBody ProjetoDTO projetoDTO){
        return projetoService.criar(projetoDTO);
    }
    
    @PutMapping("/{projetoId}")
    @ResponseBody
    public ProjetoDTO atualizar(@PathVariable("projetoId")Long projetoId, @RequestBody ProjetoDTO projetoDTO){
        return projetoService.atualizar(projetoDTO,projetoId);
    }
    
    @GetMapping
    @ResponseBody
    public List<ProjetoDTO>getAll(){
        return projetoService.recuperarTodos();
    }
    
    @DeleteMapping("/{projetoId}")
    @ResponseBody
    public String deletar(@PathVariable("projetoId")Long projetoId){
        return projetoService.delete(projetoId);
    }
    
}
