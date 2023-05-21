package Lab11;

public class Gyeonggi extends Hub{
	public static int init_num = 10000;
	public static String init_area = "Gyeonggi";
	public static double init_price_per_box = 3000;
	
	public Gyeonggi(String description_) {
		super(++init_num, description_, init_area, init_price_per_box);
	}
}
