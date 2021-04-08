package com.trading.app.model;


public class Message {
	
	public String messageString;
	private static final char FIELD_SEPARATOR = '\001';
	
	public String getString(int tag) {
		String value = null;
        final String tagString = Integer.toString(tag);
        int start = messageString.indexOf(tagString, 0);
        value = getValue(start, value, tagString);
        return value;
	}
	public Double getDouble(int tag) {
		String value = null;
        final String tagString = Integer.toString(tag);
        int start = messageString.indexOf(tagString, 0);
         value = getValue(start, value, tagString);
        return Double.parseDouble(value);
	}
	public Integer getInt(int tag) {
		String value = null;
        final String tagString = Integer.toString(tag);
        int start = messageString.indexOf(tagString, 0);
        value = getValue(start, value, tagString);
        return Integer.parseInt(value);
	}
	
	
	private String getValue(int start,String value,String tagString) {
		 while (start != -1 && value == null) {
	            if ((start == 0 || messageString.charAt(start - 1) == FIELD_SEPARATOR)) {
	                int end = start + tagString.length();
	                if ((end + 1) < messageString.length() && messageString.charAt(end) == '=') {
	                    // found tag, get value
	                    start = end = (end + 1);
	                    while (end < messageString.length()
	                            && messageString.charAt(end) != FIELD_SEPARATOR) {
	                        end++;
	                    }
	                    if (end == messageString.length()) {
	                        return null;
	                    } else {
	                        value = messageString.substring(start, end);
	                    }
	                }
	            }
	            start = messageString.indexOf(tagString, start + 1);
	        }
		 return value;
	}
	
}
