package lv.venta.models.users;

import java.util.ArrayList;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "student_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
public class Student extends Person{
	
	//TODO izveidot Data JPA anotācijas
	//TODO izveidot validāciju anotācijas
	//TODO izveidot sasaisti Course klasi ManyToMany
	@Column(name = "MatriculNo")
	@NotNull
	//@Size(min = 8, max = 20)
	@Pattern(regexp = "[0-9]{8,20}")
	private String matriculNo;
	
	@Column(name = "FinanceDept")
	private boolean financeDept;

	
	@ManyToMany
	@JoinTable(name = "student_debt_courses_table"),
	JoinColumn = @JoinColumn(name = "Idc"),
	InverseJoinColumn = @JoinColumn(name = "Idp"),
	private Collection<Course> debtCourses = new ArrayList<>();
	
	
	
	
	public Student(
			@NotNull @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam") @Size(min = 3, max = 15, message = "Jabūt vismaz 3 un ne vairāk kā 15 simboliem") String name,
			@NotNull @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam") @Size(min = 3, max = 15, message = "Jabūt vismaz 3 un ne vairāk kā 15 simboliem") String surname,
			@NotNull @Pattern(regexp = "[0-9]{6}-[0-9]{5}", message = "Neatbilstošs personas kods") @Size(min = 12, max = 12, message = "Jabūt vismaz 3 un ne vairāk kā 15 simboliem") String personcode,
			User user, @NotNull @Pattern(regexp = "[0-9]{8,20}") String matriculNo, boolean financeDept) {
		super(name, surname, personcode, user);
		this.matriculNo = matriculNo;
		this.financeDept = financeDept;
	}
	
	
	
	
}
