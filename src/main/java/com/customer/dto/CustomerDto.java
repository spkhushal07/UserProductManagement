package com.customer.dto;

import java.time.LocalDateTime;
import java.util.List;

import lombok.Data;
@Data
public class CustomerDto 
{
	
	private String userFirstName;
	private String userLastName;
	private String userName;
	private String password;
	private String email;
	private String mobileNumber;
	private LocalDateTime userLastLogin;
    private List<Integer> products ;	

}
