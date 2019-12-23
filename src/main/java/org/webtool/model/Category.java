package org.webtool.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.webtool.model.base.ModelWithUpdate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@AllArgsConstructor
@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Table(name = "category")
@Where(clause = "deleted is null or deleted = 0")
public class Category extends ModelWithUpdate {

  @NotNull
  @Column(name = "slug", unique = true)
  private String slug;

  @Column(name = "description")
  private String description;

  @Column(name = "parent_id")
  private String parentId;

  @NotNull
  @Column(name = "show_in_menu")
  private Boolean showInMenu;
}
