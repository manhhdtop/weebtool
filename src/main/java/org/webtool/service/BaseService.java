package org.webtool.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BaseService<T> {
  T create(T t);

  T createNow(T t);

  T update(String id, T t);

  T updateNow(String id, T t);

  void delete(String id);

  T find(String filter);

  T findById(String id);

  T findByIdWithLock(String id, Class<T> tClass);

  T findOneByField(String field, Object value);

  List<T> findByIds(List<String> ids);

  List<T> find();

  Page<T> find(Pageable pageable);

  Page<T> find(String filter, Pageable pageable);

  List<T> findByField(String field, Object value);

  List<T> findByField(String field, List<Object> values);

  Page<T> findByField(String field, Object value, Pageable pageable);

  Page<T> findByIds(List<String> ids, Pageable pageable);

  long count();
}
