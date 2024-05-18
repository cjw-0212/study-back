package com.itheima.validation;

import org.passay.*;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.Arrays;

//String为校验的类型
public class MyPasswordValidator implements ConstraintValidator<MyPasswordConstraint, String> {
    @Override
    //初始化校验消息，可得到配置的注解内容
    public void initialize(MyPasswordConstraint myPasswordConstraint) {
    }

    @Override
    public boolean isValid(String password, ConstraintValidatorContext validatorContext) {
        PasswordValidator validator = new PasswordValidator(Arrays.asList(
                //密码长度为8到30位
                new LengthRule(8, 30)
                //new LengthRule(8, 30),
                //至少有一个英文的大写字母
                //new CharacterRule(EnglishCharacterData.UpperCase, 1),
                //至少有一个英文的小写字母
                //new CharacterRule(EnglishCharacterData.LowerCase, 1),
                //至少有一个英文的特殊字符
                //new CharacterRule(EnglishCharacterData.Special, 1),
                //不允许有5个连续的英文字母
                //new IllegalSequenceRule(EnglishSequenceData.Alphabetical, 5, false),
                //不允许有5个连续的数字
                //new IllegalSequenceRule(EnglishSequenceData.Numerical, 5, false),
                //不允许有5个键盘连续的字母
                //new IllegalSequenceRule(EnglishSequenceData.USQwerty, 5, false),
                //需要有空格
                //new WhitespaceRule()
        ));
        RuleResult result = validator.validate(new PasswordData(password));
        return result.isValid();
    }
}
