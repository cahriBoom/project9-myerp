package com.dummy.myerp.consumer.dao.impl.db.dao;


import com.dummy.myerp.model.bean.comptabilite.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;

import java.util.List;

import static org.junit.Assert.*;



@RunWith(SpringRunner.class)
@ContextConfiguration("classpath:bootstrapContext.xml")
public class ComptabiliteDaoImplIT {

    @Inject
    ComptabiliteDaoImpl comptabiliteDaoImpl;

    @Test
    public void testGetListCompteComptable() {
        //Act
        List<CompteComptable> compteComptableList = comptabiliteDaoImpl.getListCompteComptable();

        //Assert
        assertEquals("TI consumer list compte comptable", 7, compteComptableList.size());
    }
}
