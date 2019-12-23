package org.webtool.repository;

import org.springframework.stereotype.Repository;
import org.webtool.model.Post;
import org.webtool.repository.base.CustomRepository;

@Repository
public interface PostRepository extends CustomRepository<Post, String> {}
