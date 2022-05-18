package kr.co.thefc.bbl.service;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public class DBConnService {
    protected static final String NAMESPACE = "kr.co.onedatatech.bs_hdc.main_mapper.";

    @Autowired
    private SqlSession sqlSession;

    public String selectNow(){
        return sqlSession.selectOne(NAMESPACE + "selectNow");
    }


    public List<HashMap> select(String stat_id, HashMap map) {
        return sqlSession.selectList(NAMESPACE + stat_id, map);
    }

    public int insertWithReturnInt(String stat_id, HashMap map) {
        int rowcnt = sqlSession.insert(NAMESPACE + stat_id, map);
        System.out.println(map.toString());
        return Integer.parseInt(map.get("insertedID").toString());
    }

    public int insert(String stat_id, HashMap map) {
        return sqlSession.insert(NAMESPACE + stat_id, map);
    }

    public int insertList(String stat_id, List list) {
        return sqlSession.insert(NAMESPACE + stat_id, list);
    }

    public int update(String stat_id, HashMap map) {
        return sqlSession.update (NAMESPACE + stat_id, map);
    }

    public int delete(String stat_id, HashMap map) {
        return sqlSession.delete(NAMESPACE + stat_id, map);
    }
}