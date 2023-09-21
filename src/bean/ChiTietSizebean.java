package bean;

public class ChiTietSizebean {
	private long MaSize;
	private int Size;
	private long MaGiay;

	public ChiTietSizebean() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ChiTietSizebean(long maSize, int size, long maGiay) {
		super();
		MaSize = maSize;
		Size = size;
		MaGiay = maGiay;
	}

	public long getMaSize() {
		return MaSize;
	}

	public void setMaSize(long maSize) {
		MaSize = maSize;
	}

	public int getSize() {
		return Size;
	}

	public void setSize(int size) {
		Size = size;
	}

	public long getMaGiay() {
		return MaGiay;
	}

	public void setMaGiay(long maGiay) {
		MaGiay = maGiay;
	}

}
