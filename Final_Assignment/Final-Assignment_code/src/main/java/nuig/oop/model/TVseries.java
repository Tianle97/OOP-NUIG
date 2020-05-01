package nuig.oop.model;

public class TVseries extends Media {
	private int tid;
	private String creator;

	private TVseries() {
	}

	public static TVseries getInstance() {
		return new TVseries();
	}

	public int getTid() {
		return tid;
	}

	public void setTid(int tid) {
		this.tid = tid;
	}

	public String getCreator() {
		return creator;
	}

	public void setCreator(String creator) {
		this.creator = creator;
	}

}
