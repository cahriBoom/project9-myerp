package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CompteComptableTest {

    @Test
    public void testCompteComptable() {
        //Arrange
        CompteComptable cc = new CompteComptable(1, "libelle");
        List<CompteComptable> list = new ArrayList<CompteComptable>();


        //Act
        list.add(cc);
        CompteComptable cc2 = CompteComptable.getByNumero(list, 7);
        cc.setLibelle("test");
        cc.setNumero(7);
        String libelle = cc.getLibelle();
        int numero = cc.getNumero();

        //Assert
        Assert.assertEquals("test", libelle);
        Assert.assertEquals(7, numero);
    }
}
