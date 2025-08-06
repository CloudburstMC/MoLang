package com.bedrockk.molang.runtime.value;

public class StringValue implements MoValue {

    public String value;

    public StringValue(String value) {
        this.value = value;
    }

    @Override
    public String value() {
        return value;
    }

    @Override
    public String asString() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        return super.equals(obj) || (obj instanceof StringValue && ((StringValue)obj).asString().equals(value)) || (obj instanceof DoubleValue && ((DoubleValue)obj).asString().equals(value));
    }

    @Override
    public String toString() {
        return this.asString();
    }
}
