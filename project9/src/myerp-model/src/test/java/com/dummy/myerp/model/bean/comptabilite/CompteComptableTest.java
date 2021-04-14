package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class CompteComptableTest {

    @Test
    public void testConstructorCompteComptable(){
        //Arrange
        Integer numero = 1;
        String libelle = "libelle";

        //Act
        CompteComptable compte = new CompteComptable(numero, libelle);

        //Assert
        Assert.assertEquals(numero, compte.getNumero());
        Assert.assertEquals(libelle, compte.getLibelle());
        Assert.assertEquals("CompteComptable{numero=1, libelle='libelle'}", compte.toString());

    }

    @Test
    public void testGetByNumeroInListContainTheExpectedCompte(){
        //Arrange
        List<CompteComptable> liste = new ArrayList<>();
        for(int i=0; i<4;i++){
            liste.add(new CompteComptable(i, "Compte: " +i));
        }
        Integer expectedNumber = 3;

        //Act
        CompteComptable compte = CompteComptable.getByNumero(liste, expectedNumber);

        //Assert
        Assert.assertEquals("Compte: 3",compte.getLibelle());

    }

    @Test
    public void testGetByNumeroInListNotContainExpectedCompte(){
        //Arrange
        List<CompteComptable> liste = new ArrayList<>();
        for(int i=0; i<4;i++){
            liste.add(new CompteComptable(i, "Compte: " +i));
        }
        Integer expectedNumber = 10;

        //Act
        CompteComptable compte = CompteComptable.getByNumero(liste, expectedNumber);

        //Assert
        Assert.assertNull(compte);
    }
}
