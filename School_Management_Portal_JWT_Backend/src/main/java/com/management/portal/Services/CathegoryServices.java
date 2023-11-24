/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 23 Nov 2023
*/
package com.management.portal.Services;

import java.util.Set;

import com.management.portal.Model.Cathegory;

public interface CathegoryServices {

	Cathegory addCathegory(Cathegory cathegory);

	Cathegory updateCathegory(Cathegory cathegory);

	Cathegory getCathegory(Long cathegoryID);

	void deleteCathegory(Long cathegoryID);

	Set<Cathegory> getCathegories();

}
