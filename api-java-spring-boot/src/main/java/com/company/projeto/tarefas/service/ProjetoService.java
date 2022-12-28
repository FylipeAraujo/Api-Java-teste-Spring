package com.company.projeto.tarefas.service;

import com.company.projeto.tarefas.dto.ProjetoDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ProjetoService {
    private static final Map<Long, ProjetoDTO> projetos=new HashMap<>();

    public ProjetoDTO criar(ProjetoDTO projetoDTO){
        long proximoId =projetos.keySet().size()+1;
        projetoDTO.setId(proximoId);
        projetos.put(proximoId,projetoDTO);
        return projetoDTO;
    }
    public ProjetoDTO atualizar(ProjetoDTO projetoDTO, Long projetoId){
        projetos.put(projetoId,projetoDTO);
        return projetoDTO;

    }
    public ProjetoDTO recuperarId(Long projetoId){
        return projetos.get(projetoId);
    }
    public List<ProjetoDTO> recuperarTodos(){
        return new ArrayList<>(projetos.values());

    }
    public String delete(Long projetoId){
        projetos.remove(projetoId);
        return "DELETED";
    }

}
