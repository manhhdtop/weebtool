package org.webtool.repository;

import org.springframework.stereotype.Repository;
import org.webtool.model.Category;
import org.webtool.repository.base.CustomRepository;

import java.util.List;

@Repository
public interface CategoryRepository extends CustomRepository<Category, String> {
  List<Category> findAllByShowInMenu(Boolean showInMenu);
}
