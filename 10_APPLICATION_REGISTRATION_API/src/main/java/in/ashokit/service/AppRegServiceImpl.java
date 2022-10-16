package in.ashokit.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import in.ashokit.binding.CitizenEntityRequest;
import in.ashokit.entity.CitizenEntity;
import in.ashokit.repository.CitizenAppRepository;

@Service
public class AppRegServiceImpl implements AppRegI {

	@Autowired
	private CitizenAppRepository citizenAppRepository;

	@Override
	public Integer createAppllicationRegistration(CitizenEntityRequest request) {

		// make rest call to ssa-web api with ssn sa input

		String endpointUrl = "https://ssa-web-api.herokuapp.com/ssn/{ssn}";
		RestTemplate rt = new RestTemplate();
		ResponseEntity<String> responseEntity = rt.getForEntity(endpointUrl, String.class, request.getSsn());
		String stateName = responseEntity.getBody();

		if ("New Jersey".equals(stateName)) {
			// create Application

			CitizenEntity entity = new CitizenEntity();
			BeanUtils.copyProperties(request, entity);
			CitizenEntity save = citizenAppRepository.save(entity);

			return save.getAppId();
		}
		return 0;
	}

}
