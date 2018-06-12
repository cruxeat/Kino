import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

//@Data
@Getter
@Setter
@AllArgsConstructor
public class Film implements Serializable {
    protected String name;
    protected String description;
    protected Double dur;
    protected Double limitAge;

    public String toString(){
        return name;
    }
}


