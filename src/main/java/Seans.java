import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Data
@Getter
@Setter

public class Seans implements Serializable {
    protected Film nameFilm;
    protected Sala numberSala;
    protected String data;
    protected String godzina;
}

