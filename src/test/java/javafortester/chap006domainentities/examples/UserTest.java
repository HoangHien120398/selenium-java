package javafortester.chap006domainentities.examples;

import org.practices.javaForTester.domainentities.User;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UserTest {
    @Test
    public void canConstructANewUser(){
        User user = new User();
    }
    @Test
    public void userHasDefaultUsernameAndPassword(){
        User user = new User();
        Assert.assertEquals("username",user.getUsername());
        Assert.assertEquals("password",user.getPassword());
    }

    @Test
    public void userHasChangeUsernameAnsPassword(){
        User h = new User();
        h.username ="hien";
        Assert.assertEquals("hien", h.username);
    }

    @Test
    public void canConstructorWithUsernameAndPassword(){
        User user = new User("admin", "admin123");
        Assert.assertEquals("admin", user.getUsername());
        Assert.assertEquals("admin123", user.getPassword());
    }
    @Test
    public void canSetPasswordAfterConstructed(){
        User user = new User();
        user.setPassword("hienht123");
        Assert.assertEquals("hienht123",user.getPassword());
    }
}
