package Lab11;
import java.util.ArrayList;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;


public class ServiceManagement {
	public static <T extends Hub> int findIndexByNum(ArrayList<T> tList, int num) {
		int cnt = 0;
		for(T element : tList) {
			if(element.getNumber() == num) {
				return cnt;
			}
			cnt++;
		}
		return -1;
	}
	
	public static <T extends Hub> T raisePerBox(T t, double rate) {
		t.setPricePerBox(t.getPricePerBox() * rate);
		return t;
	}
	
	public static <T extends Hub> ArrayList<T> raiseAll(Class<T> c, ArrayList<T> tList, double rate){
		for(T elem : tList) {
			elem.setPricePerBox(rate*elem.getPricePerBox());
		}
		
		try {
			Field f = c.getField("init_price_per_box");
			double value = f.getDouble(null);
			f.setDouble(null, value*rate);
		}
		catch (NoSuchFieldException | SecurityException | IllegalArgumentException | IllegalAccessException e){
			e.printStackTrace();
		}
		return tList;
	}
	
	public static <T extends Hub> void packageBoxes(String[] descriptions, Class<T> classtype, ArrayList<T> tList) {
		try {
			for(int i = 0; i <descriptions.length; i++) {
				Constructor<T> ClassConstructor = classtype.getConstructor(String.class);
				tList.add(ClassConstructor.newInstance(descriptions[i]));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static <T extends Hub, U extends Hub> void changeHub(ArrayList<T> tList, int index, Class<U> classtype, ArrayList<U> uList) {
		try {
			T temp = tList.get(index);
			Constructor<U> uConstructor = classtype.getConstructor(String.class);
			U newU = uConstructor.newInstance(temp.getDescription());
			tList.set(index, null);
			ServiceManagement.raisePerBox(newU, 0.9);
			uList.add(newU);
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}

