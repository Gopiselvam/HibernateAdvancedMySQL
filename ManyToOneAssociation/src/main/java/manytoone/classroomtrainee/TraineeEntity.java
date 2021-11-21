package manytoone.classroomtrainee;

import javax.persistence.*;

@Entity
@Table(name="TRAINEE")
public class TraineeEntity {
	@Id
	private Integer id;
	private String name;

	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE})
	@JoinColumn(name = "classRoomId" )
	private ClassRoomEntity classRoom;

	public TraineeEntity() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public ClassRoomEntity getClassRoom() {
		return classRoom;
	}

	public void setClassRoom(ClassRoomEntity classRoom) {
		this.classRoom = classRoom;
	}

	@Override
	public String toString() {
		return "TraineeEntity{" +
				"id=" + id +
				", name='" + name + '\'' +
				", classRoom=" + classRoom +
				'}';
	}
}
