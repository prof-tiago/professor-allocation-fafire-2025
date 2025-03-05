package com.project.professor.allocation.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Professor {

	private Long id;
	private String name;
	private String cpf;
}
