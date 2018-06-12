import lombok.AllArgsConstructor;
import lombok.Data;

import java.io.Serializable;

@Data
@AllArgsConstructor
public class Film implements Serializable {
    protected String name;
    protected String description;
    protected Double dur;
    protected Double limitAge;
}


