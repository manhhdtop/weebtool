package org.webtool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.webtool.model.base.BaseModel;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;

@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Where(clause = "deleted is null or deleted = 0")
public class Post extends BaseModel {
  @NotNull
  @Column(name = "description")
  private String description;

  @NotNull
  @Column(name = "content")
  private String content;

  @NotNull
  @Column(name = "slug")
  private String slug;

  @NotNull
  @Column(name = "category_id")
  private String categoryId;

  @Transient private ArrayList<Tag> tags;
}
