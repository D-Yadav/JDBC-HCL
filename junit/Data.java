package com.hcl.junit;

import java.util.HashMap;
import java.util.Map;

public class Data {
	
	public String getproperty(String key){
		Map<String,String> m=new HashMap<String,String>()
			m.put("Min","Xun");
			m.put("lun","Nun");
			m.put("Gix","ziun");
			m.put("xing","Pzian");
			return m.get(key);
	}
	public boolean even(int x){
		if(x%2==0){
			return true;
		}else{
			return false;
		}
			
	}
	public int minArray(int[] x){
		int min=x[0];
		for(int i=0;i<x.length;i++){
			if(min > x[i])
				min=x[i];
	}
	return min;
	}
	public int max3(int a, int b, int c){
		int m=a;
		if(m<b){
			m=b;
		}
		if(m<c){
			m=c;
		}
		return m;
	}
	public int sum(int a, int b){
		return a+b;
	}
public String sayhello(){
	return"welcome to junit.....";
}
}
