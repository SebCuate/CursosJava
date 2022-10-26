package mx.demo.cursoJPA.models.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "clientes")
@Setter @Getter
public class Cliente implements Serializable {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotEmpty
	private String nombre;
	
	@NotEmpty
	private String apellido;
	
	@NotEmpty
	@Email
	private String email;

	@NotNull
	@Column(name = "create_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date createAt;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "cliente")
	//Fetch es para indicar la forma en que se consulta los tipos de datos que vengan de otra tabla (hijos)
	//Cascade indica que pasa cuando se modifica o elimina un registro de la tabla, all indica que todos los hijos deben modificarse en todas las operaciones
	//mappedBy indica la bidirección en la relación, el valor es el nombre del campo con el que aparece en la otra clase
	private List<Factura> facturas;
	
	private String foto;

	@Getter(AccessLevel.NONE)
	@Setter(AccessLevel.NONE)
	private static final long serialVersionUID = 1L;
	
	
	public Cliente() {
		this.facturas = new ArrayList<>();
	}
	
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	public void addFactura(Factura factura) {
		this.facturas.add(factura);
	}

	
	
	

}
