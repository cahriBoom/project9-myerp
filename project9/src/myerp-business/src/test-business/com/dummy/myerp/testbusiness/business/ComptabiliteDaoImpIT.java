package com.dummy.myerp.testbusiness.business;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import java.util.Date;
import java.util.List;

import javax.inject.Inject;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import com.dummy.myerp.business.contrat.manager.ComptabiliteManager;
import com.dummy.myerp.business.impl.BusinessProxyImpl;
import com.dummy.myerp.business.impl.TransactionManager;
import com.dummy.myerp.business.impl.manager.ComptabiliteManagerImpl;
import com.dummy.myerp.consumer.dao.contrat.ComptabiliteDao;
import com.dummy.myerp.consumer.dao.contrat.DaoProxy;
import com.dummy.myerp.model.bean.comptabilite.EcritureComptable;
import com.dummy.myerp.model.bean.comptabilite.JournalComptable;
import com.dummy.myerp.technical.exception.FunctionalException;

import org.springframework.test.context.ContextConfiguration;


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
    
    @Inject
    private TransactionManager transactionManager;
    
	 
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

	@Test
	public void insertEcritureComptableTest() throws FunctionalException {
		// Arrange
		EcritureComptable cEcritureComptable = new EcritureComptable();
		cEcritureComptable.setDate(new Date());
		cEcritureComptable.setLibelle("Test Libelle");
		cEcritureComptable.setReference("TS-2021/00001");
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
		EcritureComptable cEcritureComptable = new EcritureComptable();
		cEcritureComptable.setDate(new Date());
		cEcritureComptable.setLibelle("Test Libelle");
		cEcritureComptable.setReference("TS-2021/00001");
		List<EcritureComptable> comptes_before = comptabiliteDao.getListEcritureComptable();
		int size_before = comptes_before.size();

		// Act
		manager.updateEcritureComptable(cEcritureComptable);
		List<EcritureComptable> comptes_after = comptabiliteDao.getListEcritureComptable();
		int size_after = comptes_after.size();

		// Assert
		assertEquals(size_before, size_after);
	}

	@Test
	public void deleteEcritureComptableTest() throws FunctionalException {
		// Arrange
		EcritureComptable cEcritureComptable = new EcritureComptable();
		cEcritureComptable.setDate(new Date());
		cEcritureComptable.setLibelle("Test Libelle");
		cEcritureComptable.setReference("TS-2021/00001");
		List<EcritureComptable> comptes_before = comptabiliteDao.getListEcritureComptable();
		int size_before = comptes_before.size();

		// Act
		manager.updateEcritureComptable(cEcritureComptable);
		List<EcritureComptable> comptes_after = comptabiliteDao.getListEcritureComptable();
		int size_after = comptes_after.size();

		// Assert
		assertNotEquals(size_before, size_after);
	}
}
