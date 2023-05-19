package lv.venta.models.users;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Table(name = "user_table")
@Entity
@Getter
@Setter
@NoArgsConstructor
//TODO pielikt @ToString, ja nepieciešanma
public class Person {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idp")//DB puse būs kolonna "idp" un būs kā auto increment PK
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idp;
	
	@Column(name = "Name")//DB puse būs kolonna title
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam")
	@Size(min = 3, max = 15, message = "Jabūt vismaz 3 un ne vairāk kā 15 simboliem")
	private String name;
	
	@Column(name = "Surname")//DB puse būs kolonna title
	@NotNull
	@Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam")
	@Size(min = 3, max = 15, message = "Jabūt vismaz 3 un ne vairāk kā 15 simboliem")
	private String surname;
	
	@Column(name = "Personcode")//DB puse būs kolonna title
	//TODO apdomāt un pielietot risinājumu ārzemju studentiem un jaunajiem LV personas kodiem
	@NotNull
	@Pattern(regexp = "[0-9]{6}-[0-9]{5}", message = "Neatbilstošs personas kods")
	@Size(min = 3, max = 15, message = "Jabūt vismaz 3 un ne vairāk kā 15 simboliem")
	private String personcode;
	
	
	@OneToOne
	@JoinColumn(name = "idu")
	private User user;


	public Person(
			@NotNull @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam") @Size(min = 3, max = 15, message = "Jabūt vismaz 3 un ne vairāk kā 15 simboliem") String name,
			@NotNull @Pattern(regexp = "[A-ZĒŪĪĻĶŠĀŽČŅ]{1}[a-zēūīļķšāžčņ\\ ]+", message = "Pirmajam burtam jābūt lielajam") @Size(min = 3, max = 15, message = "Jabūt vismaz 3 un ne vairāk kā 15 simboliem") String surname,
			@NotNull @Pattern(regexp = "[0-9]{6}-[0-9]{5}", message = "Neatbilstošs personas kods") @Size(min = 3, max = 15, message = "Jabūt vismaz 3 un ne vairāk kā 15 simboliem") String personcode,
			User user) {
		super();
		this.name = name;
		this.surname = surname;
		this.personcode = personcode;
		this.user = user;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
