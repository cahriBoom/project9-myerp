package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CompteComptableTest {

    @Test
    public void testCompteComptable() {
        //Arrange
        CompteComptable compte = new CompteComptable(1, "libelle");
        CompteComptable com_without_param = new CompteComptable();
        List<CompteComptable> list = new ArrayList<CompteComptable>();
        list.add(compte);

        //Act
        com_without_param.setLibelle("test");
        com_without_param.setNumero(2);
        list.add(com_without_param);
        String libelle = compte.getLibelle();
        int numero = compte.getNumero();
        String toString = compte.toString();

        CompteComptable returned = CompteComptable.getByNumero(list, 1);


        //Assert
        Assert.assertEquals("libelle", libelle);
        Assert.assertEquals(1, numero);
        Assert.assertEquals("CompteComptable{numero=1, libelle='libelle'}",toString);


    }
}
