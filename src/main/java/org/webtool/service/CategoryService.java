package org.webtool.service;

import org.webtool.model.Category;

import java.util.List;

public interface CategoryService extends BaseService<Category> {

  List<Category> findMenu();
}
