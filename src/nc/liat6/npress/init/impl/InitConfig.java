package nc.liat6.npress.init.impl;

import nc.liat6.frame.db.exception.DaoException;
import nc.liat6.frame.db.plugin.IInserter;
import nc.liat6.frame.db.transaction.ITrans;
import nc.liat6.frame.db.transaction.TransFactory;
import nc.liat6.frame.util.Dater;
import nc.liat6.npress.init.IInit;

/**
 * 配置初始化
 * 
 * @author 6tail
 * 
 */
public class InitConfig implements IInit{

  @Override
  public void init(){
    ITrans t = TransFactory.getTrans();
    try{
      if(t.getCounter().table("T_CONFIG").count()>0){
        t.rollback();
        t.close();
        return;
      }
    }catch(DaoException e){
    }
    IInserter ins = t.getInserter();
    ins.table("T_CONFIG");
    ins.set("C_KEY","CACHE_ENABLE");
    ins.set("C_VALUE","false");
    ins.set("C_NAME","开启缓存");
    ins.set("C_DESC","为true时开启缓存功能。");
    ins.insert();
    
    ins.set("C_KEY","WEB_NAME");
    ins.set("C_VALUE","Npress");
    ins.set("C_NAME","网站名");
    ins.set("C_DESC","");
    ins.insert();
    
    ins.set("C_KEY","WEB_AUTHOR");
    ins.set("C_VALUE","六特尔");
    ins.set("C_NAME","作者");
    ins.set("C_DESC","");
    ins.insert();
    
    ins.set("C_KEY","theme");
    ins.set("C_VALUE","basic");
    ins.set("C_NAME","主题");
    ins.set("C_DESC","默认为basic");
    ins.insert();
    
    ins.set("C_KEY","WEB_KEY");
    ins.set("C_VALUE","npress,java开源,blog");
    ins.set("C_NAME","关键词");
    ins.set("C_DESC","");
    ins.insert();
    
    ins.set("C_KEY","WEB_DESC");
    ins.set("C_VALUE","npress是六特尔基于NLF框架开发的一款java开源博客程序。");
    ins.set("C_NAME","描述");
    ins.set("C_DESC","");
    ins.insert();
    
    ins.set("C_KEY","WEB_COPYRIGHT");
    ins.set("C_VALUE","Copyrights "+Dater.year(Dater.now())+" &copy; 6tail.cn");
    ins.set("C_NAME","版权声明");
    ins.set("C_DESC","");
    ins.insert();
    
    ins.set("C_KEY","CACHE_DIR");
    ins.set("C_VALUE","cache");
    ins.set("C_NAME","缓存目录名");
    ins.set("C_DESC","");
    ins.insert();
    t.commit();
    t.close();
  }
}