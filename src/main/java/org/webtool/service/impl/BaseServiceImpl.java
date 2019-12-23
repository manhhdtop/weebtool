package org.webtool.service.impl;

import cz.jirutka.rsql.parser.RSQLParser;
import cz.jirutka.rsql.parser.RSQLParserException;
import cz.jirutka.rsql.parser.ast.ComparisonOperator;
import cz.jirutka.rsql.parser.ast.Node;
import cz.jirutka.rsql.parser.ast.RSQLOperators;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.Modifying;
import org.webtool.Utils.MapperUtil;
import org.webtool.Utils.StringUtil;
import org.webtool.model.base.BaseModel;
import org.webtool.repository.base.CustomRepository;
import org.webtool.service.BaseService;
import org.webtool.service.impl.rsql.CustomRsqlVisitor;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Slf4j
public abstract class BaseServiceImpl<T extends BaseModel> implements BaseService<T> {

  abstract CustomRepository<T, String> getRepository();

  @Override
  @Modifying
  @Transactional
  public T create(T d) {
    log.info("(create)id: {}, type: {}, object: {}", d.getId(), d.getClass(), d);
    return getRepository().save(d);
  }

  @Override
  @Modifying
  @Transactional
  public T createNow(T d) {
    log.info("(createNow)id: {}, type: {}, object: {}", d.getId(), d.getClass(), d);
    return getRepository().saveAndFlush(d);
  }

  @Override
  @Modifying
  @Transactional
  public T update(String id, T d) {
    log.info("(update)id: {}, type: {}, object: {}", id, d.getClass(), d);
    Optional<T> opt = getRepository().findById(id);
    if (opt.isPresent()) {
      T oldObject = opt.get();
      MapperUtil.getModelMapper().map(d, oldObject);
      return getRepository().save(oldObject);
    }
    return null;
  }

  @Override
  @Modifying
  @Transactional
  public T updateNow(String id, T d) {
    log.info("(updateNow)id: {}, type: {}, object: {}", id, d.getClass(), d);
    return getRepository().save(d);
  }

  @Override
  public void delete(String id) {
    log.info("(delete)id: {}", id);
    T entity = findById(id);
    entity.setDeleted(1);
    getRepository().save(entity);
  }

  @Override
  public T find(String filter) {
    log.info("(find)filter: {}", filter);
    Page<T> results = find(filter, PageRequest.of(0, 1));
    if (results.hasContent()) {
      return results.getContent().get(0);
    }

    return null;
  }

  @Override
  public T findById(String id) {
    log.info("(findById)id: {}", id);
    if (id == null) {
      return null;
    }
    return getRepository().findById(id).orElse(null);
  }

  @Override
  public T findByIdWithLock(String id, Class<T> tClass) {
    log.info("(findByIdWithLock)id: {}", id);
    if (id == null) {
      return null;
    }
    return getRepository().findByIdWithLock(id, tClass);
  }

  @Override
  public T findOneByField(String field, Object value) {
    log.info("(findOneByField)field: {}, value: {}", field, value);
    List<T> results = findByField(field, value);
    if (results.isEmpty()) {
      return null;
    }

    return results.get(0);
  }

  @Override
  public List<T> findByIds(List<String> ids) {
    log.info("(findByIds)ids: {}", ids);
    Node rootNode = new RSQLParser().parse("id=in=(" + StringUtil.toRaw(ids) + ")");
    Specification<T> spec = rootNode.accept(new CustomRsqlVisitor<>());
    return getRepository().findAll(spec);
  }

  @Override
  public Page<T> find(Pageable pageable) {
    log.info("(find)pageable: {}", pageable);
    return getRepository().findAll(pageable);
  }

  @Override
  public List<T> find() {
    log.info("(find)");
    return getRepository().findAll();
  }

  @Override
  public Page<T> find(String filter, Pageable pageable) {
    log.info("(find)filter: {}, pageable: {}", filter, pageable);

    try {
      Set<ComparisonOperator> operators = RSQLOperators.defaultOperators();
      operators.add(new ComparisonOperator("=isnull=", true));
      Node rootNode = new RSQLParser(operators).parse(filter);

      log.info("(find)root node: {}", rootNode);
      Specification<T> spec = rootNode.accept(new CustomRsqlVisitor<>());
      return getRepository().findAll(spec, pageable);
    } catch (RSQLParserException ex) {
      log.error("(find)filter: {}, pageable: {}, ex: {}", filter, pageable, ex.getMessage());
      return null;
    }
  }

  @Override
  public List<T> findByField(String field, Object value) {
    log.info("(findByField)field: {}, value: {}", field, value);
    Node rootNode = new RSQLParser().parse(field + "==" + value);
    Specification<T> spec = rootNode.accept(new CustomRsqlVisitor<>());
    return getRepository().findAll(spec);
  }

  @Override
  public List<T> findByField(String field, List<Object> values) {
    log.info("(findByField)field: {}, value: {}", field, values);
    Node rootNode = new RSQLParser().parse(field + "=in=" + values);
    Specification<T> spec = rootNode.accept(new CustomRsqlVisitor<>());
    return getRepository().findAll(spec);
  }

  @Override
  public Page<T> findByField(String field, Object value, Pageable pageable) {
    log.info("(findByField)field: {}, value: {}, pageable: {}", field, value, pageable);
    Node rootNode = new RSQLParser().parse(field + "==" + value);
    Specification<T> spec = rootNode.accept(new CustomRsqlVisitor<>());
    return getRepository().findAll(spec, pageable);
  }

  @Override
  public Page<T> findByIds(List<String> ids, Pageable pageable) {
    log.info("(findByIds)ids: {}, pageable: {}", ids, pageable);
    Node rootNode = new RSQLParser().parse("id=in=(" + StringUtil.toRaw(ids) + ")");
    Specification<T> spec = rootNode.accept(new CustomRsqlVisitor<>());
    return getRepository().findAll(spec, pageable);
  }

  @Override
  public long count() {
    log.info("(count)");
    return getRepository().count();
  }
}
