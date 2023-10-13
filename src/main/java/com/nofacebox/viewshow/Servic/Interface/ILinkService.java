package com.nofacebox.viewshow.Servic.Interface;

import com.nofacebox.viewshow.Entity.Link;
import com.nofacebox.viewshow.Entity.LinkPk;
import com.nofacebox.viewshow.Entity.Movie;
import com.nofacebox.viewshow.Model.AdateDto;
import com.nofacebox.viewshow.Model.LinkDto;
import com.nofacebox.viewshow.Model.ResponseVo;
import com.nofacebox.viewshow.Model.ResultDto;

import java.util.Date;
import java.util.List;
import java.util.Set;

public interface ILinkService {
    public LinkPk getLink(Long id);

//    public Link getLinkByKeyword(String keyword);

    public LinkPk saveLink(LinkPk saveItem) throws Exception;

    public Link saveLink(Link saveItem) throws Exception;

    public LinkPk modifyLinkPk(LinkPk modify) throws Exception;

    public Link modifyLink(Link modify) throws Exception;

    public ResponseVo deleteLink(long id);

    public Long getLinkId(LinkPk pk) throws Exception;

    public Long getLinkId(Link pk) throws Exception;

    public List<ResultDto> findAllDatesByTheaterMovie(Long tid, Long mid);

    public List<ResultDto> findAllMoviesByTheater(Long tid);

    public List<LinkDto> findLinkDTOByTheater(Long tid);
}
