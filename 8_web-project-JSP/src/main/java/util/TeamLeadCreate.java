package util;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class TeamLeadCreate {

    private int teamLeadId;
    private String destinationUrl;
}
