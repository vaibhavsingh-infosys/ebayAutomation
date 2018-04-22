package utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.DataProvider;

import helper.DataEntity;

public class CustomDataProvider {

	/**
	 * Data provider to read test data from test.data file and pass it to test script
	 * @return
	 */
	@DataProvider(name = "checkOutData")
	public static Object[][] testData() {
		List<DataEntity> dataList= new ArrayList<DataEntity>();
		
		try {
			BufferedReader reader=new BufferedReader(new FileReader(new File("src/main/resources/data/test.data")));
			String s;
			reader.readLine();
			while((s=reader.readLine())!=null) {
				String[] data=s.split("\\|");
				DataEntity entity=new DataEntity();
				entity.setSearchKeyword(data[1].trim());
				entity.setScreenSize(data[2].trim());
				entity.setQuantity(data[3].trim());
				entity.setUserType(data[4].trim());
				dataList.add(entity);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
		Object [][] obj = new Object [dataList.size()][1];
		 for(int i=0; i<dataList.size() ; i++) {
		        obj[i][0] = dataList.get(i);
		 }
		return obj;
	}

	public static void main(String[] args) {
		testData();
	}
}
