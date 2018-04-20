package test;

import org.testng.annotations.Test;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.testng.annotations.Test;

import helper.DataEntity;

public class CheckoutTest {
	@Test
	public void GuestUser_CheckoutFlow(DataEntity d){
		try {
			FileInputStream is=new FileInputStream(new File("/resources/data/test.data"));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
