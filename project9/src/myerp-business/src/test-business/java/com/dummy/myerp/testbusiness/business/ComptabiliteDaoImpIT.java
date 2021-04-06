package com.dummy.myerp.testbusiness.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import com.dummy.myerp.model.bean.comptabilite.*;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import com.dummy.myerp.business.contrat.manager.ComptabiliteManager;
import com.dummy.myerp.business.impl.BusinessProxyImpl;
import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.consumer.dao.contrat.DaoProxy;
import com.dummy.myerp.technical.exception.FunctionalException;


@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:bootstrapContext.xml")
public class ComptabiliteDaoImpIT {

	private ComptabiliteManager manager;

	@Inject
	private ComptabiliteDao comptabiliteDao;
	
	@Inject
    private BusinessProxyImpl businessProxy;
    
    @Inject
    private DaoProxy daoProxy;      
    
	@Before
	public void setUp() {
		manager = businessProxy.getComptabiliteManager();
	}
	
	@Test
	public void addReferenceTest() throws Exception {
		// Arrange
		EcritureComptable cEcritureComptable = new EcritureComptable();
		cEcritureComptable.setJournal(new JournalComptable("TS", "Test"));
		cEcritureComptable.setDate(new Date());
		cEcritureComptable.setLibelle("Test Libelle");
		cEcritureComptable.setReference("TS-2016/00001");

		List<EcritureComptable> comptes_before = comptabiliteDao.getListEcritureComptable();
		int size_before = comptes_before.size();

		// Act
		manager.addReference(cEcritureComptable);
		List<EcritureComptable> comptes_after = comptabiliteDao.getListEcritureComptable();
		int size_after = comptes_after.size();

		// Assert
		assertEquals(size_before, size_after);

	}

	@Test
	public void insertEcritureComptableTest() throws FunctionalException {
		// Arrange
		EcritureComptable cEcritureComptable = new EcritureComptable();
		cEcritureComptable.setDate(new Date());
		cEcritureComptable.setLibelle("Test Libelle");
		cEcritureComptable.setReference("TS-2021/00001");
		JournalComptable journal = new JournalComptable("AC", "Achat");
		SequenceEcritureComptable sequence = new SequenceEcritureComptable(2021,10);
		journal.setSequence(sequence);
		cEcritureComptable.setJournal(journal);

		CompteComptable compte = new CompteComptable(401, "Fournisseurs");
		LigneEcritureComptable ligne1 = new LigneEcritureComptable(compte, "TEST", new BigDecimal(0), new BigDecimal(150));
		LigneEcritureComptable ligne2 = new LigneEcritureComptable(compte, "TEST", new BigDecimal(150), new BigDecimal(0));
		cEcritureComptable.setListLigneEcriture(ligne1);
		cEcritureComptable.setListLigneEcriture(ligne2);

		List<EcritureComptable> comptes_before = comptabiliteDao.getListEcritureComptable();
		int size_before = comptes_before.size();

		// Act
		manager.insertEcritureComptable(cEcritureComptable);
		List<EcritureComptable> comptes_after = comptabiliteDao.getListEcritureComptable();
		int size_after = comptes_after.size();

		// Assert
		assertNotEquals(size_before, size_after);

	}

	@Test
	public void updateEcritureComptableTest() throws FunctionalException {
		// Arrange
		List<EcritureComptable> liste_ecriture = manager.getListEcritureComptable();
		int size = liste_ecriture.size();
		EcritureComptable cEcritureComptable = liste_ecriture.get(size-1);
		JournalComptable journal = cEcritureComptable.getJournal();
		SequenceEcritureComptable sequence = new SequenceEcritureComptable(2021, 1);
		journal.setSequence(sequence);
		cEcritureComptable.setJournal(journal);
		cEcritureComptable.setLibelle("Changement");

		// Act
		manager.updateEcritureComptable(cEcritureComptable);
		List<EcritureComptable> updated_liste_ecriture = manager.getListEcritureComptable();
		EcritureComptable updatedEcriture = updated_liste_ecriture.get(size-1);


		// Assert
		assertEquals("Changement", updatedEcriture.getLibelle());
	}

	@Test
	public void deleteEcritureComptableTest() throws FunctionalException {
		// Arrange
		List<EcritureComptable> liste_ecriture = manager.getListEcritureComptable();
		int size = liste_ecriture.size();
		EcritureComptable cEcritureComptable = liste_ecriture.get(size-1);

		List<EcritureComptable> comptes_before = comptabiliteDao.getListEcritureComptable();
		int size_before = comptes_before.size();

		// Act
		manager.deleteEcritureComptable(cEcritureComptable.getId());
		List<EcritureComptable> comptes_after = comptabiliteDao.getListEcritureComptable();
		int size_after = comptes_after.size();

		// Assert
		assertNotEquals(size_before, size_after);
	}
}
