package br.com.viniciusrvk.challeng_t.validator;

import org.springframework.stereotype.Component;

@Component
public class RegraNomeNaoNulo implements Rule{

	@Override
	public Boolean isValid(String fullName) {
		return fullName != null;
	}

}
