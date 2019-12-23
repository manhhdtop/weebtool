package org.webtool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webtool.model.Category;
import org.webtool.repository.CategoryRepository;
import org.webtool.repository.base.CustomRepository;
import org.webtool.service.CategoryService;

import java.util.List;

@Service
class CategoryServiceImpl extends BaseServiceImpl<Category> implements CategoryService {

  @Autowired private CategoryRepository repository;

  @Override
  CustomRepository<Category, String> getRepository() {
    return repository;
  }

  @Override
  public List<Category> findMenu() {
    return repository.findAllByShowInMenu(true);
  }
}
