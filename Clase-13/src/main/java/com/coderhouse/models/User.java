package com.coderhouse.models;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

	private String id;
	private String nombreUser;
	private String apellidosUser;
	private String emailUser;
	private String createdAt;
}
