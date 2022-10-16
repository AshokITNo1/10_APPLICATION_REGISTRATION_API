package in.ashokit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.binding.CitizenEntityRequest;
import in.ashokit.service.AppRegServiceImpl;

@RestController
public class AppRegController {

	@Autowired
	private AppRegServiceImpl appRegServiceImpl;

	@PostMapping(value = "/citizenRequest")
	public ResponseEntity<String> createCitizenApp(@RequestBody CitizenEntityRequest request) {

		Integer appId = appRegServiceImpl.createAppllicationRegistration(request);

		if (appId > 0) {
			return new ResponseEntity<>("App created with App Id: " + appId, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Invalid SSN" + appId, HttpStatus.BAD_REQUEST);
		}
	}

}
