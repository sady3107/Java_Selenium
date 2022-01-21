package com.tcs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Repeated_P 
{
	public static void main(String[] args) 
	{
		String s = "by the people of the people for the people";
		String[] words = s.split(" ");
		Map<String, Integer> m = new LinkedHashMap<String, Integer>();

		for (String word : words) 
		{
			if (m.containsKey(word)) 
			{
				Integer value = m.get(word);
				m.put(word, value + 1);
			} 
			else 
			{
				m.put(word, 1);
			}
		}
		System.out.println(m);
		Set<Entry<String, Integer>> entries = m.entrySet();
		for (Entry<String, Integer> entry : entries) 
		{
			if (entry.getValue() > 1) {
				System.out.println(entry);
			}
		}
	}
}
