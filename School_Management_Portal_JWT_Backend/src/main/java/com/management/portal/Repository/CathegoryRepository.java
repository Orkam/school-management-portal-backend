/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 23 Nov 2023
*/
package com.management.portal.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.management.portal.Model.Cathegory;

@Repository
public interface CathegoryRepository  extends JpaRepository<Cathegory, Long>{

}
