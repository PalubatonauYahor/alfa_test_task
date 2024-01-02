package alfa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum Timeout {

    GET_TEXT_TIMEOUT("default.element.get.text.seconds");

    private final String timeout;
}
