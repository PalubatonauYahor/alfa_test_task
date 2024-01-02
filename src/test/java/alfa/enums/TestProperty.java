package alfa.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@ToString
public enum TestProperty {

    SAMSUNG("samsung.emulator"),
    DRIVER_SETTINGS_ANDROID("driver.settings.android"),
    LOG_PATH("log.path"),
    TEST_DATA_KEY("test.data.key"),
    TEST_DATA_PATH("test.data.path");

    private final String property;
}
