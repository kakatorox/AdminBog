package cl.desafiolatam.administracionbodega.app.repository.model;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", catalog = "users")
@SequenceGenerator(name = "users_id_users_seq", initialValue = 1,allocationSize = 1,sequenceName = "users_id_users_seq")
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "users_id_users_seq")
	@Column(name = "id_users")
	private int idUsers;

	@Column(name = "email")
	private String email;
		
	@Column(name = "password")
	private String password;
	
	@JoinColumn(name = "role_id")
	@ManyToOne
	private Role role;
}
