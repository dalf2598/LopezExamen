package ec.edu.espe.lopezexamen.utils;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

@Data
@Builder
public class RSFormat implements Serializable {
    private String message;
    private Object data;
}
