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

    // Retorna uma lista com as respostas da prova do aluno:
    @Query(value = "SELECT alternativa FROM questao q WHERE q.id = :idprova AND q.gabarito = false ORDER BY ID", nativeQuery = true)
    List<String> findRespostasByIdProva(@Param("idprova") Integer id);

    // Retorna uma lista com as respostas do gabarito da prova:
    @Query(value = "SELECT alternativa FROM questao q WHERE q.id = :idprova AND q.gabarito = true ORDER BY ID", nativeQuery = true)
    List<String> findGabaritoByIdProva(@Param("idprova") Integer id);

    // Retorna uma lista com o peso de cada questao:
    @Query(value = "SELECT peso FROM questao q WHERE q.id = :idprova AND q.gabarito = true", nativeQuery = true)
    List<Float> findQuestaoPesoByIdProva(@Param("idprova") Integer id);


}
