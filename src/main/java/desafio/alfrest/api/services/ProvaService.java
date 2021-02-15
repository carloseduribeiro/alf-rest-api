package desafio.alfrest.api.services;

import desafio.alfrest.api.model.Prova;
import desafio.alfrest.api.repository.ProvaRepository;
import desafio.alfrest.api.services.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProvaService {

    @Autowired
    private ProvaRepository provaRepository;

    // Consulta a prova pelo id:
    public Prova findById(Integer id) {
        return provaRepository.findById(id)
            // Caso o id não seja encontrado dispara uma a ecessão personalizada:
            .orElseThrow(() -> new EntityNotFoundException("Prova não cadastrada. ID: " + id));
    }
}
