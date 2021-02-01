package com.dummy.myerp.business.impl.manager;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;

public class ComptabiliteManagerImplSIT {

	private ComptabiliteManagerImpl manager = new ComptabiliteManagerImpl();
	
	@Inject
	private ComptabiliteDao comptabiliteDao;
	
	@Test
	public void CheckEcritureComptable() throws Exception {
		// Arrange
		EcritureComptable cEcritureComptable = new EcritureComptable();
		cEcritureComptable.setJournal(new JournalComptable("TS", "Test"));
		cEcritureComptable.setDate(new Date());
		cEcritureComptable.setLibelle("Test Libelle");
		cEcritureComptable.setReference("TS-2020/00001");
		List<EcritureComptable> comptes_before = comptabiliteDao.getListEcritureComptable();
		int size_before = comptes_before.size();

		// Act
		manager.addReference(cEcritureComptable);
		List<EcritureComptable> comptes_after = comptabiliteDao.getListEcritureComptable();
		int size_after = comptes_after.size();

		// Assert
		assertEquals(size_before, size_after);

	}
}
