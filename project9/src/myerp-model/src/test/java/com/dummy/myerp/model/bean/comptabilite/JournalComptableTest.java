package com.dummy.myerp.model.bean.comptabilite;

import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static com.dummy.myerp.model.bean.comptabilite.JournalComptable.getByCode;

public class JournalComptableTest {

    @Test
    public void testConstructorWithParam(){
        //Arrange
        String code = "1";
        String libelle = "libelle test";

        //Act
        JournalComptable journal = new JournalComptable(code, libelle);

        //Assert
        Assert.assertEquals(code, journal.getCode());
        Assert.assertEquals(libelle, journal.getLibelle());
        Assert.assertEquals("JournalComptable{code='1', libelle='libelle test'}", journal.toString());
    }


    @Test
    public void testGetByCodeInListContainingTheExpectedJournal(){
        //Arrange
        List<JournalComptable> journalComptableList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            journalComptableList.add(new JournalComptable("AC-"+i, "Journal: "+i));
        }
        String expectedCodeJournalComptable = "AC-4";

        //Act
        JournalComptable resultJournalComptable = getByCode(journalComptableList, expectedCodeJournalComptable);

        //Assert
        Assert.assertEquals("JournalComptable{code='AC-4', libelle='Journal: 4'}", resultJournalComptable.toString());
    }


    @Test
    public void testGetByCodeInListNotContainingTheExpectedJournal(){
        //Arrange
        List<JournalComptable> journalComptableList = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            journalComptableList.add(new JournalComptable("AC-"+i, "Journal: "+i));
        }
        String expectedCodeJournalComptable = "AC-10";

        //Act
        JournalComptable resultJournalComptable = getByCode(journalComptableList, expectedCodeJournalComptable);

        //Assert
        Assert.assertNull(resultJournalComptable);
    }
}
