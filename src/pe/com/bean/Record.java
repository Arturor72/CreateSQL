package pe.com.bean;

import java.io.Serializable;
import java.util.List;

public class Record implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> fields;


	public void setFields(List<String> fields) {
		this.fields = fields;
	}

	public List<String> getFields() {
		return fields;
	}


}
