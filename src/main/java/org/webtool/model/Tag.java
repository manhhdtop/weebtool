package org.webtool.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.Where;
import org.webtool.model.base.ModelWithUpdate;

import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode
@NoArgsConstructor
@Where(clause = "deleted is null or deleted = 0")
public class Tag extends ModelWithUpdate {}
