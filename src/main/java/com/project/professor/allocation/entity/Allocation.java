package com.project.professor.allocation.entity;

import java.sql.Time;
import java.time.DayOfWeek;

import com.fasterxml.jackson.annotation.JsonProperty;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Allocation {

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Enumerated(EnumType.STRING)
	@Column(name = "day", nullable = false)
	private DayOfWeek dayOfWeek;

	@Schema(example = "19:00:00", type = "string")
	@Column(name = "startHour", nullable = false)
	private Time startHour;

	@Schema(example = "22:00:00", type = "string")
	@Column(name = "endHour", nullable = false)
	private Time endHour;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ManyToOne(optional = false)
	@JoinColumn(name = "professor_id", nullable = false)
	private Professor professor;

	@JsonProperty(access = JsonProperty.Access.READ_ONLY)
	@ManyToOne(optional = false)
	@JoinColumn(name = "course_id", nullable = false)
	private Course course;

	public void setProfessorId(Long id) {
		Professor professor = new Professor();
		professor.setId(id);
		this.setProfessor(professor);
	}

	public void setCourseId(Long id) {
		Course course = new Course();
		course.setId(id);
		this.setCourse(course);
	}
}
