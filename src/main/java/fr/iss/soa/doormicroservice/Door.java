package fr.iss.soa.doormicroservice;

public class Door {
	private final int id;
	private boolean locked;

	public Door(int id, boolean enabled) {
		this.id = id;
		this.locked = enabled;
	}

	public int getId() {
		return id;
	}

	public boolean isLocked() {
		return locked;
	}

	public void setLocked(boolean locked) {
		this.locked = locked;
	}
}
