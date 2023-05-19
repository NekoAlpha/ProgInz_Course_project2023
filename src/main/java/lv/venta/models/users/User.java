package lv.venta.models.users;

import java.util.Collection;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
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
	@Column(name = "Idu")//DB puse būs kolonna "idp" un būs kā auto increment PK
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idu;
}
