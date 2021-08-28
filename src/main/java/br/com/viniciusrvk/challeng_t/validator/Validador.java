package br.com.viniciusrvk.challeng_t.validator;

public interface Validador<T> {

	public Validador<T> validar(T fullName);
}
