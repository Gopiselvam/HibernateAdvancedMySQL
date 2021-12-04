package inheritance.singletable;

import inheritance.HibernateUtils;
import inheritance.singletable.PlantEntity;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class PlantsDaoSingleTable {

    public void addPlant(inheritance.singletable.PlantEntity plantEntity){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(plantEntity);
        tx.commit();
        session.close();
    }

    public inheritance.singletable.PlantEntity getPlant(String plantName){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        inheritance.singletable.PlantEntity plantEntity = session.get(PlantEntity.class, plantName);
        tx.commit();
        session.close();
        return plantEntity;
    }
}
