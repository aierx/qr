package icu.aierx.elasticsearch.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author leiwenyong
 * @since 2022/3/18
 */
@Entity
@Table(name = "db_good")
@Getter
@Setter
public class Good extends CommonEntity{

    @GeneratedValue
    @Id
    private Long goodId;
    @NotNull(message = "商品名不能为空")
    private String goodName;
    @NotNull(message = "单价不能为空")
    private String goodPrice;
    private String orderId;
    @ManyToMany
    @JoinTable
    private List<Order> orders;
}
