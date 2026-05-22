package com.calorie.tracker.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class WaterControllerTest {

    @InjectMocks
    private WaterController unitUnderTest;

    @Test
    public void contextLoads() {
        assertNotNull(unitUnderTest);
    }
}
