package ec.edu.espe.lopezexamen.utils;

public enum RSCode {
    CREATED(201),
    SUCCESS(200),
    BAD_REQUEST(400),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    public final int code;
    RSCode(int code) {
        this.code = code;
    }
}
