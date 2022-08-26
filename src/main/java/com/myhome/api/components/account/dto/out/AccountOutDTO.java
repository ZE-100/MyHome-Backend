package com.myhome.api.components.account.dto.out;

import com.myhome.api.components.house.entity.House;
import com.myhome.api.components.member.entity.Member;
import com.myhome.api.util.Response;
import com.myhome.util.annotation.OutDTO;
import lombok.*;

import java.util.Set;

@OutDTO
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AccountOutDTO extends Response {

	private Integer id;

	private String email;

	private String token;

	private Set<House> houses;

	private Set<Member> members;
}
