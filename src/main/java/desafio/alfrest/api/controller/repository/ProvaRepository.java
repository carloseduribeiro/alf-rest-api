package desafio.alfrest.api.controller.repository;

import desafio.alfrest.api.model.Prova;
import org.springframework.data.repository.CrudRepository;

public interface ProvaRepository extends CrudRepository<Prova, Integer> {
}
