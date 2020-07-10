package edu.etime.xsjsc.servcies.impl;

import edu.etime.xsjsc.dao.InformMapper;
import edu.etime.xsjsc.pojo.Inform;
import edu.etime.xsjsc.servcies.interfaces.InformService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/*通知服务层实现
 **/
@Service
public class InformServiceImpl implements InformService {
    @Autowired
    InformMapper informMapper;
    @Override
    public List<Inform> listselectinform() {
        return informMapper.listselectinform();
    }

    @Override
    public int insert(Inform inform) {
        return informMapper.insert(inform);
    }

    @Override
    public int deleteinform(Integer id) {
        return informMapper.deleteinform(id);
    }

    @Override
    public int updateinform(Inform inform) {
        return informMapper.updateinform(inform);
    }

    @Override
    public Inform selectinformByid(Integer id) {
        return informMapper.selectinformByid(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Inform inform) {
        return informMapper.updateByPrimaryKeySelective(inform);
    }
}
