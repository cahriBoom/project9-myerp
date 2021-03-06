package com.dummy.myerp.model.bean.comptabilite;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.commons.lang3.ObjectUtils;
import org.junit.Assert;
import org.junit.Test;


public class EcritureComptableTest {

    private LigneEcritureComptable createLigne(Integer pCompteComptableNumero, String pDebit, String pCredit) {
        BigDecimal vDebit = pDebit == null ? null : new BigDecimal(pDebit);
        BigDecimal vCredit = pCredit == null ? null : new BigDecimal(pCredit);
        String vLibelle = ObjectUtils.defaultIfNull(vDebit, BigDecimal.ZERO)
                                     .subtract(ObjectUtils.defaultIfNull(vCredit, BigDecimal.ZERO)).toPlainString();
        LigneEcritureComptable vRetour = new LigneEcritureComptable(new CompteComptable(pCompteComptableNumero),
                                                                    vLibelle,
                                                                    vDebit, vCredit);
        return vRetour;
    }

    @Test
    public void testEcritureComptable(){
        //Arrange
        JournalComptable journal = new JournalComptable("libelle", "code");
        EcritureComptable ecriture = new EcritureComptable(1,journal,"AC-2021/00001",new Date(),"Achat");
        EcritureComptable ecriture_without_param = new EcritureComptable();

        //Act
        ecriture_without_param.setId(2);
        ecriture_without_param.setJournal(journal);
        ecriture_without_param.setReference("AC-2021/00002");
        ecriture_without_param.setDate(new Date());
        ecriture_without_param.setLibelle("Achat");

        int id = ecriture.getId();
        String ref = ecriture.getReference();
        String libelle = ecriture.getLibelle();


        //Assert
        Assert.assertEquals(1, id);
        Assert.assertEquals("AC-2021/00001", ref);
        Assert.assertEquals("Achat", libelle);

    }
    
    @Test
    public void getTotalDebitTest() {
    	//Arrange
    	EcritureComptable vEcriture = new EcritureComptable();
    	vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.5", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.5", "33"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", "7"));     	
    	
    	//Act
    	BigDecimal debit = vEcriture.getTotalDebit();

    	//Assert
        assertEquals(BigDecimal.valueOf(341.0), debit);

    }
    
    @Test
    public void getTotalCreditTest() {
    	//Arrange
    	EcritureComptable vEcriture = new EcritureComptable();
    	vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", "33"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", "7"));     	
    	
    	//Act
    	BigDecimal credit = vEcriture.getTotalCredit();

    	//Assert
    	assertEquals(BigDecimal.valueOf(341), credit);
    	
    	
    }

    @Test
    public void isEquilibree() {
        EcritureComptable vEcriture = new EcritureComptable();

        vEcriture.setLibelle("Equilibrée");
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "200.50", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "100.50", "33"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "301"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, "40", "7"));
        Assert.assertTrue(vEcriture.toString(), vEcriture.isEquilibree());

        vEcriture.getListLigneEcriture().clear();
        vEcriture.setLibelle("Non équilibrée");
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "10", null));
        vEcriture.getListLigneEcriture().add(this.createLigne(1, "20", "1"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, null, "30"));
        vEcriture.getListLigneEcriture().add(this.createLigne(2, "1", "2"));
        Assert.assertFalse(vEcriture.toString(), vEcriture.isEquilibree());
    }

    


}
