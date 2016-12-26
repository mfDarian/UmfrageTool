package umfr.helper;

public final class FrozenException extends Exception {
	
	private Class freezeableClass;
	
	public FrozenException(Freezeable freezeable) {
		this.freezeableClass = freezeable.getClass();
	}
	
	public String toString() {
		return freezeableClass.getName() + " is frozen";
	}

}
