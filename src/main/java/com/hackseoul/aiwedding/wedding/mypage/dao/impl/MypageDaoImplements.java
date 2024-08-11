package com.hackseoul.aiwedding.wedding.mypage.dao.impl;

import com.hackseoul.aiwedding.domain.repo.MeRepository;
import com.hackseoul.aiwedding.domain.repo.WishInfoRepository;
import com.hackseoul.aiwedding.wedding.mypage.dao.itfc.MypageDaoInterface;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class MypageDaoImplements
        implements MypageDaoInterface {

    private final MeRepository meRepository;

    private final WishInfoRepository wishInfoRepository;

    @Override
    public void createMypage() {

    }

    @Override
    public void readMypage() {
        meRepository.findAll();
        wishInfoRepository.findAll();
    }

    @Override
    public void updateMypage() {

    }

    @Override
    public void deleteMypage() {

    }
}
