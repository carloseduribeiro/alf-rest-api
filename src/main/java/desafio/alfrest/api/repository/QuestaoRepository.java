package desafio.alfrest.api.repository;

import desafio.alfrest.api.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface QuestaoRepository extends JpaRepository<Questao, Integer> {
}
