package hilo;

import java.time.LocalDate;

public class DrivingLicense {
	private Integer licenseNumber;
	private String name;
	private Integer age;
	private String gender;
	private String address;
	private LocalDate licenseIssueDate;
	private LocalDate licenseExpiryDate;
	private String licenseIssueZone;

	public DrivingLicense(){

	}

	public DrivingLicense(Integer licenseNumber, String name, Integer age,
						  String gender, String address, LocalDate licenseIssueDate,
						  LocalDate licenseExpiryDate, String licenseIssueZone) {
		this.licenseNumber = licenseNumber;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.address = address;
		this.licenseIssueDate = licenseIssueDate;
		this.licenseExpiryDate = licenseExpiryDate;
		this.licenseIssueZone = licenseIssueZone;
	}

	public Integer getLicenseNumber() {
		return licenseNumber;
	}

	public void setLicenseNumber(Integer licenseNumber) {
		this.licenseNumber = licenseNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public LocalDate getLicenseIssueDate() {
		return licenseIssueDate;
	}

	public void setLicenseIssueDate(LocalDate licenseIssueDate) {
		this.licenseIssueDate = licenseIssueDate;
	}

	public LocalDate getLicenseExpiryDate() {
		return licenseExpiryDate;
	}

	public void setLicenseExpiryDate(LocalDate licenseExpiryDate) {
		this.licenseExpiryDate = licenseExpiryDate;
	}

	public String getLicenseIssueZone() {
		return licenseIssueZone;
	}

	public void setLicenseIssueZone(String licenseIssueZone) {
		this.licenseIssueZone = licenseIssueZone;
	}
}
