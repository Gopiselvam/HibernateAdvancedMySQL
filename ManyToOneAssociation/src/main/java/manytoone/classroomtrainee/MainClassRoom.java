package manytoone.classroomtrainee;

import java.util.Scanner;

public class MainClassRoom {

    private static ClassRoomDao dao = new ClassRoomDao();

    public static void main(String[] args) {
        HibernateUtils.createSessionFactory();
//        addTraineeToClassRoom();
//        deleteTrainee();
//        getTraineeDetails();
//        addTraineeWithoutClassroom();
//        updateTraineeWithExistingClassroom();
    }

    private static void updateTraineeWithExistingClassroom() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the trainee id");
        int traineeId = sc.nextInt();
        sc.nextLine();
        System.out.println("Enter the classroom id");
        String classroomId = sc.nextLine();
        TraineeEntity trainee = dao.updateTraineeWithExistingClassroom(traineeId, classroomId);
        if(null != trainee){
            System.out.println("Trainee details updated with classroom: "+trainee);
        }else {
            System.out.println("Unable to update trainee with classroom");
        }

    }

    private static void addTraineeWithoutClassroom() {
        TraineeEntity trainee = new TraineeEntity();
        trainee.setId(1003);
        trainee.setName("Álvaro Morte");
        dao.addTrainee(trainee);
    }

    private static void getTraineeDetails() {
        System.out.println("Enter the trainee id");  //1001
        Scanner sc = new Scanner(System.in);
        Integer traineeId = sc.nextInt();
        sc.nextLine();
        TraineeEntity trainee = dao.getAllocationDetails(traineeId);
        if(null!= trainee){
            System.out.println(trainee);
        }else{
            System.err.println("Trainee not found");
        }
    }

    private static void deleteTrainee() {

        System.out.println("Enter the trainee id to be deleted");  //1001
        Scanner sc = new Scanner(System.in);
        Integer traineeId = sc.nextInt();
        sc.nextLine();
        dao.deleteTrainee(traineeId);
    }

    private static void addTraineeToClassRoom() {
        Scanner sc = new Scanner(System.in);
        TraineeEntity trainee = new TraineeEntity();
        ClassRoomEntity classRoomDao = new ClassRoomEntity();
        System.out.println("Eneter the classroom id");
        String classroomId = sc.nextLine();
        classRoomDao.setClassRoomId(classroomId);
        System.out.println("Eneter the classroom capacity");
        Integer seatingCapacity = sc.nextInt();
        sc.nextLine();
        classRoomDao.setSeatingCapacity(seatingCapacity);

        System.out.println("Eneter the trainee id");
        Integer traineeId = sc.nextInt();
        sc.nextLine();
        trainee.setId(traineeId);
        System.out.println("Eneter the trainee name");
        String traineeName = sc.nextLine();
        trainee.setName(traineeName);

        trainee.setClassRoom(classRoomDao);

        dao.addTrainee(trainee);
    }
}
