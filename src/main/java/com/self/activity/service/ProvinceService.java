package com.self.activity.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.solr.repository.SolrCrudRepository;

import com.self.activity.vo.ProvinceForSolr;

public interface ProvinceService extends SolrCrudRepository<ProvinceForSolr, String>{
	public Page<ProvinceForSolr> findProvinceByProvinceNameStartingWithOrderByProvinceNameDesc(String context,Pageable page);
	public Page<ProvinceForSolr> findProvinceByProvinceCodeStartingWithOrderByProvinceNameDesc(String context,Pageable page);
	public Page<ProvinceForSolr> findProvinceByProvinceSpellNoStartingWithOrderByProvinceNameDesc(String context,Pageable page);
	public ProvinceForSolr save(ProvinceForSolr provinceForSolr);
	public void delete(String id);
}
