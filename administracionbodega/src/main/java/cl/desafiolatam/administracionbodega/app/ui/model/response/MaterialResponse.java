package cl.desafiolatam.administracionbodega.app.ui.model.response;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
public class MaterialResponse {
	private String materialID;
	private String precio;
	private String nombre;
	private String bodega;
	private String fechaIngreso;

}
