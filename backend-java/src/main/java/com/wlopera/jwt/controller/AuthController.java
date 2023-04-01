package com.wlopera.jwt.controller;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.wlopera.jwt.model.Data;
import com.wlopera.jwt.model.Login;
import com.wlopera.jwt.model.Response;
import com.wlopera.jwt.model.User;
import com.wlopera.jwt.repository.UserRepository;
import com.wlopera.jwt.util.Utility;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
public class AuthController {

	@Autowired
	UserRepository repository;

	@PostMapping("/login")
	public ResponseEntity<Response> login(@Valid @RequestBody Login login) {

		SimpleDateFormat format = new SimpleDateFormat("DD/mm/YYYY HH:mm:ss");
		String date = format.format(new Date());

		System.out.println("Usuario: " + login);

		User userDB = repository.findByName(login.getUsername());
		System.out.println("Usuario DB: " + userDB);

		if (login.getPassword().equals(userDB.getPassword())) {
			String token = getJWTToken(login.getUsername(), date);

			Data data = new Data();
			data.setId(userDB.getId());
			data.setName(userDB.getName());
			data.setToken(token);

			Response response = Utility.getResponse(data);

			System.out.println("Response: " + response);
			return ResponseEntity.status(HttpStatus.OK).body(response);
		}
		return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(null);
	}

	private String getJWTToken(String username, String date) {
		String secretKey = "mySecretKey";
		List<GrantedAuthority> grantedAuthorities = AuthorityUtils.commaSeparatedStringToAuthorityList("ROLE_USER");

		// Prueba para generar valores MD5 - dummy
		System.out.println("wlopera: " + getMD5("12345"));
		System.out.println("lmessi: " + getMD5("lmessi"));
		System.out.println("cr7: " + getMD5("cr7"));
		System.out.println("njunior: " + getMD5("njunior"));

		String token = Jwts.builder().setId("softtekJWT").setSubject(username)
				.claim("authorities",
						grantedAuthorities.stream().map(GrantedAuthority::getAuthority).collect(Collectors.toList()))
				.claim("Fecha", date).setIssuedAt(new Date(System.currentTimeMillis()))
				.setExpiration(new Date(System.currentTimeMillis() + 600000))
				.signWith(SignatureAlgorithm.HS512, secretKey.getBytes()).compact();

		return "Bearer " + token;
	}

	private String getMD5(String input) {
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			byte[] messageDigest = md.digest(input.getBytes());
			BigInteger number = new BigInteger(1, messageDigest);
			String hashtext = number.toString(16);

			while (hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			return hashtext;
		} catch (NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}

}
