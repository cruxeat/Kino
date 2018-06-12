import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

//@Data
@Getter
@Setter
public class Sala implements Serializable {
    protected String number;
    protected Double size;
    protected String type;

    public String toString(){
        return number;
    }
}
