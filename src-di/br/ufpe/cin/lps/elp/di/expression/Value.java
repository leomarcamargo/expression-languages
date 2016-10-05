package br.ufpe.cin.lps.elp.di.expression;

import br.ufpe.cin.lps.elp.di.expression.Expression;
import br.ufpe.cin.lps.elp.di.expression.Value;

public abstract class Value<T> implements Expression {

	private T value;

	public String toString() {
		return String.valueOf(value);
	}

	public Value(T value) {
		this.value = value;
	}

	public T value() {
		return value;
	}

	public boolean isEquals(Value<T> obj) {
		return value().equals(obj.value());

	}

	public Value evaluate() {
		return this;
	}

}
