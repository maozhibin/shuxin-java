package com.baoquan.shuxin.model.config;

public class Config {
	  private Integer id;

	    private String varname;

	    private String memo;

	    private String rules;

	    private String value;
	    
	    private Boolean isValid;
	    
		public Boolean getIsValid() {
			return isValid;
		}

		public void setIsValid(Boolean isValid) {
			this.isValid = isValid;
		}

		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getVarname() {
			return varname;
		}

		public void setVarname(String varname) {
			this.varname = varname;
		}

		public String getMemo() {
			return memo;
		}

		public void setMemo(String memo) {
			this.memo = memo;
		}

		public String getRules() {
			return rules;
		}

		public void setRules(String rules) {
			this.rules = rules;
		}

		public String getValue() {
			return value;
		}

		public void setValue(String value) {
			this.value = value;
		}

	   
}
