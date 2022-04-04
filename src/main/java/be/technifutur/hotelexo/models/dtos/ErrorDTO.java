package be.technifutur.hotelexo.models.dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
//@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
@Builder
public class ErrorDTO {

    private final String message;
    private final int status;
    private final String uri;
    private final Map<String, Object> infos = new HashMap<>();

    public ErrorDTO(String message, String uri) {
        this.message = message;
        this.status = 400;
        this.uri = uri;
    }

//    public ErrorDTO(String message, int status, String uri) {
//        this.message = message;
//        this.status = status;
//        this.uri = uri;
//    }

    public ErrorDTO(String message, int status, String uri, Map<String, Object> infos) {
        this.message = message;
        this.status = status;
        this.uri = uri;
        this.infos.putAll(infos);
    }
}
