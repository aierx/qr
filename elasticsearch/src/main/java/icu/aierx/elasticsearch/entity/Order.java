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
@Table(name="db_order")
@Getter
@Setter
public class Order extends CommonEntity{
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long orderId;

    @NotNull(message = "用户id不能为空")
    private String userId;

    @NotNull(message = "不能为空")
    private String orderNumber;

    @ManyToMany
    @JoinTable
    private List<Good> goods;

    @OneToOne
    @JoinColumn(name = "user",referencedColumnName = "userId")
    private User user;


}
