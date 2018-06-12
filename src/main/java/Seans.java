import lombok.Data;

import java.io.Serializable;

@Data
public class Seans implements Serializable {
    protected Film film;
    protected Sala sala;
    protected String data;
    protected String godzina;
}

