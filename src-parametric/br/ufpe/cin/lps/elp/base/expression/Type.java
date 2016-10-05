package br.ufpe.cin.lps.elp.base.expression;

public interface Type<V> {
	
	public V add(V t);
	
	public V minus(V t);
	
	public V times(V t);
	
	public V getInstance(String s);
	
	public V div(V t);
	
	public String getString();
}
