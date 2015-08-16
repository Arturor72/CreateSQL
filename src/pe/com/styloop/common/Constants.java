package pe.com.styloop.common;

import pe.com.styloop.util.Util;

public class Constants {
	//SQL Constants
	public final static String INSERT="INSERT INTO";
	public final static String VALUES="VALUES";

	
	
	//Properties Constans
	public final static String PROPERTIES="properties.properties";
	public final static String TABLE_NAME=Util.getProperties().getProperty("name.table");
	public final static String FIELDS_NAME=Util.getProperties().getProperty("table.fields");
	public final static String FIELDS_NAMES_SEPARATOR=Util.getProperties().getProperty("fields.names.separator");
	public final static String FIELDS_SEPARATOR=Util.getProperties().getProperty("fields.separator");
	public final static String PATH_SOURCE=Util.getProperties().getProperty("table.path.source");
	public final static String PATH_TO=Util.getProperties().getProperty("table.path.to");
	  //Types
	public final static String TYPES=Util.getProperties().getProperty("table.fields.types");
	public final static String TYPES_VARCHAR="VARCHAR";
	public final static String TYPES_NUMBER="NUMBER";
	
	
	
}
