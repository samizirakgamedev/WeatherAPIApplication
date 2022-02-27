package com.steelswans.framework;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class APIKeyFileReaderTest {
    private static String filePath;
    private static APIKeyFileReader APIKFR;
    private static String APIK;

    @Test
    @DisplayName("Given a filePath that is null, the programme reads the file " +
            "as a 'NullPointerException'and returns null")
    void readAPIKeyFileNullCheck() {
        filePath = null;
        APIKFR = new APIKeyFileReader();
        APIK = APIKeyFileReader.readAPIKeyFile(Objects.toString(filePath));
        String expected = null;
        Assertions.assertEquals(expected, APIK);
    }
}