package javafortester;

import org.testng.Assert;
import org.testng.annotations.Test;

public class javaForTester {
    @Test
    public void canAddTwoPlusTwo(){
        int answer = 2 + 2;
        Assert.assertEquals(answer,4);
    }
    @Test
    public void canFourDiviceTwo(){
        int answer = 4/2;
        Assert.assertEquals(answer,2);
    }
    @Test
    public void canTwoMultiplyTwo(){
        int answer = 2 * 2;
        Assert.assertEquals(answer,4);
    }
    @Test
    public void canTwoSubtractTwo(){
        int answer = 2 - 2;
        Assert.assertEquals(answer,0);
    }
    @Test
    public void intValue(){
        Integer four = 4;
        Assert.assertEquals(four.intValue(),4);
    }
    @Test
    public void convertToHex(){
        Assert.assertEquals("b", Integer.toHexString(11));
        Assert.assertEquals("a",Integer.toHexString(10));
        Assert.assertEquals("3",Integer.toHexString(3));
        Assert.assertEquals("15",Integer.toHexString(21));
    }
    @Test
    public void compareMaxMinInt(){
        Assert.assertEquals(2147483647,Integer.MAX_VALUE);
        Assert.assertEquals(-2147483648,Integer.MIN_VALUE);
    }

    @Test
    public void returnNumberofCat(){
        Assert.assertEquals("cats", catOrCats(2));
    }
    public String catOrCats(int numberOfCat){
        String cat = "cat";
        String cats = "cats";
        return numberOfCat == 1 ? cat : cats;
    }

    @Test
    public void simpleArrayexample(){
        String[] numbers0123 = {"zero", "one", "two", "three"};

        for (String numberText : numbers0123){
            System.out.println(numberText);
        }
        Assert.assertEquals("zero",numbers0123[0]);
        Assert.assertEquals("three", numbers0123[3]);
    }

}
