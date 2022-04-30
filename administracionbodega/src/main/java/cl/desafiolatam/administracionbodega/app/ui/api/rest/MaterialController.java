package cl.desafiolatam.administracionbodega.app.ui.api.rest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;



import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cl.desafiolatam.administracionbodega.app.ui.model.request.MaterialRequest;
import cl.desafiolatam.administracionbodega.app.ui.model.response.MaterialResponse;

@RestController
@RequestMapping("/material/materiales")
public class MaterialController {
	/*GET, POT, PUT, DELETE*/
	private Map<String, MaterialResponse> material;
	private List<MaterialResponse> materialList;
	
//	Con este metodo se hacen las api inmmeriatamnete
	
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<ArrayList<MaterialResponse>> getMateriales() {

		if (material == null) {
			return new ResponseEntity<ArrayList<MaterialResponse>> (HttpStatus.NO_CONTENT);
		}else {
			return new ResponseEntity<ArrayList<MaterialResponse>> ( (ArrayList<MaterialResponse>) this.materialList,HttpStatus.OK);
		}			
	}
	
	@PostMapping(
			consumes = MediaType.APPLICATION_JSON_VALUE,
			produces = MediaType.APPLICATION_JSON_VALUE
			)
	
	public ResponseEntity<MaterialResponse> createMaterial(@RequestBody MaterialRequest materialRequest){
		
		MaterialResponse materialResponse = new MaterialResponse();
		materialResponse.setPrecio(materialRequest.getPrecio());
		materialResponse.setNombre(materialRequest.getNombre());
		materialResponse.setBodega(materialRequest.getBodega());
		materialResponse.setFechaIngreso(materialRequest.getFechaIngreso());
		
		String materialId = UUID.randomUUID().toString();
		materialResponse.setMaterialID(materialId);
		
		if (this.material == null) {
			this.material = new HashMap<String, MaterialResponse>();
			this.materialList = new ArrayList<MaterialResponse>();
		}		
		material.put(materialId, materialResponse);
		materialList.add(materialResponse);
		
		
		return new ResponseEntity<MaterialResponse>(materialResponse, HttpStatus.CREATED);
		
	}	
}
