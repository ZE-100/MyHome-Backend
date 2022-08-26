package com.myhome.api.components.token.dto.in;

import com.myhome.util.annotation.InDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@InDTO
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenInDTO {

	private String token;

	private Date createdAt;

	private String deviceSalt;
}
