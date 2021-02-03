package desafio.alfrest.api.controller.exceptions;

import java.io.Serializable;
import java.time.Instant;
import java.util.List;

// Armazena os dados do erro quando uma exception é lançada.
public class StandardError implements Serializable {

    /* Exemplo:
    {
        "timestamp": "2021-02-01T04:48:03.239+00:00",
        "status": 404,
        "path": "/api/alunos",
        "message": "",
        "errors": [
            "Not Found"
        ]
    }
    */

    private Instant timestamp;
    private Integer status;
    private String path;
    private String message;
    private List<String> errors;


    public StandardError() {}

    public Instant getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Instant timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<String> getErrors() {
        return errors;
    }

    public void setErrors(List<String> error) {
        this.errors = error;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

}
