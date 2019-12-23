package org.webtool.model.base;

import lombok.Data;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Column;
import javax.persistence.EntityListeners;
import javax.persistence.MappedSuperclass;

@Data
@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public class ModelWithUpdate extends BaseModel {
  @Column(name = "created_at")
  @CreatedDate
  private Long createdAt;

  @Column(name = "created_by")
  @CreatedBy
  private String createdBy;

  @Column(name = "updated_at")
  @LastModifiedDate
  private Long updatedAt;

  @Column(name = "updated_by")
  @LastModifiedBy
  private String updatedBy;
}
