package com.esfirst.Repo;
import java.util.Optional;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import com.esfirst.model.Staff;

@Repository
public interface StaffRepository extends ElasticsearchRepository<Staff, Integer>{

	Optional<Staff> findByEmail(String email);

}

