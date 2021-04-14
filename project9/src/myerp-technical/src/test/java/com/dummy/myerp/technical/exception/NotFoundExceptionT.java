package com.dummy.myerp.technical.exception;

import org.junit.Assert;
import org.junit.Test;

public class NotFoundExceptionT {

    @Test
    public void contructNotFoundExceptionWithString() {
        //Arrange
        String errorMessage = "String Error Message";

        //Act
        NotFoundException exception = new NotFoundException(errorMessage);

        //Assert
        Assert.assertNull(exception.getCause());
        Assert.assertEquals(errorMessage, exception.getMessage());
    }

    @Test
    public void contructNotFoundExceptionWithThrow() {
        //Arrange
        String thrownMessage = "Throwable Error Message";
        Throwable throwable = new Throwable(thrownMessage);

        //Act
        NotFoundException exception = new NotFoundException(throwable);

        //Assert
        Assert.assertNotNull(exception.getCause());
        Assert.assertEquals(throwable, exception.getCause());
        Assert.assertEquals(thrownMessage, exception.getCause().getMessage());
    }

    @Test
    public void contructNotFoundExceptionWithStringAndThrowable() {
        //Arrange
        String errorMessage = "String Error Message";
        String thrownMessage = "Throwable Error Message";
        Throwable throwable = new Throwable(thrownMessage);

        //Act
        NotFoundException exception = new NotFoundException(errorMessage, throwable);

        //Assert
        Assert.assertEquals(errorMessage, exception.getMessage());
        Assert.assertNotNull(exception.getCause());
        Assert.assertEquals(throwable, exception.getCause());
        Assert.assertEquals(thrownMessage, exception.getCause().getMessage());
    }
}
