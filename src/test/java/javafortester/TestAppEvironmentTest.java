package javafortester;
import org.practices.javaForTester.TestAppEnv;
import org.testng.annotations.Test;
import org.testng.Assert;

import org.practices.javaForTester.TestAppEnv;

public class TestAppEvironmentTest {
    @Test
    public void canGetUrlStaticcally(){
        Assert.assertEquals("http://192.123.0.3:67", TestAppEnv.getUrl());
        Assert.assertEquals("192.123.0.3", TestAppEnv.DOMAIN);
        Assert.assertEquals("67",TestAppEnv.PORT);
    }
}
