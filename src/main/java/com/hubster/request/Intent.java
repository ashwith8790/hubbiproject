package com.hubster.request;

import java.util.Map;

/*import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
*/
public class Intent {

	  String name;
	    Map<String, String> slots;

	    public String getName() {
	        return name;
	    }

	    public void setName(String name) {
	        this.name = name;
	    }

	    public Map<String, String> getSlots() {
	        return slots;
	    }

	    public void setSlots(Map<String, String> slots) {
	        this.slots = slots;
	    }

	   /* @Override
	    public String toString() {
	        try {
	            return new ObjectMapper().writeValueAsString(this);
	        } catch (JsonProcessingException e) {
	            e.printStackTrace();
	        }

	        return null;
	}*/
}
