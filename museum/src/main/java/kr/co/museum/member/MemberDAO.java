package kr.co.museum.member;

import javax.inject.Inject;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {
	@Inject
	private SqlSessionTemplate mybatis;

	public MemberVO login(MemberVO vo) {
		return mybatis.selectOne("member_sql.SELECT_MEMBER", vo);
	}
}
