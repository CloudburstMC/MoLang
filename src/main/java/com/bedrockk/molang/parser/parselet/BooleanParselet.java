package com.bedrockk.molang.parser.parselet;

import com.bedrockk.molang.Expression;
import com.bedrockk.molang.ast.BooleanExpression;
import com.bedrockk.molang.parser.MoLangParser;
import com.bedrockk.molang.parser.PrefixParselet;
import com.bedrockk.molang.parser.tokenizer.Token;
import com.bedrockk.molang.runtime.value.DoubleValue;

public class BooleanParselet implements PrefixParselet {

    @Override
    public Expression parse(MoLangParser parser, Token token) {
        return new BooleanExpression(Boolean.parseBoolean(token.getText()));
    }
}
