/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 23 Nov 2023
*/
package com.management.portal.Services;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.management.portal.Model.Cathegory;
import com.management.portal.Repository.CathegoryRepository;

@Service
public class CathegoryServicesImpl implements CathegoryServices {

	@Autowired
	private CathegoryRepository cathegoryRepository;

	@Override
	public Set<Cathegory> getCathegories() {

		return new LinkedHashSet<>(cathegoryRepository.findAll());
	}

	@Override
	public Cathegory addCathegory(Cathegory cathegory) {

		return cathegoryRepository.save(cathegory);
	}

	@Override
	public Cathegory updateCathegory(Cathegory cathegory) {

		return cathegoryRepository.save(cathegory);
	}

	@Override
	public Cathegory getCathegory(Long cathegoryID) {

		return cathegoryRepository.findById(cathegoryID).get();
	}

	@Override
	public void deleteCathegory(Long cathegoryID) {

		Cathegory cathegory = new Cathegory();
		cathegory.setCathegoryID(cathegoryID);
		cathegoryRepository.delete(cathegory);

	}

}
