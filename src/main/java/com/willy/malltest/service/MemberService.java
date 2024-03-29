package com.willy.malltest.service;

import com.willy.malltest.dto.MemberReDataDTO;

import java.util.List;

public interface MemberService {

    public List<MemberReDataDTO> getAllMemberReDTOs();

    public MemberReDataDTO getShowMemberReDTOs(Long userId);
}
