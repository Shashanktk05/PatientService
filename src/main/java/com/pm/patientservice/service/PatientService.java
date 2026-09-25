package com.pm.patientservice.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.pm.patientservice.dto.PatientResponseDTO;
import com.pm.patientservice.mapper.PatientMapper;
import com.pm.patientservice.model.Patient;
import com.pm.patientservice.repository.PatientRepository;

@Service
public class PatientService {

	private PatientRepository patientRepository;

	public PatientRepository getPatientRepository() {
		return patientRepository;
	}

	public void setPatientRepository(PatientRepository patientRepository) {
		this.patientRepository = patientRepository;
	}

	public List<PatientResponseDTO> getPatients() {
		List<Patient> patients = patientRepository.findAll();

		List<PatientResponseDTO> patientResponseDTO = patients.stream().map(patient -> PatientMapper.toDTO(patient))
				.toList();

		return patientResponseDTO;

	}

}
