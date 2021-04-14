package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Assert;
import org.junit.Test;

public class SequenceEcritureComptableTest {

    @Test
    public void testSequenceEcritureComptable() {
        //Arrange
        SequenceEcritureComptable sec = new SequenceEcritureComptable("",2021, 8);
        SequenceEcritureComptable sec_without_param = new SequenceEcritureComptable();

        //Act
        sec.setCodeJournal("AC");
        sec.setAnnee(2022);
        sec.setDerniereValeur(1);
        String code = sec.getCodeJournal();
        int annee = sec.getAnnee();
        int last = sec.getDerniereValeur();

        String toString = sec.toString();

        //Assert
        Assert.assertEquals("AC", code);
        Assert.assertEquals(2022, annee);
        Assert.assertEquals(1, last);
        Assert.assertEquals("SequenceEcritureComptable{annee=2022, derniereValeur=1}",toString);
    }


}
