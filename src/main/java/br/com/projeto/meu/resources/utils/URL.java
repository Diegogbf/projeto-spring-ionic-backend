package br.com.projeto.meu.resources.utils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.List;

public class URL {

	public static String decodeParam(String s) {
		try {
			return URLDecoder.decode(s, "UTF-8");
		} 
		catch (UnsupportedEncodingException e) {
			return "";
		}
	}	
	
	public static List<Integer> decodeIntList(String n){
		String[] vet = n.split(",");
		List<Integer> lista = new ArrayList<>();
		for(String idx: vet) {
			lista.add(Integer.parseInt(idx));
		}
		return lista;
		//return Arrays.asList(s.split(",")).stream().map(x -> Integer.parseInt(x)).collect(Collectors.toList());
	}
}
