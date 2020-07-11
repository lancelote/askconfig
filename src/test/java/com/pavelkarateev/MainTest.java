package com.pavelkarateev;

import org.junit.jupiter.api.Test;

import static com.pavelkarateev.Main.trimPath;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class MainTest {

    @Test
    public void testTrimPath() {
        String expected = "PyCharm-P/ch-0/201.8538.36/PyCharm.app.vmoptions";
        String file = Main.APPS + "/" + expected;
        assertEquals(trimPath(file), expected);
    }
}
