package jp.co.axa.apidemo.entities;

import jp.co.axa.apidemo.common.Const;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * Employee Entity Class
 */
@Entity
@Table(name = Const.EMPLOYEE)
public class Employee implements Serializable {

    @Getter
    @Setter
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Getter
    @Setter
    @Column(name = Const.EMPLOYEE_NAME)
    private String name;

    @Getter
    @Setter
    @Column(name = Const.EMPLOYEE_SALARY)
    @Min(value = 100, message = Const.SALARY_LESS_THAN_100)
    @NotNull(message = Const.SALARY_IS_NOT_NULL)
    private Integer salary;

    @Getter
    @Setter
    @Column(name = Const.DEPARTMENT)
    private String department;
}
