package com.session.TestSession.config;

import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;

public class DefaultTestRequest implements TestRequest, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 167785396714496379L;

	private final MultiValueMap<String, String> parameters = new LinkedMultiValueMap<String, String>();

	private String currentUri;

	public DefaultTestRequest() {
	}

	public DefaultTestRequest(Map<String, String[]> parameters) {
		if (parameters != null) {
			for (Entry<String, String[]> entry : parameters.entrySet()) {
				this.parameters.put(entry.getKey(), Arrays.asList(entry.getValue()));
			}
		}
	}

	@Override
	public String getCode() {
		return getFirst("code");
	}

	public String getFirst(String key) {
		return parameters.getFirst(key);
	}

	public void add(String key, String value) {
		parameters.add(key, value);
	}

	public void set(String key, String value) {
		parameters.set(key, value);
	}

	public void setAll(Map<String, String> values) {
		parameters.setAll(values);
	}

	public Map<String, String> toSingleValueMap() {
		return parameters.toSingleValueMap();
	}

	public int size() {
		return parameters.size();
	}

	public boolean isEmpty() {
		return parameters.isEmpty();
	}

	public boolean containsKey(Object key) {
		return parameters.containsKey(key);
	}

	public boolean containsValue(Object value) {
		return parameters.containsValue(value);
	}

	public List<String> get(Object key) {
		return parameters.get(key);
	}

	public List<String> put(String key, List<String> value) {
		return parameters.put(key, value);
	}

	public List<String> remove(Object key) {
		return parameters.remove(key);
	}

	public void putAll(Map<? extends String, ? extends List<String>> m) {
		parameters.putAll(m);
	}

	public void clear() {
		parameters.clear();
	}

	public Set<String> keySet() {
		return parameters.keySet();
	}

	public Collection<List<String>> values() {
		return parameters.values();
	}

	public Set<java.util.Map.Entry<String, List<String>>> entrySet() {
		return parameters.entrySet();
	}

	public boolean equals(Object o) {
		return parameters.equals(o);
	}

	public int hashCode() {
		return parameters.hashCode();
	}

	public String toString() {
		return parameters.toString();
	}

	public String getCurrentUri() {
		return currentUri;
	}

	public void setCurrentUri(String currentUri) {
		this.currentUri = currentUri;
	}

}
