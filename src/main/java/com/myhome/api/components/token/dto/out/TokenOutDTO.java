package com.myhome.api.components.token.dto.out;

import com.myhome.api.components.token.entity.Token;
import com.myhome.util.annotation.OutDTO;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@OutDTO
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TokenOutDTO {

	private String token;

	private Token createdAt;
}
