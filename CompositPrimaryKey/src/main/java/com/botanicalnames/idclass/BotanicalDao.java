package com.botanicalnames.idclass;

import com.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class BotanicalDao {

    public void addBotanicalNames(List<BotanicalNames> namesList) {

        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx1 = session.beginTransaction();

        for(BotanicalNames name : namesList){
            session.save(name);
        }
        tx1.commit();
        session.close();
    }

    public BotanicalNames getPlantDetails(String genericName, String speciesName) {

        return null;
    }
}
