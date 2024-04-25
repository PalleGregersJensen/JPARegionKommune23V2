package com.example.jparegionkommune23v2.repository;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class MockTest {

    //Blot for at vise konceptet. virker ikke. kan ikke noget.
    @Test
    void testInlineMap() {
        Map<Integer, String> mapMock = mock(Map.class);
        mapMock.put(1085, "Roskilde");
        String str = mapMock.get(1085);
        assertEquals("Roskilde", str);
    }


    @Test
    void testInlineMapWhen() {
        Map<Integer, String> mapMock = mock(Map.class);
        when(mapMock.get(1085)).thenReturn("Roskilde");
        String string = mapMock.get(1085);
        assertEquals("Roskilde", string);
    }
}
