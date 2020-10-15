package service.impl;

import domaine.Member;
import repository.MemberRepository;
import service.MemberService;

import javax.inject.Inject;
import javax.inject.Singleton;
import javax.transaction.Transactional;


@Singleton
@Transactional
public class MemberServiceImpl implements MemberService {


    private final MemberRepository memberRepository;

    @Inject
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    @Override
    public Member addMember(Member member) {
        Member member1 = new Member();
        member1 = memberRepository.save(member);
        return member1;
    }
}
