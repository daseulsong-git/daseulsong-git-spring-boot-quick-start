package com.multicampus.biz.keygen;

public interface KeyGenService {
	
	public String getNextPk(String tableName, String columnName) throws Exception;
}
