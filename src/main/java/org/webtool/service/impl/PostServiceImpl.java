package org.webtool.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webtool.model.Post;
import org.webtool.repository.base.CustomRepository;
import org.webtool.repository.PostRepository;
import org.webtool.service.PostService;

@Service
class PostServiceImpl extends BaseServiceImpl<Post> implements PostService {
  @Autowired PostRepository repository;

  @Override
  CustomRepository<Post, String> getRepository() {
    return repository;
  }
}
