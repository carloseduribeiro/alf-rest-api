package desafio.alfrest.api.services;

import desafio.alfrest.api.repository.AlunoRepository;
import desafio.alfrest.api.services.exceptions.EntityNotFoundException;
import desafio.alfrest.api.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    // consulta um alunon pelo id:
    public Aluno findById(Integer id){
        return alunoRepository.findById(id)
                // Caso o id não exista dispara a exception personalisada:
                .orElseThrow(() -> new EntityNotFoundException("Id do aluno não encontrada: " + id));
    }

}
