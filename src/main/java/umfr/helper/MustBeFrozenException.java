package umfr.helper;

public class MustBeFrozenException extends Exception {
	
	private Class freezeableClass;

	public MustBeFrozenException(Freezeable freezeable) {
		this.freezeableClass = freezeable.getClass();
	}
	
	public String toString() {
		return freezeableClass.getName() + " is not frozen";
	}
}
