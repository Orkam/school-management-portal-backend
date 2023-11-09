/**
@project School_Management_Portal_JWT_Backend
@author Gustavo Guevara
@created 8 Nov 2023
*/
package com.management.portal.Model;

import org.springframework.security.core.GrantedAuthority;

public class Authority  implements GrantedAuthority{
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -5607709844098157570L;
	private String authority;
	
	

	public Authority(String authority) {
		super();
		this.authority = authority;
	}



	@Override
	public String getAuthority() {
		
		return this.authority;
	}

}
