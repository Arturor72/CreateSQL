package pe.com.bean;

import java.util.List;

public class Table {
	public List<String> nameFields;
	public List<String> typeFields;
	public List<Record> records;
	public List<String> getNameFields() {
		return nameFields;
	}
	public void setNameFields(List<String> nameFields) {
		this.nameFields = nameFields;
	}
	public List<Record> getRecords() {
		return records;
	}
	public void setRecords(List<Record> records) {
		this.records = records;
	}
	public List<String> getTypeFields() {
		return typeFields;
	}
	public void setTypeFields(List<String> typeFields) {
		this.typeFields = typeFields;
	}
	
	
	
}
