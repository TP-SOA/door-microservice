package fr.iss.soa.doormicroservice;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

@RestController
public class DoorController {
	private final DoorModel doorModel;

	public DoorController(DoorModel doorModel){
		this.doorModel = doorModel;
		Timer t = new Timer();
		// Update door status every 10 seconds
		t.schedule(new TimerTask() {
			@Override
			public void run() {
				Door d = doorModel.findById(114);
				if (d != null) {
					d.setLocked(!d.isLocked());
				}
			}
		}, 0, 30*1000);
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
