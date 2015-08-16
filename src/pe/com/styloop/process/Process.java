package pe.com.styloop.process;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import pe.com.bean.Record;
import pe.com.bean.Table;
import pe.com.styloop.common.Constants;
import pe.com.styloop.util.Util;

public class Process {

	public boolean generateScript() throws Exception {

		Table entity = new Table();
		boolean stateProcess = false;
		readTypesOfFields(entity);
		readNamesOfFields(entity);
		setRecordsToEntity(entity);
		generateSentence(entity);
		stateProcess = true;
		return stateProcess;
	}

	private void setRecordsToEntity(Table entity) throws Exception {
		BufferedReader buffer = null;
		buffer = Util.generateBuffer(Constants.PATH_SOURCE);
		List<Record> records = new ArrayList<Record>();
		String lineOfFile = "";
		while ((lineOfFile = buffer.readLine()) != null) {
			Record record = new Record();
			lineToRecord(record, lineOfFile, entity.getTypeFields());
			if (record.getFields().size() != entity.getNameFields().size()) {
				longFieldsException("Long name files is different that number of fields");
			} else if (record.getFields().size() != entity.getTypeFields()
					.size()) {
				longFieldsException("Long type files is different that number of fields");
			}
			records.add(record);
		}
		entity.setRecords(records);
		closeBuffer(buffer);

	}

	private void longFieldsException(String type) throws Exception {
		throw new Exception(type);
	}

	public void generateSentence(Table entity) throws IOException, Exception {
		StringBuilder sqlBuilder = null;
		for (Record record : entity.getRecords()) {
			sqlBuilder = getSQL(entity, record);
			Util.writeAppendLine(sqlBuilder);
		}
	}

	public void lineToRecord(Record record, String lineOfFile,
			List<String> types) throws Exception {
		readFields(record, lineOfFile, types);
	}

	public void readFields(Record record, String lineOfFile, List<String> types)
			throws Exception {
		String arrayFields[] = lineOfFile.split(Constants.FIELDS_SEPARATOR);
		List<String> fieldList = new ArrayList<String>();
		for (int i = 0; i < arrayFields.length; i++) {
			fieldList.add(Util.checkType(arrayFields[i], types.get(i)));
		}
		record.setFields(fieldList);
	}

	public void readNamesOfFields(Table entity) {
		String fieldNames[] = Constants.FIELDS_NAME
				.split(Constants.FIELDS_SEPARATOR);
		List<String> fieldList = new ArrayList<String>();
		for (String name : fieldNames) {
			fieldList.add(name);
		}
		entity.setNameFields(fieldList);
	}

	public void readTypesOfFields(Table entity) {
		String fieldTypes[] = Constants.TYPES.split(Constants.FIELDS_SEPARATOR);
		List<String> typeFieldList = new ArrayList<String>();
		for (String type : fieldTypes) {
			typeFieldList.add(type);
		}
		entity.setTypeFields(typeFieldList);
	}

	public StringBuilder getSQL(Table entity, Record record) throws Exception {
		StringBuilder Sql = new StringBuilder();
		Sql.append(Constants.INSERT).append(" ").append(Constants.TABLE_NAME)
				.append("(");
		appendListBySeparator(entity.getNameFields(), Sql);
		Sql.append(") ").append(Constants.VALUES).append("(");
		appendListBySeparator(record.getFields(), Sql);
		Sql.append(");").append("\n");
		return Sql;
	}

	public void appendListBySeparator(List<String> list, StringBuilder Sql)
			throws Exception {
		for (int i = 0; i < list.size(); i++) {
			if (list.size() - 1 == i) {
				Sql.append(list.get(i));
			} else {
				Sql.append(list.get(i)).append(",");
			}
		}
	}

	public void closeBuffer(BufferedReader buffer) {
		try {
			if (buffer != null)
				buffer.close();
		} catch (IOException ioException) {
			System.out.println(ioException.getMessage());
		}
	}

}
