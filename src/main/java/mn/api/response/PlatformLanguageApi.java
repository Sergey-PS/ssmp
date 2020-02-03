package mn.api.response;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class PlatformLanguageApi extends AbstractResponse {

    private int id;
    private String title;
}
