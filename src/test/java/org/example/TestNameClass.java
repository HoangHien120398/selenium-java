package org.example;

import org.testng.Assert;
import org.testng.annotations.Test;
import static org.example.lesson01.Main.isvalidPassWord;

public class TestNameClass {
    @Test
    void checkValidPassword(){
        Assert.assertTrue(isvalidPassWord("Hienht12!"));
    }
    @Test
    void checkEmptyPassword(){
        Assert.assertFalse(isvalidPassWord(null));
    }
    @Test
    void checkLenght(){
        Assert.assertFalse(isvalidPassWord("Hien1@"));
    }
    @Test
    void checkMissingNumber(){
        Assert.assertFalse(isvalidPassWord("Hienht12@"));
    }
    @Test
    void checkMissingUpperCharacter(){
        Assert.assertFalse(isvalidPassWord("hienht@12"));
    }
    @Test
    void checkMissingLowerCharacter(){
        Assert.assertFalse(isvalidPassWord("HIENHT@123"));
    }
    @Test
    void checkMissingSpecialCharacter(){
        Assert.assertFalse(isvalidPassWord("Hienht0702"));
    }
}
