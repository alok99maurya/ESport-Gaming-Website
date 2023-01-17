package com.esport.gamics.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.esport.gamics.entity.Blogs;

@Repository
public interface BlogsRepo extends JpaRepository<Blogs, Integer>{

}
