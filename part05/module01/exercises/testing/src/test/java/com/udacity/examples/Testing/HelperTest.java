package com.udacity.examples.Testing;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertArrayEquals;

public class HelperTest {

    @Test
    public void test() {
        assertEquals(3, 3);
    }

    @Test
    public void test_getCount() {
        List<String> empNames = Arrays.asList("luan", "mateus");
        final long actual = Helper.getCount(empNames);

        assertEquals(2, actual);
    }

    @Test
    public void test_getStats() {
        List<Integer> yrsOfExperience = Arrays.asList(13, 4, 15, 6, 17, 8, 19, 1, 2, 3);
        List<Integer> expectedList = Arrays.asList(13, 4, 15, 6, 17, 8, 19, 1, 2, 3);
        final IntSummaryStatistics stats = Helper.getStats(yrsOfExperience);

        assertEquals(19, stats.getMax());
        assertEquals(expectedList, yrsOfExperience);
    }

    @Test
    public void test_compareArrays() {
        int[] yrs = {10, 14, 2};
        int[] expectedYrs = {10, 14, 2};

        assertArrayEquals(expectedYrs, yrs);
    }


    @Test
    public void test1() {
        assertEquals("test", "test");
    }

    /**
     * Need to be void and public
     *
     * @return
     * @Test private String test2() {
     * return "";
     * }
     */

    @Test
    public void validate_getCount() {
        List<String> empNames = Arrays.asList("sareeta", "", "john", "");
        assertEquals(2, Helper.getCount(empNames));
    }

    @Test
    public void validate_3lengthString() {
        List<String> empNames = Arrays.asList("sareeta", "", "Jeff", "sam");
        assertEquals(2, Helper.getStringsOfLength3(empNames));
    }

    /*
     * Part 2
     * why not to use test in the name?
     * Because annotations s
     */

    @Test
    public void verify_list_is_squared() {
        List<Integer> yrsOfExperience = Arrays.asList(13, 4, 15, 6, 17, 8, 19, 1, 2, 3);
        List<Integer> expected = Arrays.asList(169, 16, 225, 36, 289, 64, 361, 1, 4, 9);
        assertEquals(expected, Helper.getSquareList(yrsOfExperience));
    }


    /**
     * assertFail vs asserTrue
     */


    @Before
    public void init() {
        System.out.println("init executed");

    }

    @After
    public void teardown() {
        System.out.println("teardown executed");
    }

    @Test
    public void verify_merged_list() {
        List<String> empNames = Arrays.asList("sareeta", "", "john", "");
        assertEquals("sareeta, john", Helper.getMergedList(empNames));
    }

    @Test
    public void verify_getMax() {
        List<Integer> empLevel = Arrays.asList(3, 3, 3, 5, 7, 2, 2, 5, 7, 5);
        assertEquals(7, Helper.getStats(empLevel).getMax());
    }

    /**
     * this should be public static
     */

    @BeforeClass
    public static void initClass() {
        System.out.println("init Class executed");

    }


    @AfterClass
    public static void teardownclass() {
        System.out.println("teardown Class executed");
    }


    /**
     * assertArrayEquals
     * How should you debug this?
     */

    @Test
    public void verify_ArrayListTest() {
        int[] yrsOfExperience = {13, 4, 15, 6, 17, 8, 19, 1, 2, 3};
        int[] expected = {13, 4, 15, 6, 17, 8, 19, 1, 2, 3};
        assertArrayEquals(expected, yrsOfExperience);
    }

/**
 * parameterized test next class
 */
}
