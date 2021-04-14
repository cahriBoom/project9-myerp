package com.dummy.myerp.technical.util.spring;

import org.junit.Assert;
import org.junit.Test;

public class NullFactoryBeanT {

    @Test
    public void getInstanceNull(){
        //Arrange
        class NullBeanTest {}

        //Act
        NullFactoryBean<NullBeanTest> nullBeanTest = new NullFactoryBean<>(NullBeanTest.class);

        //Assert
        try {
            Assert.assertNull(nullBeanTest.getObject());
            Assert.assertNotNull(nullBeanTest.getObjectType());
            Assert.assertFalse(nullBeanTest.isSingleton());
        } catch (Exception e) {
            Assert.fail();
        }
    }
}
