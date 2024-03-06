package br.com.efb.domain.security;

import br.com.efb.domain.excepition.SenhaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class MyAutenticationUser implements UserDetailsService {

    @Autowired
    private PasswordEncoder encoder;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        String use = "test";
        String useSenha = "teste";
        if (use == null){
            throw new UsernameNotFoundException("Usuario não Existe na Base");
        }
        return User.builder()
                .username(use)
                .password(encoder.encode(useSenha))
                .authorities("ROLE_ADM","ROLE_USER")
                .build();
    }

    public UserDetails autenticar(String usuario){
        UserDetails userDetails = loadUserByUsername(usuario);
        boolean senhaok = encoder.matches(usuario, userDetails.getPassword());
        if (senhaok){
            return userDetails;
        }
        throw new SenhaException();
    }
}
