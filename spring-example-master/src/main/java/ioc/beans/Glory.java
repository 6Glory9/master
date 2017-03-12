package ioc.beans;

import com.yjf.common.util.ToString;

import java.io.Serializable;

/**
 * Created by jxilong on 2016/3/19.
 *
 * 根据方法来注入有三种方式,spring只支持1和2
 * 1.构造方法
 * 2.属性方法
 * 3.接口注入
 */
public class Glory implements Serializable{

    private static final long serialVersionUID = 4221652280753159444L;

    private String name;

    private Integer age;


    private Tracy wife;


    public Glory() {
    }

    public Glory(Tracy wife) {
        this.wife = wife;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }


    public Tracy getWife() {
        return wife;
    }

    public void setWife(Tracy wife) {
        this.wife = wife;
    }

    @Override
    public String toString() {
        return ToString.toString(this);
    }
}
