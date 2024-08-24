package com.hackseoul.aiwedding.wedding.mypage.service;

import com.hackseoul.aiwedding.wedding.mypage.model.entity.MemberEntity;
import com.hackseoul.aiwedding.wedding.mypage.model.request.LoginRequest;
import com.hackseoul.aiwedding.wedding.mypage.model.response.LoginResponse;
import com.hackseoul.aiwedding.wedding.mypage.repository.LoginRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

    private final LoginRepository loginRepository;

    @Override
    public LoginResponse.loginResponse loginAction(LoginRequest.loginRequest loginRequest) {
        LoginResponse.loginResponse result = new LoginResponse.loginResponse();
        if(loginRepository.countByMemberId(loginRequest.getMember_id()) > 0) {
            Optional<MemberEntity> memberEntity =loginRepository.findByMemberIdAndMemberPw(loginRequest.getMember_id(), loginRequest.getMember_pw());
            if(memberEntity.isPresent()) {
                result.setCode("0000");
                result.setMember_seq(memberEntity.get().getMemberSeq());
            } else {
                result.setCode("1000");
            }
        } else {
            // insert 하는 부분
            MemberEntity member = new MemberEntity(loginRequest);
            MemberEntity saveMember = loginRepository.save(member);
            result.setCode("0000");
            result.setMember_seq(saveMember.getMemberSeq());
        }
        return result;
    }
}
