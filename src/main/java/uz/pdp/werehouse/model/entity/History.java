package uz.pdp.werehouse.model.entity;

import jakarta.persistence.Entity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import uz.pdp.werehouse.model.base.BaseEntity;

@Getter
@Setter
@Entity
@ToString
public class History extends BaseEntity {
    private String tableName;
    private String actionType;
    private String entityId;
    private String newValue;
}