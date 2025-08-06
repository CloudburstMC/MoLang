package com.bedrockk.molang.ast;

import com.bedrockk.molang.Expression;
import com.bedrockk.molang.StringHolder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@RequiredArgsConstructor
abstract public class BinaryOpExpression extends StringHolder implements Expression {

    protected final Expression left;
    protected final Expression right;

    public abstract String getSigil();
}
