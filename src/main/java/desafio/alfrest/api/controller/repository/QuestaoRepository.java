package desafio.alfrest.api.controller.repository;

import desafio.alfrest.api.model.Questao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestaoRepository extends JpaRepository<Questao, Integer> {

    // Retorna todas as respostas cadastradas
    @Query(value = "SELECT * FROM questao q WHERE q.gabarito = false ORDER BY ID", nativeQuery = true)
    List<Questao> findQuestoes();

    // Retorna todos os gabaritos cadastrados:
    @Query(value = "SELECT * FROM questao q WHERE q.gabarito = true ORDER BY ID", nativeQuery = true)
    List<Questao> findGabaritos();

    // Retorna todas as respostas de uma prova pelo id:
    @Query(value = "SELECT * FROM questao q WHERE q.id_prova = :idprova AND q.gabarito = false", nativeQuery = true)
    List<Questao> findByIdProva(@Param("idprova") Integer id);

    // Retorna o gabarito de uma prova pelo id
    @Query(value = "SELECT * FROM questao q WHERE q.id_prova = :idprova AND q.gabarito = true", nativeQuery = true)
    List<Questao> findGabaritoByIdProva(@Param("idprova") Integer id);

}
