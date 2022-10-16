package in.ashokit.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "CITIZEN_APPS")
@Data
public class CitizenEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer appId;

	private String fullName;

	private String email;

	private Long mobileNumber;

	private Long ssn;

	private String gender;

	private LocalDate dob;

	private String stateName;

	@CreationTimestamp
	private LocalDate createDate;

	@UpdateTimestamp
	private LocalDate updateDate;

	private String createdBy;

	private String updatedBy;

}
