package cl.desafiolatam.administracionbodega.app.repository.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(schema = "public", catalog = "role")
@SequenceGenerator(name = "role_id_role_seq", initialValue = 1,allocationSize = 1,sequenceName = "role_id_role_seq")
public class Role {
	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "role_id_role_seq")
	@Column(name = "id_role")
	private int idRole;

	@Column(name = "tipo")
	private String tipo;
	
	@JoinColumn(name = "users_id")
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	private List<Users> users;
}
