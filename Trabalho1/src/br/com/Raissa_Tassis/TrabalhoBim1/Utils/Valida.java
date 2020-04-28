package br.com.Raissa_Tassis.TrabalhoBim1.Utils;

import br.com.Raissa_Tassis.TrabalhoBim1.Controle.ControleException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Valida {
    
    public boolean validaCpf(String cpf){
        cpf = cpf.replace("-", "");
	cpf = cpf.replace(".", "");

	if (cpf.length() != 11) {
            return false;
	}
	// primeiro dígito
	int soma = 0;
	int prod = 10;
	for (int j = 0; j < 9; j++) {
            String digitoS = String.valueOf(cpf.charAt(j)); // ou cpf.charAt(j)
                						// + "";
            int digito = Integer.parseInt(digitoS);
            soma = soma + (digito * prod);
            prod--;
	}
	int resto = soma % 11;
	int primV = 0;

        if (resto >= 2) {
            primV = 11 - resto;
	}
	// segundo dígito
	soma = 0;
	prod = 11;
	for (int j = 0; j < 10; j++) {
            String digitoS = String.valueOf(cpf.charAt(j));
            int digito = Integer.parseInt(digitoS);
            soma = soma + (digito * prod);
            prod--;
	}
	resto = soma % 11;
	int segV = 0;

        if (resto >= 2) {
            segV = 11 - resto;
	}
        
	if (primV == Integer.parseInt(cpf.charAt(9) + "") && segV == Integer.parseInt(cpf.charAt(10) + "")) {
            return true;
	}
	return false;
    }
    
    public boolean validaEmail(String email){
        boolean isEmailIdValid;
        isEmailIdValid = false;
        if (email != null && email.length() > 0) {
            String expression = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
            Pattern pattern = Pattern.compile(expression, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if (matcher.matches()) {
                isEmailIdValid = true;
            }
        }
        return isEmailIdValid;
//        return (email.contains("@"));

    }
    
    public boolean validaCep(String cep) throws ControleException{
        if(cep.length() == 8){
            try{
                int parseInt = Integer.parseInt(cep);
                return true;
            } catch(NumberFormatException nfe){
                throw new ControleException("CEP inválido");
            }
         } else
            return false;
            
    }
}

