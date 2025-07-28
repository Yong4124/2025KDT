package Ddadinghongkongduck;

public class SeasonEx {
	public static void main(String[] args) {
		for (Season s : Season.values()) {
			System.out.println(s.name() + ", " + s.name + ", " + s.temp);
		}
	}
}
