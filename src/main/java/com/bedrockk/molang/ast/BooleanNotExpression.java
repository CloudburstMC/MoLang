package com.bedrockk.molang.ast;

import com.bedrockk.molang.Expression;
import com.bedrockk.molang.StringHolder;
import com.bedrockk.molang.runtime.MoLangEnvironment;
import com.bedrockk.molang.runtime.MoScope;
import com.bedrockk.molang.runtime.value.DoubleValue;
import com.bedrockk.molang.runtime.value.MoValue;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import lombok.Value;

@Value
@ToString
@EqualsAndHashCode(callSuper = true)
public class BooleanNotExpression extends StringHolder implements Expression {

    Expression expression;

    @Override
    public MoValue evaluate(MoScope scope, MoLangEnvironment environment) {
        return expression.evaluate(scope, environment).equals(DoubleValue.ONE) ? DoubleValue.ZERO : DoubleValue.ONE;
    }
}
