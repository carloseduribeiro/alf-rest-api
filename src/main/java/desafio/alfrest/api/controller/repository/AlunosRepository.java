package desafio.alfrest.api.controller.repository;

import desafio.alfrest.api.model.Aluno;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlunosRepository extends JpaRepository<Aluno, Integer> {
}
