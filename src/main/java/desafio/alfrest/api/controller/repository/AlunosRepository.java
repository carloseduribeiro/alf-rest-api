package desafio.alfrest.api.controller.repository;

import desafio.alfrest.api.model.Aluno;
import org.springframework.data.repository.CrudRepository;

public interface AlunosRepository extends CrudRepository<Aluno, Integer> {
}
