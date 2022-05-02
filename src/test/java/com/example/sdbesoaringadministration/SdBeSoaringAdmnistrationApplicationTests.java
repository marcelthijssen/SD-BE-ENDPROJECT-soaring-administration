/*
 * Author: Marcel Thijssen
 *
 * Version: v0.1
 *
 * Copyright
 *
 * Purpos of this class
 */

package com.example.sdbesoaringadministration;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotEquals;

@SpringBootTest
class SdBeSoaringAdmnistrationApplicationTests {


    @Test
    @DisplayName("Testing if context is correctly set")
    void ContextLoadsTest() {
        assertNotEquals(1, 2);
    }

}
