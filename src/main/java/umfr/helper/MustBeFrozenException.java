package umfr.helper;

public final class MustBeFrozenException extends Exception {
	
	private Class freezeableClass;
	private String prefix;

	public MustBeFrozenException(Freezeable freezeable) {
		this.freezeableClass = freezeable.getClass();
	}
	
	public MustBeFrozenException(Freezeable freezeable, String prefix) {
		this.freezeableClass = freezeable.getClass();
		this.prefix = prefix;
	}
	
	public String toString() {
		String ret = "";
		if (prefix != null) {
			ret = prefix + " ";
		}
		ret += freezeableClass.getSimpleName() + " is not frozen.";
		return ret;
	}
}
