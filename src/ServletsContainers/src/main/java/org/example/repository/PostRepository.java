package org.example.repository;

import org.example.model.Post;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class PostRepository {
  private final AtomicLong idCounter = new AtomicLong(0);
  private final Map<Long, Post> posts = new ConcurrentHashMap<>();

  public List<Post> all() {
    return new ArrayList<>(posts.values());
  }

  public Optional<Post> getById(long id) {
    return Optional.ofNullable(posts.get(id));
  }

  public Post save(Post post) {
    if (post.getId() == 0) {
      long id = idCounter.incrementAndGet();
      post.setId(id);
    }
    posts.put(post.getId(), post);
    return post;
  }

  public void removeById(long id) {
    posts.remove(id);
  }
}