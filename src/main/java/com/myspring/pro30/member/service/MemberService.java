package com.myspring.pro30.member.service;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro30.member.vo.MemberVO;

public interface MemberService {
	 public List listMembers() throws DataAccessException; //회원 전체 리스트
	 public int addMember(MemberVO memberVO) throws DataAccessException; //회원가입
	 public int removeMember(String id) throws DataAccessException; //회원 삭제
	 public MemberVO login(MemberVO memberVO) throws Exception; //회원 로그인
}
