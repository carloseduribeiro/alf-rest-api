package desafio.alfrest.api.controller.repository;

import desafio.alfrest.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {

    // Retorna todas as respostas de uma prova pelo id:
    @Query(value = "SELECT * FROM aluno a WHERE a.situacao = true ORDER BY ID", nativeQuery = true)
    List<Aluno> findAlunosAprovados();
}
