package com.neu.service;

import java.util.List;

import com.neu.entity.Storey;

public interface StoreyService {
	int add(Storey sto) throws Exception;
	Storey getId(String storey) throws Exception;
	int modify(Storey sto) throws Exception;
	int remove(String storey) throws Exception;
	List<Storey> getStorey(int pageSize,int pageNum) throws Exception;
	int number() throws Exception;
}
