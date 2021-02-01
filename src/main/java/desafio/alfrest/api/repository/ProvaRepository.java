package desafio.alfrest.api.repository;

import desafio.alfrest.api.model.Prova;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProvaRepository extends JpaRepository<Prova, Integer> {
}
