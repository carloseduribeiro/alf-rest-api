package desafio.alfrest.api.repository;

import desafio.alfrest.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunoRepository extends JpaRepository<Aluno, Integer> {
}
