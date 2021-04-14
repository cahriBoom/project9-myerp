package com.dummy.myerp.consumer.dao.impl.db.dao;


import com.dummy.myerp.model.bean.comptabilite.*;
import com.dummy.myerp.technical.exception.NotFoundException;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;



@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:bootstrapContext.xml")
public class ComptabiliteDaoImplIT {

    @Inject
    ComptabiliteDaoImpl comptabiliteDaoImpl;

    @Test
    public void testGetListCompteComptable() {
        //Arrange-Act
        List<CompteComptable> compteComptableList = comptabiliteDaoImpl.getListCompteComptable();

        //Assert
        assertEquals( 7, compteComptableList.size());
    }


    @Test
    public void testGetListJournalComptable(){
        //Arrange-Act
        List<JournalComptable> journalComptableList = comptabiliteDaoImpl.getListJournalComptable();

        //Assert
        Assert.assertEquals(4, journalComptableList.size());

    }


    @Test
    public void testGetListEcritureComptable(){
        //Arrange-Act
        List<EcritureComptable> ecritureComptablesList = comptabiliteDaoImpl.getListEcritureComptable();

        //Assert
        Assert.assertFalse(ecritureComptablesList.isEmpty());

    }

    @Test
    public void testInsertEcritureComptable()throws NotFoundException{
        //Arrange
        EcritureComptable ecriture = new EcritureComptable();
        JournalComptable journal = comptabiliteDaoImpl.getListJournalComptable().get(0);
        ecriture.setLibelle("Achat test d'insert");
        ecriture.setReference("AC-2016/00001");
        ecriture.setDate(new Date());
        ecriture.setJournal(journal);

        //Act
        comptabiliteDaoImpl.insertEcritureComptable(ecriture);
        EcritureComptable insertedEcriture = comptabiliteDaoImpl.getEcritureComptableByRef("AC-2016/00001");

        //Assert
        Assert.assertEquals("AC-2016/00001", insertedEcriture.getReference());

    }


    @Test
    public void testGetEcritureComptableByRef()throws NotFoundException{
        //Arrange
        String ref = "AC-2016/00001";

        //Act
        EcritureComptable ecriture = new EcritureComptable();
        NotFoundException notFoundException = null;
        try {
            ecriture = comptabiliteDaoImpl.getEcritureComptableByRef(ref);
        } catch (NotFoundException e) {
            notFoundException = e;
        }

        //Assert
        Assert.assertNotNull(ecriture);
        Assert.assertEquals("AC-2016/00001", ecriture.getReference());

    }


    @Test
    public void testLoadListLigneEcriture()throws NotFoundException{
        //Arrange
        EcritureComptable ecriture = comptabiliteDaoImpl.getEcritureComptableByRef("AC-2016/00001");

        //Act
        comptabiliteDaoImpl.loadListLigneEcriture(ecriture);

        //Assert
        Assert.assertNotNull(ecriture.getListLigneEcriture());

    }


    @Test
    public void testUpdateEcritureComptable()throws NotFoundException{
        //Arrange
        EcritureComptable ecriture = comptabiliteDaoImpl.getEcritureComptableByRef("AC-2016/00001");
        ecriture.setLibelle("updated libelle test");

        //Act
        comptabiliteDaoImpl.updateEcritureComptable(ecriture);
        EcritureComptable updatedEcriture = comptabiliteDaoImpl.getEcritureComptableByRef("AC-2016/00001");

        //Assert
        Assert.assertEquals("updated libelle test", updatedEcriture.getLibelle());
    }


    @Test(expected = NotFoundException.class)
    public void testDeleteEcritureComptable()throws NotFoundException{
        //Arrange
        EcritureComptable ecriture = comptabiliteDaoImpl.getEcritureComptableByRef("AC-2016/00001");

        //Act
        comptabiliteDaoImpl.deleteEcritureComptable(ecriture.getId());
        EcritureComptable deletedEcriture = comptabiliteDaoImpl.getEcritureComptableByRef("AC-2016/00001");

        //Assert
        Assert.assertNull(deletedEcriture);
    }


    @Test
    public void testGetDernierNumeroSequenceComptableByJournalAndAnnee(){
        //Arrange
        String code_journal = "AC";
        Integer annee = 2016;

        //Act
        Integer last_value = comptabiliteDaoImpl.getDernierNumeroSequenceComptableByJournalAndAnnee(code_journal, annee);

        //Assert
        Assert.assertEquals(Integer.valueOf(40),last_value);
    }


    @Test
    public void testInsertSequenceEcritureComptable(){
        //Arrange
        SequenceEcritureComptable sequence = new SequenceEcritureComptable();
        sequence.setCodeJournal("AC");
        sequence.setDerniereValeur(4);
        sequence.setAnnee(2021);

        //Act
        comptabiliteDaoImpl.insertSequenceEcritureComptable(sequence);
        Integer insertedSequenceId = comptabiliteDaoImpl.getDernierNumeroSequenceComptableByJournalAndAnnee("AC", 2021);

        //Assert
        Assert.assertEquals(Integer.valueOf(4), insertedSequenceId);
    }


    @Test
    public void testUpdateSequenceEcritureComptable(){
        //Arrange
        String code_journal = "AC";
        Integer annee = 2016;
        Integer last_value = 10;
        SequenceEcritureComptable sequence = new SequenceEcritureComptable(code_journal, annee, last_value);


        //Act
        comptabiliteDaoImpl.updateSequenceEcritureComptable(sequence);
        Integer updated_last_value = comptabiliteDaoImpl.getDernierNumeroSequenceComptableByJournalAndAnnee("AC", 2016);

        //Assert
        Assert.assertEquals(Integer.valueOf(10), updated_last_value);
    }
}
