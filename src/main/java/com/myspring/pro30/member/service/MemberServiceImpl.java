package com.myspring.pro30.member.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.myspring.pro30.member.dao.MemberDAO;
import com.myspring.pro30.member.vo.MemberVO;



@Service("memberService")
@Transactional(propagation = Propagation.REQUIRED)
public class MemberServiceImpl implements MemberService {
	@Autowired
	private MemberDAO memberDAO;

	@Override
	public List listMembers() throws DataAccessException {
		List membersList = null;
		membersList = memberDAO.selectAllMemberList();
		//DAO의 selectAllMemberList 메소드로 회원 전체의 정보를 가져온다.
		return membersList;
	}

	@Override
	public int addMember(MemberVO member) throws DataAccessException {
		//입력받은 정보를 DAO의 회원가입 메소드로 전달한다.
		return memberDAO.insertMember(member);
	}

	@Override
	public int removeMember(String id) throws DataAccessException {
		//삭제할 id를 DAO의 삭제 메소드로 전달한다.
		return memberDAO.deleteMember(id);
	}
	
	@Override
	public MemberVO login(MemberVO memberVO) throws Exception{
		//DAO의 로그인 메소드로 입력받은 정보를 전달한다.
		return memberDAO.loginById(memberVO);
	}

}
