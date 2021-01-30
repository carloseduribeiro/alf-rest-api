package desafio.alfrest.api.controller.repository;

import desafio.alfrest.api.model.Prova;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ProvaRepository extends JpaRepository<Prova, Integer> {

    // Retorna todas as respostas de uma prova pelo id:
    @Query(value = "SELECT * FROM prova a WHERE a.id_aluno = :idaluno", nativeQuery = true)
    List<Prova> findProvaByIdAluno(@Param("idaluno") Integer id);

}
