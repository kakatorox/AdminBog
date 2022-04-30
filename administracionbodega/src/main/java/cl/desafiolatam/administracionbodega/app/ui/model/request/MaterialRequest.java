package cl.desafiolatam.administracionbodega.app.ui.model.request;

import lombok.Data;

@Data
public class MaterialRequest {
	private String precio;
	private String nombre;
	private String bodega;
	private String fechaIngreso;
}
