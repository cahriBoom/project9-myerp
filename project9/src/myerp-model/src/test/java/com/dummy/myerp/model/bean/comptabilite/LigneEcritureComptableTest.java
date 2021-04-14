package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Assert;
import org.junit.Test;

import java.math.BigDecimal;

public class LigneEcritureComptableTest {

    @Test
    public void testConstructorWithParam(){
        //Arrange
        CompteComptable compte = new CompteComptable(1, "AC");
        String libelle = "libelle";
        int debit = 50;
        int credit = 30;
        BigDecimal expectedDebit = BigDecimal.valueOf(debit).setScale(2,BigDecimal.ROUND_CEILING);
        BigDecimal expectedCredit = BigDecimal.valueOf(credit).setScale(2,BigDecimal.ROUND_CEILING);

        //Act
        LigneEcritureComptable ligne = new LigneEcritureComptable(compte,libelle, expectedDebit, expectedCredit);

        //Assert
        Assert.assertEquals(compte, ligne.getCompteComptable());
        Assert.assertEquals(libelle, ligne.getLibelle());
        Assert.assertEquals(expectedDebit, ligne.getDebit());
        Assert.assertEquals(expectedCredit, ligne.getCredit());
        Assert.assertEquals("LigneEcritureComptable{compteComptable=CompteComptable{numero=1, libelle='AC'}, libelle='libelle', debit=50.00, credit=30.00}",ligne.toString());


    }
}
