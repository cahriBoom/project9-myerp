package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class JournalComptableTest {

    @Test
    public void testJournalComptable() {
        //Arrange
        JournalComptable jc = new JournalComptable("libelle", "code");
        List<JournalComptable> list = new ArrayList<JournalComptable>();


        //Act
        list.add(jc);
        JournalComptable jc2 = JournalComptable.getByCode(list, "test");
        jc.setLibelle("test");
        jc.setCode("test");
        String libelle = jc.getLibelle();
        String code = jc.getCode();
        String toString = jc.toString();

        //Assert
        Assert.assertEquals("test", libelle);
        Assert.assertEquals("test", code);

    }
}
