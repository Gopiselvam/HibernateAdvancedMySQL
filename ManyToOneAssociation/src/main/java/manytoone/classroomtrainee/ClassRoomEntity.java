package manytoone.classroomtrainee;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "CLASSROOM")
public class ClassRoomEntity {

	@Id
	private String classRoomId;
	private Integer seatingCapacity;

	public ClassRoomEntity() {
	}

	public String getClassRoomId() {
		return classRoomId;
	}

	public void setClassRoomId(String classRoomId) {
		this.classRoomId = classRoomId;
	}

	public Integer getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(Integer seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	@Override
	public String toString() {
		return "ClassRoomEntity{" +
				"classRoomId='" + classRoomId + '\'' +
				", seatingCapacity=" + seatingCapacity +
				'}';
	}
}
