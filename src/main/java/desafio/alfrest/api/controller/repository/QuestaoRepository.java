package desafio.alfrest.api.controller.repository;

import desafio.alfrest.api.model.Questao;
import org.springframework.data.repository.CrudRepository;

public interface QuestaoRepository extends CrudRepository<Questao, Integer> {
}
