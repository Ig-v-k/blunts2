package com.iw;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AppTest {
    @Test
    public void testApp() {
        final String helloWorld = "Hello World";
        assertThat("Hello World").isEqualTo(helloWorld);
    }
}
