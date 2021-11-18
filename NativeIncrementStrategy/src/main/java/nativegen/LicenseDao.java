package nativegen;

import org.hibernate.Session;

public class LicenseDao {
    public Integer addRecords(DrivingLicense license){

        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        session.save(license);
        session.getTransaction().commit();
        session.close();
        return null;
    }
    public DrivingLicense read(Integer licenseNumber){

        Session session = HibernateUtil.getSessionFactory().openSession();
        DrivingLicense drivingLicense = (DrivingLicense) session.get(DrivingLicense.class, licenseNumber);
        System.out.println(drivingLicense);
        session.close();
        return null;
    }
}
