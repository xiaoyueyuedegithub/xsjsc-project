package edu.etime.xsjsc.dao;

import edu.etime.xsjsc.pojo.Inform;

import java.util.List;

public interface InformMapper {
    List<Inform> listselectinform();
    int insert(Inform inform);
    int deleteinform(Integer id);
    int updateinform(Inform inform);
    Inform selectinformByid(Integer id);
    int updateByPrimaryKeySelective(Inform inform);
}
