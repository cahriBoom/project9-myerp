package com.dummy.myerp.model.bean.comptabilite;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
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
    
    @Test
    public void testSequenceEcritureComptable() {
    	//Arrange
    	SequenceEcritureComptable sec = new SequenceEcritureComptable(2021, 8);
    	
    	//Act
    	sec.setAnnee(2022);
    	sec.setDerniereValeur(1);
    	int annee = sec.getAnnee();
    	int last = sec.getDerniereValeur();
    	String toString = sec.toString();
    	
    	//Assert
    	Assert.assertEquals(2022, annee);
    	Assert.assertEquals(1, last);
    }
    
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
