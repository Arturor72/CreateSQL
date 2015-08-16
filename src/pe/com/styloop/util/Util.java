package pe.com.styloop.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.util.Properties;

import pe.com.styloop.common.Constants;

public class Util {
	
	public static void writeAppendLine(StringBuilder line)throws IOException{
		File file=new File(Constants.PATH_TO);
		existFile(file);
		FileWriter fw = new FileWriter(file.getAbsoluteFile(),true);
		BufferedWriter bw = new BufferedWriter(fw);
		bw.write(line.toString());
		bw.close();
	}
	
	public static BufferedReader generateBuffer(String pathFile) throws FileNotFoundException  {
		File file = new File(pathFile);
		Reader reader=null;
		BufferedReader buffer=null;
			reader=new FileReader(file);
			buffer=new BufferedReader(reader);
		return buffer;
	}
	public static void existFile(File file) throws IOException {
		if(!file.exists()){
			file.createNewFile();
		}
	}
	public static Properties getProperties(){
		Properties properties=new Properties();
		InputStream in=null;
		String file=Constants.PROPERTIES;
		try{
			in=Util.class.getClassLoader().getResourceAsStream(file);
			if(in==null){
				System.out.println("can't read properties file, sure that file is in classpath inside src folder");
				return properties;
			}
			properties.load(in);
		}catch(Exception e){
			System.out.println(e.getMessage());
		}
		return properties;
	}
	
	public static String checkType(String date, String type) throws Exception{
		if(type.equalsIgnoreCase(Constants.TYPES_VARCHAR)) { 
			date="'"+date+"'";
			return date;
		}
		else if(type.equalsIgnoreCase(Constants.TYPES_NUMBER)){
			return date;
		}else{
			throw new Exception("No existe el tipo de dato indicado");
		}
	} 
	
}
