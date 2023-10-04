package com.nofacebox.viewshow.Servic;

import com.nofacebox.viewshow.Entity.LinkPk;
import com.nofacebox.viewshow.Entity.Session;
import com.nofacebox.viewshow.Model.ResponseVo;
import com.nofacebox.viewshow.Model.SessionDto;
import com.nofacebox.viewshow.Repository.SessionRepositary;
import com.nofacebox.viewshow.Servic.Interface.ISessionService;
import com.nofacebox.viewshow.Utils.IgnoreNullMapper;
import com.nofacebox.viewshow.Utils.NativeQueryConverter;
import org.aspectj.weaver.Utils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


@Service
public class SessionService implements ISessionService {
    @Autowired
    SessionRepositary sessionRepositary;


    @Override
    public Session getSession(Long id) throws Exception {
        return sessionRepositary.findById(id).orElseThrow(() -> new Exception("not found"));
    }

    @Override
    public Session saveSession(Session saveItem) throws Exception {
        return sessionRepositary.save(saveItem);
    }


    @Override
    public Session modifySession(Session modify,LinkPk linkPk) throws Exception {
        //Only those values existed (not null) in param(modify) mapping to persistant entity(old)
        Session old = sessionRepositary.findById(modify.getSid()).orElseThrow(() -> new Exception("not found"));
        IgnoreNullMapper.myCopyProperties(modify,old);
        old.setLinkPk(linkPk);
//        s.setAvasession(modify.getAvasession());
//        s.setHall(modify.getHall());
//        s.setAvadate(modify.getAvadate());

        return sessionRepositary.save(old);
    }

    @Override
    public ResponseVo deleteSession(Long id) {
        ResponseVo res = new ResponseVo();
        if (sessionRepositary.findById(id).isPresent()) {
            sessionRepositary.deleteById(id);
            res.setMessage("OK");
        } else {
            res.setMessage("FAILED");
        }
        return res;
    }

    @Override
    public List<SessionDto> findSessionsByLinkid(Long linkid) throws Exception {
        List<Map<String, Object>> ss = sessionRepositary.getSessionDTOByLinkind(linkid);
        List<SessionDto> ret = NativeQueryConverter.convert(ss, SessionDto.class);
        return ret;
    }

//    public ResponseVo modifySessionSeat(String seat, String userid, Long sid) {
//        ResponseVo res = new ResponseVo();
//        res.setMessage("failed");
//        if (sessionRepositary.findById(sid).isPresent()) {
//            if (sessionRepositary.bookSession(seat, userid, sid) == 1) {
//                res.setMessage("update sucessfully");
//            }
//        }
//        return res;
//    }
}