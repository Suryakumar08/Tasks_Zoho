package tasks;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import exception.CustomException;
import validators.Validators;

public class HashMapTask  {

	public<K, V> Map<K, V> getHashMap(Map<K, V> map) {
		return new HashMap<>(map);
	}

	public <K, V>Map<K, V> getHashMap() {
		return new HashMap<K, V>();
	}

	public <K, V>int getMapSize(Map<K, V> map) {
		return map.size();
	}

	public <K, V>void putInputInMap(Map<K, V> map, K key, V value) throws CustomException {
		Validators.isNullInput(map);
		map.put(key, value);
	}

	public <K, V>boolean isKeyPresent(Map<K, V> map, K key) throws CustomException {
		Validators.isNullInput(map);
		return map.containsKey(key);
	}

	public <K, V>boolean isValuePresent(Map<K, V> map, K key) throws CustomException {
		Validators.isNullInput(map);
		return map.containsValue(key);
	}

	public <K, V>void replaceAllValues(Map<K, V> map, V input) throws CustomException {
		Validators.isNullInput(map);
		map.replaceAll((K, V) -> input);
	}

	public <K, V>V getValueFromKey(Map<K, V> map, K key) throws CustomException {
		Validators.isNullInput(map);
		return map.get(key);
	}

	public <K, V>V getValueOrDefault(Map<K, V> map, K keyToFind, V defaultValue) throws CustomException {
		Validators.isNullInput(map);
		return map.getOrDefault(keyToFind, defaultValue);
	}

	public<K, V> V removeEntry(Map<K, V> map, K keyToRemove) throws CustomException {
		Validators.isNullInput(map);
		return map.remove(keyToRemove);
	}

	public <K, V>boolean removeEntryOnCondition(Map<K, V> map, K keyToRemove, V toCheck) throws CustomException {
		Validators.isNullInput(map);
		return map.remove(keyToRemove, toCheck);
	}

	public <K, V>void replaceValue(Map<K, V> map, K key, V newValue) throws CustomException {
		Validators.isNullInput(map);
		map.replace(key, newValue);
	}

	public <K, V>boolean replaceValueOnCondition(Map<K, V> map, K key, V oldValue, V newValue) throws CustomException {
		Validators.isNullInput(map);
		return map.replace(key, oldValue, newValue);
	}

	public <K, V>Iterator<Map.Entry<K, V>> getIterator(Map<K, V> map) throws CustomException {
		Validators.isNullInput(map);
		Iterator<Map.Entry<K, V>> iterator = map.entrySet().iterator();
		return iterator;
	}

	public <K, V>void removeAllEntries(Map<K, V> map) throws CustomException {
		Validators.isNullInput(map);
		map.clear();
	}

}
