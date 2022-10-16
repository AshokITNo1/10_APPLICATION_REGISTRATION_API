package in.ashokit.binding;

import java.time.LocalDate;

import lombok.Data;

@Data
public class CitizenEntityRequest {

	private String fullName;

	private String email;

	private Long mobileNumber;

	private String gender;

	private Long ssn;

	private LocalDate dob;

}
