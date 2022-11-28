package com.web.repository;

import com.web.entities.Label;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILabelRepository extends JpaRepository<Label, Long> {
}
