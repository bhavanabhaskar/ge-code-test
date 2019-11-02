package com.ge.exercise2;

import org.junit.Assume;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayQuadrantUtilTest {

    @Test
    public void getQuadrantValuesForCharArrayTest() {
        Character[][] data = {
                {'a', 'b', 'c', 'd'},
                {'e', 'f', 'g', 'h'},
                {'i', 'j', 'k', 'l'},
                {'m', 'n', 'o', 'p'}
        };

        ArrayQuadrantUtil<Character> util = new ArrayQuadrantUtil<>(data);
        Assume.assumeNotNull(util.getQuadrantValues(0, 0, 4, 3));

        Character[] expectedResult = {'a', 'b', 'e', 'f'};
        Object[] quadrantValues = util.getQuadrantValues(0, 0, 4, 3);
        Character[] actualResult = new Character[quadrantValues.length];
        System.arraycopy(quadrantValues, 0, actualResult, 0, quadrantValues.length);
        assertArrayEquals(expectedResult, actualResult);
    }
    
    @Test
    public void getQuadrantValuesForIntArrayTest() {
        Integer[][] data = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
        };

        ArrayQuadrantUtil<Integer> util = new ArrayQuadrantUtil<>(data);
        Assume.assumeNotNull(util.getQuadrantValues(1, 1, 4, 1));

        Integer[] expectedResult = {6, 7, 8, 5};
        Object[] quadrantValues = util.getQuadrantValues(1, 1, 4, 1);
        Integer[] actualResult = new Integer[quadrantValues.length];
        System.arraycopy(quadrantValues, 0, actualResult, 0, quadrantValues.length);
        assertArrayEquals(expectedResult, actualResult);
    }
    
    @Test
    public void getQuadrantValuesForStringArrayTest() {
        String[][] data = {
                {"1", "2", "3", "4", "5", "6"},
                {"7", "8", "9", "10", "11", "12"},
                {"13", "14", "15", "16", "17", "18"},
                {"19", "20", "21", "22", "23", "24"},
                {"25", "26", "27", "28", "29", "30"},
                {"31", "32", "33", "34", "35", "36"}
        };

        ArrayQuadrantUtil<String> util = new ArrayQuadrantUtil<>(data);
        Assume.assumeNotNull(util.getQuadrantValues(3, 3, 6, 2));

        String[] expectedResult = {"22", "28", "34", "4", "10", "16"};
        Object[] quadrantValues = util.getQuadrantValues(3, 3, 6, 2);
        String[] actualResult = new String[quadrantValues.length];
        System.arraycopy(quadrantValues, 0, actualResult, 0, quadrantValues.length);
        assertArrayEquals(expectedResult, actualResult);
    }

}