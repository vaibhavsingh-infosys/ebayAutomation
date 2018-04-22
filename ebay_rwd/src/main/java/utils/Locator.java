package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

/**
 * Custom locator class - reads locators from object repository
 * Assigns locator type
 * @author Vaibhav
 *
 */
public class Locator {
	static Properties properties;
	static {
		properties=new Properties();
		File file=new File("src/main/resources/objectRepository");
		for(File f:file.listFiles()) {
			Properties temp= new Properties();
			try {
				temp.load(new FileInputStream(f));
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			properties.putAll(temp);
		}
	}
	
	enum Type{
		xpath , id ,classs , css ;
	};
	
	private String loc;
	private String desc;
	private Type type;
	public Locator(String loc, String desc) {
		String[] l=properties.getProperty(loc).split(":");
		this.loc=properties.getProperty(loc).replace(l[0]+":", "");
		this.desc=desc;
		if(l[0].contains("class")) {
			this.setType(Type.classs);
		}
		else
			this.setType(Type.valueOf(l[0].trim()));
	}
	
	public Locator(String loc, String desc, Type type) {
		this.loc=loc;
		this.desc=desc;
		this.setType(type);
	}
	
	public String getLoc() {
		return loc;
	}
	public void setLoc(String loc) {
		this.loc = loc;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public Type getType() {
		return type;
	}
	public void setType(Type type) {
		this.type = type;
	}
	
}
