package com.cnu.taleteller.backend.domain.tool.repository;

import com.cnu.taleteller.backend.domain.tool.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PageRepository extends JpaRepository<Page, Long> {
}