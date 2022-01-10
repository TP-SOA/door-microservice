package fr.iss.soa.doormicroservice;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DoorController {
	private final DoorModel doorModel;

	public DoorController(DoorModel doorModel){
		this.doorModel = doorModel;
	}

	@GetMapping("/doors")
	public List<Door> doors() {
		return doorModel.findAll();
	}

	@GetMapping(value = "/doors/{id}")
	public Door doorsID(@PathVariable int id) {
		return doorModel.findById(id);
	}

	@PostMapping(value="/doors/{id}")
	public void setDoor(@PathVariable int id, @RequestBody String requestBody) {
		JSONObject jsonBody = new JSONObject(requestBody);
		try {
			boolean locked = jsonBody.getBoolean("locked");
			doorModel.update(id, locked);
		} catch(JSONException e) {
			e.printStackTrace();
		}
	}
}
