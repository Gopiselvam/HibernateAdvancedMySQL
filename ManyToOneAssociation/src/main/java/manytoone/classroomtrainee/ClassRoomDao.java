package manytoone.classroomtrainee;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class ClassRoomDao {

    public void addTrainee(TraineeEntity trainee){
        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        session.save(trainee);

        tx.commit();
        session.close();
    }

    public boolean deleteTrainee(Integer traineeId){

        Session session = HibernateUtils.getSessionFactory().openSession();

        Transaction tx = session.beginTransaction();

        TraineeEntity trainee = session.get(TraineeEntity.class, traineeId);
        if(null != trainee){
            session.delete(trainee);
        }
        tx.commit();
        return true;
    }

    public TraineeEntity getAllocationDetails(Integer traineeId){
        Session session = HibernateUtils.getSessionFactory().openSession();

        TraineeEntity trainee = session.get(TraineeEntity.class, traineeId);

        session.close();
        return trainee;
    }

    public TraineeEntity updateTraineeWithExistingClassroom(Integer traineeId, String classRoomId){

        Session session = HibernateUtils.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();

        ClassRoomEntity classRoom = session.get(ClassRoomEntity.class, classRoomId);
        TraineeEntity trainee = session.get(TraineeEntity.class, traineeId);
        trainee.setClassRoom(classRoom);

        session.saveOrUpdate(trainee);

        tx.commit();
        session.close();
        return trainee;
    }

}
