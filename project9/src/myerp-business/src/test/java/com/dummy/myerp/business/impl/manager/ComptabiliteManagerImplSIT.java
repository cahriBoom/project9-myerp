package com.dummy.myerp.business.impl.manager;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Test;

import com.dummy.myerp.consumer.dao.contrat.DaoProxy;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.technical.exception.FunctionalException;

public class ComptabiliteManagerImplSIT {

	private ComptabiliteManagerImpl manager = new ComptabiliteManagerImpl();
	
	
	@Inject
	private DaoProxy daoProxy;

	@Test
	public void addReferenceTest() throws Exception {
		// Arrange
		EcritureComptable cEcritureComptable = new EcritureComptable();
		cEcritureComptable.setJournal(new JournalComptable("TS", "Test"));
		cEcritureComptable.setDate(new Date());
		cEcritureComptable.setLibelle("Test Libelle");
		cEcritureComptable.setReference("TS-2020/00001");
		List<EcritureComptable> comptes_before = daoProxy.getComptabiliteDao().getListEcritureComptable();
		int size_before = comptes_before.size();

		// Act
		manager.addReference(cEcritureComptable);
		List<EcritureComptable> comptes_after = daoProxy.getComptabiliteDao().getListEcritureComptable();
		int size_after = comptes_after.size();

		// Assert
		assertEquals(size_before, size_after);

	}
	
	
	
	@Test
	public void insertEcritureComptableTest() throws FunctionalException {
		//Arrange
		EcritureComptable cEcritureComptable = new EcritureComptable();
		cEcritureComptable.setDate(new Date());
		cEcritureComptable.setLibelle("Test Libelle");
		cEcritureComptable.setReference("TS-2021/00001");
		List<EcritureComptable> comptes_before = daoProxy.getComptabiliteDao().getListEcritureComptable();
		int size_before = comptes_before.size();
		
		
		//Act
		manager.insertEcritureComptable(cEcritureComptable);
		List<EcritureComptable> comptes_after = daoProxy.getComptabiliteDao().getListEcritureComptable();
		int size_after = comptes_after.size();
		
		//Assert
		assertNotEquals(size_before, size_after);
		
		
	}
	
	
	
	@Test
	public void updateEcritureComptableTest() throws FunctionalException {
		//Arrange
		EcritureComptable cEcritureComptable = new EcritureComptable();
		cEcritureComptable.setDate(new Date());
		cEcritureComptable.setLibelle("Test Libelle");
		cEcritureComptable.setReference("TS-2021/00001");
		List<EcritureComptable> comptes_before = daoProxy.getComptabiliteDao().getListEcritureComptable();
		int size_before = comptes_before.size();
		
		
		//Act
		manager.updateEcritureComptable(cEcritureComptable);
		List<EcritureComptable> comptes_after = daoProxy.getComptabiliteDao().getListEcritureComptable();
		int size_after = comptes_after.size();
		
		//Assert
		assertEquals(size_before, size_after);
	}
	
	
	

	@Test 
	public void deleteEcritureComptableTest() throws FunctionalException {
		//Arrange
		EcritureComptable cEcritureComptable = new EcritureComptable();
		cEcritureComptable.setDate(new Date());
		cEcritureComptable.setLibelle("Test Libelle");
		cEcritureComptable.setReference("TS-2021/00001");
		List<EcritureComptable> comptes_before = daoProxy.getComptabiliteDao().getListEcritureComptable();
		int size_before = comptes_before.size();
		
		
		//Act
		manager.updateEcritureComptable(cEcritureComptable);
		List<EcritureComptable> comptes_after = daoProxy.getComptabiliteDao().getListEcritureComptable();
		int size_after = comptes_after.size();
		
		//Assert
		assertNotEquals(size_before, size_after);
	}
	
	
	
}
