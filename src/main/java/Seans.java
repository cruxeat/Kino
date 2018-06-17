import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Data
@Getter
@Setter

public class Seans implements Serializable {
    protected Film nameFilm;
    protected Sala numberSala;
    protected LocalDate data;
    protected String godzina;
}

