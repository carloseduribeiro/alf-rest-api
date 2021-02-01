package desafio.alfrest.api.controller.exceptions;

import java.io.Serializable;
import java.time.Instant;

// Armazena os dados do erro quando uma exception é lançada.
public class StandardError implements Serializable {

    /* Exemplo:
    {
        "timestamp": "2021-02-01T04:48:03.239+00:00",
        "status": 404,
        "error": "Not Found",
        "message": "",
        "path": "/api/alunos"
    }
    */

    private Instant timestamp;
    private Integer status;
    private String error;
    private String message;
    private String path;

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

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
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
