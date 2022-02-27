package com.steelswans.framework;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.Objects;

class APIKeyFileReaderTest {
    private static String filePath;
    private static String APIK;

    @Test
    @DisplayName("Given a filePath that is null, the programme reads the file " +
            "as a 'NullPointerException'and returns null")
    void readAPIKeyFileNullCheck() {
        filePath = null;
        APIK = APIKeyFileReader.readAPIKeyFile(Objects.toString(filePath));
        String expected = null;
        Assertions.assertEquals(expected, APIK);
    }
}