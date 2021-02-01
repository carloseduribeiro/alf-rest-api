package desafio.alfrest.api.services.exceptions;

public class EntityNotFoundException extends RuntimeException{

    // Contrutor recebe a mensagem de vai retornar.
    public EntityNotFoundException(String msg) {
        super(msg);
    }

}
