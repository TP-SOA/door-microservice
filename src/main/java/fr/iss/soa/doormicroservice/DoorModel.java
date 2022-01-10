package fr.iss.soa.doormicroservice;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class DoorModel {
	public static List<Door> doorList = new ArrayList<>();

	static {
		doorList.add(new Door(1, false));
		doorList.add(new Door(7, false));
		doorList.add(new Door(11, false));
		doorList.add(new Door(114, false));
		doorList.add(new Door(116, false));
		doorList.add(new Door(213, true));
	}

	public List<Door> findAll() {
		return doorList;
	}

	public Door findById(int id) {
		for (Door door : doorList){
			if(door.getId() == id){
				return door;
			}
		}
		return null;
	}

	public void update(int id, boolean locked) {
		Door l = findById(id);
		l.setLocked(locked);
	}
}
