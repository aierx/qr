import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author leiwenyong
 * @since 2022/3/18
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private String name;
    private String sex;
    private Integer age;
}
