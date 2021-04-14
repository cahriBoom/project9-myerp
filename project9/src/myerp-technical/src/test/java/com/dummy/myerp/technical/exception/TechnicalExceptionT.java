package com.dummy.myerp.technical.exception;

import org.junit.Assert;
import org.junit.Test;

public class TechnicalExceptionT {

    @Test
    public void contructTechnicalExceptionWithString() {
        //Arrange
        String errorMessage = "String Error Message";

        //Act
        TechnicalException exception = new TechnicalException(errorMessage);

        //Assert
        Assert.assertNull(exception.getCause());
        Assert.assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void contructTechnicalExceptionWithThrow() {
        //Arrange
        String thrownMessage = "Throwable Error Message";
        Throwable throwable = new Throwable(thrownMessage);

        //Act
        TechnicalException exception = new TechnicalException(throwable);

        //Assert
        Assert.assertNotNull(exception.getCause());
        Assert.assertEquals(throwable, exception.getCause());
        Assert.assertEquals(thrownMessage, exception.getCause().getMessage());
    }

    @Test
    public void contructTechnicalExceptionWithStringAndThrowable() {
        //Arrange
        String errorMessage = "String Error Message";
        String thrownMessage = "Throwable Error Message";
        Throwable throwable = new Throwable(thrownMessage);

        //Act
        TechnicalException exception = new TechnicalException(errorMessage, throwable);

        //Assert
        Assert.assertEquals(errorMessage, exception.getMessage());
        Assert.assertNotNull(exception.getCause());
        Assert.assertEquals(throwable, exception.getCause());
        Assert.assertEquals(thrownMessage, exception.getCause().getMessage());
    }
}
