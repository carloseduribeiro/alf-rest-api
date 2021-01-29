package desafio.alfrest.api.controller.repository;

import desafio.alfrest.api.model.Prova;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvaRepository extends JpaRepository<Prova, Integer> {
}
