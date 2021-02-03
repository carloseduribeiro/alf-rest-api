package desafio.alfrest.api.services;

import desafio.alfrest.api.repository.AlunoRepository;
import desafio.alfrest.api.services.exceptions.EntityNotFoundException;
import desafio.alfrest.api.model.Aluno;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

    @Autowired
    private AlunoRepository alunoRepository;

    // consulta um aluno pelo id:
    public Aluno findById(Integer id){
        return alunoRepository.findById(id)
                // Caso o id não exista dispara a exception personalisada:
                .orElseThrow(() -> new EntityNotFoundException("Aluno não cadastrado. ID: " + id));
    }

    // cadastra um novo aluno:
    public Aluno save(Aluno aluno) {
        aluno.setId(null);
        return this.alunoRepository.save(aluno);
    }

    // consulta todos os alunos no banco e retorna em uma lista:
    public List<Aluno> findAll() {
        return this.alunoRepository.findAll();
    }
}
