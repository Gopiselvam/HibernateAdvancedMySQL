package inheritance.singletable;

import inheritance.HibernateUtils;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlantsDaoSingleTable {

    public void addPlant(PlantEntity plantEntity){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(plantEntity);
        tx.commit();
        session.close();
    }

    public PlantEntity getPlant(String plantName){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        inheritance.singletable.PlantEntity plantEntity = session.get(PlantEntity.class, plantName);
        tx.commit();
        session.close();
        return plantEntity;
    }
}
