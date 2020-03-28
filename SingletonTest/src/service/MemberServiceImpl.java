package service;

import dao.IMemberDao;
import dao.MemberDaoImpl;
import vo.MemberVO;

import java.util.List;

public class MemberServiceImpl implements IMemberService {

    //사용할 DAO의 객체변수를 선언한다.
    private IMemberDao memDao;

    private static IMemberService service;

    private MemberServiceImpl(){
        memDao = MemberDaoImpl.getInstance();
    }

    public static IMemberService getInstance(){
        if(service == null){
            service = new MemberServiceImpl();
        }
        return  service;
    }



    @Override
    public int insertMember(MemberVO mv) {
        return memDao.insertMember(mv);
    }

    @Override
    public boolean getMember(String memId) {
        return memDao.getMember(memId);
    }

    @Override
    public List<MemberVO> getAllMemberList() {
        return memDao.getAllMemberList();
    }

    @Override
    public int updateMember(MemberVO mv) {
        return memDao.updateMember(mv);
    }

    @Override
    public int deleteMember(String memId) {
        return memDao.deleteMember(memId);
    }
}
