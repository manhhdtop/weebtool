package org.webtool.model.base;

import lombok.Data;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.UUID;

@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class BaseModel extends AdvanceModel {
  @Id
  @Column(name = "id")
  private String id;

  @Column(name = "name")
  private String name;

  @Column(name = "deleted")
  private Integer deleted = 0;

  @PrePersist
  private void ensureId() {
    this.setId(UUID.randomUUID().toString());
  }
}
