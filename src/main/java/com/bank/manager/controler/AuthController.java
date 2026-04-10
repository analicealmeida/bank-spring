package com.bank.manager.controler;


import com.bank.manager.dto.LoginDTO;
import com.bank.manager.security.JwtUtil;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {
    private final JwtUtil jwtUtil;

    public AuthController(JwtUtil jwtUtil) {
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody LoginDTO dto) {

        // simulação de autenticação
        if (dto.username().equals("admin")
                && dto.password().equals("123")) {

            return jwtUtil.generateToken(dto.username());
        }

        throw new RuntimeException("Usuário inválido");
    }

    @GetMapping("/teste")
    public String teste(){

        return "endpoint protegido funcionando";
    }


}
