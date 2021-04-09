package com.dummy.myerp.business.impl.manager;

import java.math.BigDecimal;
import java.util.Date;


import com.dummy.myerp.model.bean.comptabilite.*;
import org.junit.Test;

import com.dummy.myerp.technical.exception.FunctionalException;

public class ComptabiliteManagerImplTest {

	private ComptabiliteManagerImpl manager = new ComptabiliteManagerImpl();

	@Test
	public void checkEcritureComptableUnit() throws Exception {
		//Arrange
		EcritureComptable vEcritureComptable = new EcritureComptable();
		SequenceEcritureComptable sequence = new SequenceEcritureComptable(2021,1);
		JournalComptable journal = new JournalComptable("AC", "Achat");
		journal.setSequence(sequence);
		vEcritureComptable.setJournal(journal);
		vEcritureComptable.setDate(new Date());
		vEcritureComptable.setReference("AC-2021/00001");
		vEcritureComptable.setLibelle("Libelle");

		// Create ligneEcritureComptable
		LigneEcritureComptable ligne1 = new LigneEcritureComptable(new CompteComptable(1), "", new BigDecimal(123), null);
		LigneEcritureComptable ligne2 = new LigneEcritureComptable(new CompteComptable(1), "", null , new BigDecimal(123));
		vEcritureComptable.setListLigneEcriture(ligne1);
		vEcritureComptable.setListLigneEcriture(ligne2);

		//Act
		manager.checkEcritureComptableUnit(vEcritureComptable);

	}

	@Test(expected = FunctionalException.class)
	public void checkEcritureComptableUnitViolation() throws Exception {
		EcritureComptable vEcritureComptable = new EcritureComptable();
		manager.checkEcritureComptableUnit(vEcritureComptable);
	}

	@Test(expected = FunctionalException.class)
	public void checkEcritureComptableUnitRG2Violation() throws Exception {
		//Arrange
		EcritureComptable vEcritureComptable = new EcritureComptable();
		SequenceEcritureComptable sequence = new SequenceEcritureComptable(2021,1);
		JournalComptable journal = new JournalComptable("AC", "Achat");
		journal.setSequence(sequence);
		vEcritureComptable.setJournal(journal);
		vEcritureComptable.setDate(new Date());
		vEcritureComptable.setReference("AC-2021/00001");
		vEcritureComptable.setLibelle("Libelle");

		// Create ligneEcritureComptable
		LigneEcritureComptable ligne1 = new LigneEcritureComptable(new CompteComptable(1), "AC", new BigDecimal(123), null);
		LigneEcritureComptable ligne2 = new LigneEcritureComptable(new CompteComptable(2), "AC", null, new BigDecimal(1234));
		vEcritureComptable.setListLigneEcriture(ligne1);
		vEcritureComptable.setListLigneEcriture(ligne2);


		//Act
		manager.checkEcritureComptableUnit(vEcritureComptable);
	}


	@Test(expected = FunctionalException.class)
	public void checkEcritureComptableUnitRG3Violation() throws Exception {

		//Arrange
		EcritureComptable vEcritureComptable = new EcritureComptable();
		SequenceEcritureComptable sequence = new SequenceEcritureComptable(2021,1);
		JournalComptable journal = new JournalComptable("AC", "Achat");
		journal.setSequence(sequence);
		vEcritureComptable.setJournal(journal);
		vEcritureComptable.setDate(new Date());
		vEcritureComptable.setReference("AC-2021/00001");
		vEcritureComptable.setLibelle("Libelle");

		// Create ligneEcritureComptable
		LigneEcritureComptable ligne1 = new LigneEcritureComptable(new CompteComptable(1), null, new BigDecimal(123), null);
		LigneEcritureComptable ligne2 = new LigneEcritureComptable(new CompteComptable(1), null, new BigDecimal(123), null);
		vEcritureComptable.setListLigneEcriture(ligne1);
		vEcritureComptable.setListLigneEcriture(ligne2);

		//Act
		manager.checkEcritureComptableUnit(vEcritureComptable);

	}


	@Test(expected = FunctionalException.class)
	public void checkEcritureComptableRG5Violation() throws Exception {
		//Arrange
		EcritureComptable vEcritureComptable = new EcritureComptable();
		SequenceEcritureComptable sequence = new SequenceEcritureComptable(2022,1);
		JournalComptable journal = new JournalComptable("XX", "Achat");
		journal.setSequence(sequence);
		vEcritureComptable.setJournal(journal);
		vEcritureComptable.setDate(new Date());
		vEcritureComptable.setReference("XXX-2024/00001");
		vEcritureComptable.setLibelle("Libelle");

		// Create ligneEcritureComptable
		LigneEcritureComptable ligne1 = new LigneEcritureComptable(new CompteComptable(1), "XXX", new BigDecimal(123), null);
		LigneEcritureComptable ligne2 = new LigneEcritureComptable(new CompteComptable(1), "XXX", null , new BigDecimal(123));
		vEcritureComptable.setListLigneEcriture(ligne1);
		vEcritureComptable.setListLigneEcriture(ligne2);

		//Act
		manager.checkEcritureComptableUnit(vEcritureComptable);
	}


	@Test
	public void checkEcritureComptable() throws Exception {
		//Arrange
		EcritureComptable vEcritureComptable = new EcritureComptable();
		SequenceEcritureComptable sequence = new SequenceEcritureComptable(2021,1);
		JournalComptable journal = new JournalComptable("AC", "Achat");
		journal.setSequence(sequence);
		vEcritureComptable.setJournal(journal);
		vEcritureComptable.setDate(new Date());
		vEcritureComptable.setReference("AC-2021/00001");
		vEcritureComptable.setLibelle("Libelle");

		// Create ligneEcritureComptable
		LigneEcritureComptable ligne1 = new LigneEcritureComptable(new CompteComptable(1), "AC", new BigDecimal(123), null);
		LigneEcritureComptable ligne2 = new LigneEcritureComptable(new CompteComptable(1), "AC", null , new BigDecimal(123));
		vEcritureComptable.setListLigneEcriture(ligne1);
		vEcritureComptable.setListLigneEcriture(ligne2);

		//Act
		manager.checkEcritureComptableUnit(vEcritureComptable);

	}
}
