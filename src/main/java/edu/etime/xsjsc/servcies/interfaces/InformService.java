package edu.etime.xsjsc.servcies.interfaces;

import edu.etime.xsjsc.pojo.Inform;

import java.util.List;

public interface InformService {
    List<Inform> listselectinform();
    int insert(Inform inform);
    int deleteinform(Integer id);
    int updateinform(Inform inform);
    Inform selectinformByid(Integer id);
    int updateByPrimaryKeySelective(Inform inform);
}
