package com.nofacebox.viewshow.Servic.Interface;

import com.nofacebox.viewshow.Entity.LinkPk;
import com.nofacebox.viewshow.Entity.Session;
import com.nofacebox.viewshow.Model.ResponseVo;
import com.nofacebox.viewshow.Model.SessionDto;

import java.util.List;

public interface ISessionService {

    public Session getSession(Long id) throws Exception;

    public Session saveSession(Session saveItem) throws Exception;

    public Session modifySession(Session modify, LinkPk linkPk) throws Exception;

    public ResponseVo deleteSession(Long id);

    public List<SessionDto> findSessionsByLinkid(Long linkid) throws Exception;

//    public ResponseVo modifySessionSeat(String seat,String userid,Long sid);
}
