package com.myspring.pro30.member.dao;

import java.util.List;

import org.springframework.dao.DataAccessException;

import com.myspring.pro30.member.vo.MemberVO;


public interface MemberDAO {
	 public List selectAllMemberList() throws DataAccessException; //전체 회원 정보 조회
	 public int insertMember(MemberVO memberVO) throws DataAccessException ; //회원가입
	 public int deleteMember(String id) throws DataAccessException; //회원 삭제
	 public MemberVO loginById(MemberVO memberVO) throws DataAccessException; //로그인

}
