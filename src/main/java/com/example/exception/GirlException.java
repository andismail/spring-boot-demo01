package com.example.exception;

import com.example.enums.ResultEnum;

/**
 * 继承RuntimeException而不是Exception是因为说是Spring对Exception不回滚
 * <p>此处另一个知识点是,子类与父类属性之间的关系
 * 如message属性,本来是可以在这个类中声明个<code>private String message;</code>
 * 但,父类中有这个属性,也就是说子类中也有这个属性,但父类中的是private的,但父类中提供了
 * <code>public String getMessage()</code>方法,也就是说我们把自己的message
 * 赋值给父类中的message属性(也就是子类的message属性)就可以,但,父类中并没有setMessage的方法,
 * 但,但,但,父类中有个构造方法可以给message赋值,这样getMessage()就可以取到值了
 * </p>
 * 对于这一点,其实也说明了是对构造方法的使用不熟练,子类与父类之间有关系不太清楚
 * Created by Jthan on 17/8/20.
 */
public class GirlException extends RuntimeException {

    private Integer code;

    public GirlException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public GirlException(ResultEnum resultEnum) {
        super(resultEnum.getMsg());
        this.code = resultEnum.getCode();
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
