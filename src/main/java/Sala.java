import lombok.Data;

import java.io.Serializable;

@Data
public class Sala implements Serializable {
    protected String number;
    protected Double size;
    protected String type;
}
