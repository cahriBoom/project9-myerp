package com.dummy.myerp.technical.exception;

import org.junit.Assert;
import org.junit.Test;

public class FunctionalExceptionT {

    @Test
    public void contructFunctionalExceptionWithString() {
        //Arrange
        String errorMessage = "String Error Message";

        //Act
        FunctionalException exception = new FunctionalException(errorMessage);

        //Assert
        Assert.assertNull(exception.getCause());
        Assert.assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void contructFunctionalExceptionWithThrow() {
        //Arrange
        String thrownMessage = "Throwable Error Message";
        Throwable throwable = new Throwable(thrownMessage);

        //Act
        FunctionalException exception = new FunctionalException(throwable);

        //Assert
        Assert.assertNotNull(exception.getCause());
        Assert.assertEquals(throwable, exception.getCause());
        Assert.assertEquals(thrownMessage, exception.getCause().getMessage());
    }

    @Test
    public void contructFunctionalExceptionWithStringAndThrowable() {
        //Arrange
        String errorMessage = "String Error Message";
        String thrownMessage = "Throwable Error Message";
        Throwable throwable = new Throwable(thrownMessage);

        //Act
        FunctionalException exception = new FunctionalException(errorMessage, throwable);

        //Assert
        Assert.assertEquals(errorMessage, exception.getMessage());
        Assert.assertNotNull(exception.getCause());
        Assert.assertEquals(throwable, exception.getCause());
        Assert.assertEquals(thrownMessage, exception.getCause().getMessage());
    }
}
