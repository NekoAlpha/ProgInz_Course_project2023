package lv.venta.models.users;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
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
public class User {
	
	@Setter(value = AccessLevel.NONE)
	@Column(name = "Idu")
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idu;
	
	//TODO Data JPA anotācija
	//TODO validāciju anotācijas
	
	
	@Column(name = "Password")
	@NotNull
	//TODO papildināt ar validāciju, kad ir zināms passwordEncoder
	private String password;//TODO kad pievienos spring security, tad jāuzliek passwordEncoder
	
	@Column(name = "Email")
	@NotNull
	@Email
	private String email;

	public User(@NotNull String password, @NotNull @Email String email) {
		super();
		this.password = password;
		this.email = email;
	}
	
	
	
	
}
